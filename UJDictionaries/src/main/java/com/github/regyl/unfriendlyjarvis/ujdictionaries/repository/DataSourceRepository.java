package com.github.regyl.unfriendlyjarvis.ujdictionaries.repository;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.enumeration.DictionaryType;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.DataSourceEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSourceRepository extends AbstractDictionaryRepository<DataSourceEntity> {
    
    @Override
    default boolean test(DictionaryType dictionaryType) {
        return DictionaryType.DATA_SOURCE == dictionaryType;
    }
}
