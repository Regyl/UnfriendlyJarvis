package com.github.regyl.unfriendlyjarvis.ujdictionaries.controller;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.controller.dto.ShortDictionaryDto;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.enumeration.DictionaryType;
import com.github.regyl.unfriendlyjarvis.ujdictionaries.service.DictionaryService;
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
    public Collection<? extends ShortDictionaryDto> getCatalogRecords(@RequestParam("catalog") DictionaryType catalog) {
        return dictionaryService.getCatalogRecords(catalog);
    }

}
