package com.github.regyl.unfriendlyjarvis.ujdictionaries.api;

public interface DefaultConverter<T, S> extends DefaultDictionaryPredicate {
    
    S convert(T source);
}
