package com.github.regyl.unfriendlyjarvis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticDto {

    private Long allRussianRecords;

    private Long russianRelocatedRecords;

    private Long generalRecordsQuantity;

    private Long relocatedMales;

    private Long relocatedFemales;
}
