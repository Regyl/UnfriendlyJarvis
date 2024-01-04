package com.github.regyl.unfriendlyjarvis.ujdictionaries.api;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.dto.ShortDictionaryDto;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.DictionaryType;

import java.util.List;

public interface DictionaryService {
    
    List<ShortDictionaryDto> getCatalogRecords(DictionaryType dictionaryType);
}
