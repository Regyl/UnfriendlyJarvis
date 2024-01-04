package com.github.regyl.unfriendlyjarvis.ujdictionaries.service.converter;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.api.DefaultConverter;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.dto.ShortDictionaryDto;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.CountryModel;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.DictionaryType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryToShortDictionaryDtoConverter extends DefaultConverter<CountryModel, ShortDictionaryDto> {
    
    @Override
    default boolean accept(DictionaryType dictionaryType) {
        return DictionaryType.COUNTRY == dictionaryType;
    }
}
