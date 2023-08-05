package com.github.regyl.unfriendlyjarvis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.regyl.unfriendlyjarvis.dto.StatisticDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class StatisticsIntegrationTest extends TestcontainersConfig {

    static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @Test
    void countShouldReturnResult() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/statistics/count")).andReturn();

        byte[] resultArray = mvcResult.getResponse().getContentAsByteArray();
        assertThat(resultArray).isNotNull();
        StatisticDto statisticDto = OBJECT_MAPPER.readValue(resultArray, StatisticDto.class);
        assertThat(statisticDto.getGeneralRecordsQuantity()).isNotNull();
    }
}
