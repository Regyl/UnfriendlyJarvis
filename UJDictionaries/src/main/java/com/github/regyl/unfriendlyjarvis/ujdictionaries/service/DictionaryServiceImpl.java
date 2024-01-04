package com.github.regyl.unfriendlyjarvis.ujdictionaries.service;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.api.DefaultConverter;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.api.DictionaryService;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.dto.ShortDictionaryDto;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.AbstractDictionary;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.DictionaryType;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.repository.AbstractDictionaryRepository;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.util.BeanSearchUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
@SuppressWarnings({"unchecked", "rawtypes"})
public class DictionaryServiceImpl implements DictionaryService {
    
    private final Collection<DefaultConverter<? extends AbstractDictionary, ShortDictionaryDto>> dictionaryConverters;
    private final Collection<AbstractDictionaryRepository> dictionaryRepositories;
    
    @Override
    public List<ShortDictionaryDto> getCatalogRecords(DictionaryType dictionaryType) {
        AbstractDictionaryRepository repository = BeanSearchUtils.getBean(dictionaryRepositories, dictionaryType);
        DefaultConverter converter = BeanSearchUtils.getBean(dictionaryConverters, dictionaryType);
        
        return repository.findAll().stream()
                .map(converter::convert)
                .toList();
    }
}
