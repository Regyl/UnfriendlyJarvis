package com.github.regyl.unfriendlyjarvis.ujdictionaries.repository;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.enumeration.DictionaryType;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.CityEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends AbstractDictionaryRepository<CityEntity> {
    
    @Override
    default boolean test(DictionaryType dictionaryType) {
        return DictionaryType.CITY == dictionaryType;
    }
}
