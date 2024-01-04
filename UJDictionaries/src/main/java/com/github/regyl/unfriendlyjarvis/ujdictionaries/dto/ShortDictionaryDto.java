package com.github.regyl.unfriendlyjarvis.ujdictionaries.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShortDictionaryDto {
    
    private UUID id;
    
    private String value;
    
    @JsonProperty("label")
    public String getLabel() {
        return value;
    }
}
