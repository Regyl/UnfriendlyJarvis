package com.github.regyl.unfriendlyjarvis.ujdictionaries.service.converter;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.api.DefaultConverter;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.dto.ShortDictionaryDto;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.CityModel;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.DictionaryType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CityToShortDictionaryDtoConverter extends DefaultConverter<CityModel, ShortDictionaryDto> {
    
    @Override
    default boolean accept(DictionaryType dictionaryType) {
        return DictionaryType.CITY == dictionaryType;
    }
}
