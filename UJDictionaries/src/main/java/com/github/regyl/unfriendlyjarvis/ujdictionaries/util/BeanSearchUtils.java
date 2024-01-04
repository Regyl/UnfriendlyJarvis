package com.github.regyl.unfriendlyjarvis.ujdictionaries.util;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.api.DefaultDictionaryPredicate;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.exception.UnfriendlyJarvisException;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.DictionaryType;

import java.util.Collection;

public final class BeanSearchUtils {
    
    public static <T extends DefaultDictionaryPredicate> T getBean(Collection<T> beans, DictionaryType dictionaryType) {
        return beans.stream()
                .filter(item -> item.accept(dictionaryType))
                .findFirst()
                .orElseThrow(() -> new UnfriendlyJarvisException(String.format("Dictionary of type %s not found", dictionaryType)));
    }
}
