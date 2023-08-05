package com.github.regyl.unfriendlyjarvis.service;

import com.github.regyl.unfriendlyjarvis.api.StatisticsService;
import com.github.regyl.unfriendlyjarvis.dto.StatisticDto;
import com.github.regyl.unfriendlyjarvis.model.enums.Gender;
import com.github.regyl.unfriendlyjarvis.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final PersonRepository personRepository;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Cacheable("statistics")
    public StatisticDto count() {
        StatisticDto dto = StatisticDto.builder()
                .allRussianRecords(personRepository.countByIsRussianTrue())
                .russianRelocatedRecords(personRepository.countRussianRelocated())
                .relocatedMales(personRepository.countByIsRussianTrueAndGender(Gender.MALE))
                .relocatedFemales(personRepository.countByIsRussianTrueAndGender(Gender.FEMALE))
                .build();

        jdbcTemplate.query("SELECT reltuples AS estimate FROM pg_class where relname = 'person'",
                (RowCallbackHandler) (rs) -> dto.setGeneralRecordsQuantity(rs.getLong(1)));

        log.info("dto: " + dto.toString());
        return dto;
    }


}
