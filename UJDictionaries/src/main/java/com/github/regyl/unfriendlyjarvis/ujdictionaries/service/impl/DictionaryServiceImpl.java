package com.github.regyl.unfriendlyjarvis.ujdictionaries.service.impl;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.controller.dto.ShortDictionaryDto;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.enumeration.DictionaryType;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.AbstractDictionary;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.repository.AbstractDictionaryRepository;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.service.DictionaryService;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.service.mapper.DefaultMapper;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.util.BeanSearchUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
@SuppressWarnings({"unchecked", "rawtypes"})
public class DictionaryServiceImpl implements DictionaryService {
    
    private final Collection<DefaultMapper<? extends AbstractDictionary, ? extends ShortDictionaryDto>> dictionaryConverters;
    private final Collection<AbstractDictionaryRepository> dictionaryRepositories;
    
    @Override
    public List<? extends ShortDictionaryDto> getCatalogRecords(DictionaryType dictionaryType) {
        AbstractDictionaryRepository repository = BeanSearchUtils.getBean(dictionaryRepositories, dictionaryType);
        DefaultMapper converter = BeanSearchUtils.getBean(dictionaryConverters, dictionaryType);
        
        return repository.findAll().stream()
                .map(converter::apply)
                .toList();
    }
}
