package com.github.regyl.unfriendlyjarvis.ujdictionaries.api;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.DictionaryType;

public interface DefaultDictionaryPredicate {
    
    boolean accept(DictionaryType dictionaryType);
}
