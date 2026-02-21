package com.github.regyl.unfriendlyjarvis.ujdictionaries.service;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.controller.dto.ShortDictionaryDto;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.enumeration.DictionaryType;

import java.util.List;

public interface DictionaryService {
    
    List<? extends ShortDictionaryDto> getCatalogRecords(DictionaryType dictionaryType);
}
