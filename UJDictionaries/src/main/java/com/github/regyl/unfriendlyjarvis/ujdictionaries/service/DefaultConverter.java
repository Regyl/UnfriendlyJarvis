package com.github.regyl.unfriendlyjarvis.ujdictionaries.service;

public interface DefaultConverter<T, S> extends DefaultDictionaryPredicate {
    
    S convert(T source);
}
