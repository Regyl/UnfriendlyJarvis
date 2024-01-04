package com.github.regyl.unfriendlyjarvis.ujdictionaries.repository;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.CityModel;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.DictionaryType;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends AbstractDictionaryRepository<CityModel> {
    
    @Override
    default boolean accept(DictionaryType dictionaryType) {
        return DictionaryType.CITY == dictionaryType;
    }
}
