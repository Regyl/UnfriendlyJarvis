package com.github.regyl.unfriendlyjarvis.ujdictionaries.enumeration;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.controller.dto.DataSourceDto;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.controller.dto.ShortDictionaryDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DictionaryType {
    
    COUNTRY(ShortDictionaryDto.class),
    CITY(ShortDictionaryDto.class),
    DATA_SOURCE(DataSourceDto.class),

    ;

    private final Class<? extends ShortDictionaryDto> clazz;
}
