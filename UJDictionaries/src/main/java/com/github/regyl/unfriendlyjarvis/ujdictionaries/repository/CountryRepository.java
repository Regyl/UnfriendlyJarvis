package com.github.regyl.unfriendlyjarvis.ujdictionaries.repository;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.enumeration.DictionaryType;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.CountryEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends AbstractDictionaryRepository<CountryEntity> {
    
    @Override
    default boolean test(DictionaryType dictionaryType) {
        return DictionaryType.COUNTRY == dictionaryType;
    }
}
