package com.github.regyl.unfriendlyjarvis.ujdictionaries.repository;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.CountryModel;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.DictionaryType;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends AbstractDictionaryRepository<CountryModel> {
    
    @Override
    default boolean accept(DictionaryType dictionaryType) {
        return DictionaryType.COUNTRY == dictionaryType;
    }
}
