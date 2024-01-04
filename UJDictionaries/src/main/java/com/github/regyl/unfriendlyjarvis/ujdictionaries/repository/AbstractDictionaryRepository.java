package com.github.regyl.unfriendlyjarvis.ujdictionaries.repository;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.api.DefaultDictionaryPredicate;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.AbstractDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface AbstractDictionaryRepository<T extends AbstractDictionary> extends JpaRepository<T, UUID>, DefaultDictionaryPredicate {
}
