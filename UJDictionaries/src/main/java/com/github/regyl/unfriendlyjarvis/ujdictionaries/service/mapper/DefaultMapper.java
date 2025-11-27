package com.github.regyl.unfriendlyjarvis.ujdictionaries.service.mapper;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.service.DictionaryPredicate;

import java.util.function.Function;

public interface DefaultMapper<T, S> extends DictionaryPredicate, Function<T, S> {

}
