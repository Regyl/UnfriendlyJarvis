package com.github.regyl.unfriendlyjarvis.ujdictionaries.service.impl.mapper;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.controller.dto.DataSourceDto;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.enumeration.DictionaryType;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.DataSourceEntity;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.service.mapper.DefaultMapper;
import org.springframework.stereotype.Component;

@Component
public class DataSourceEntityToDataSourceDtoMapperServiceImpl implements DefaultMapper<DataSourceEntity, DataSourceDto> {
    
    @Override
    public DataSourceDto apply(DataSourceEntity source) {
        return DataSourceDto.builder()
                .id(source.getId())
                .value(source.getValue())
                .url(source.getUrl())
                .since(source.getSince())
                .description(source.getDescription())
                .build();
    }
    
    @Override
    public boolean test(DictionaryType dictionaryType) {
        return DictionaryType.DATA_SOURCE == dictionaryType;
    }
}
