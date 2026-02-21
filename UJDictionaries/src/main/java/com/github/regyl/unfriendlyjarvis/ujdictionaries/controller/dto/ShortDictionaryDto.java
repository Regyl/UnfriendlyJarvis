package com.github.regyl.unfriendlyjarvis.ujdictionaries.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ShortDictionaryDto {
    
    private UUID id;
    
    private String value;
}
