package com.github.regyl.unfriendlyjarvis.ujdictionaries.controller;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.api.DictionaryService;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.dto.ShortDictionaryDto;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.model.DictionaryType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class DictionaryController {

    private final DictionaryService dictionaryService;
    
    @GetMapping("/list")
    public Collection<ShortDictionaryDto> getCatalogRecords(@RequestParam DictionaryType catalog) {
        return dictionaryService.getCatalogRecords(catalog);
    }

}
