package com.github.regyl.unfriendlyjarvis.ujdictionaries.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DataSourceDto extends ShortDictionaryDto {

    private LocalDate since;

    private String url;

    private String description;
}
