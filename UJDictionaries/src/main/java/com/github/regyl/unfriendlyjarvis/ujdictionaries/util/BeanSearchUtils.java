package com.github.regyl.unfriendlyjarvis.ujdictionaries.util;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.enumeration.DictionaryType;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.exception.UnfriendlyJarvisException;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.service.DictionaryPredicate;

import java.util.Collection;

public final class BeanSearchUtils {
    
    public static <T extends DictionaryPredicate> T getBean(Collection<T> beans, DictionaryType dictionaryType) {
        return beans.stream()
                .filter(item -> item.test(dictionaryType))
                .findFirst()
                .orElseThrow(() -> new UnfriendlyJarvisException(String.format("Dictionary of type %s not found", dictionaryType)));
    }
}
