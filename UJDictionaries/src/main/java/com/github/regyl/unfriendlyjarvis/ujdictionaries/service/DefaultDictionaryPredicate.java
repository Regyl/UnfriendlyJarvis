package com.github.regyl.unfriendlyjarvis.ujdictionaries.service;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.enumeration.DictionaryType;

public interface DefaultDictionaryPredicate {
    
    boolean accept(DictionaryType dictionaryType);
}
