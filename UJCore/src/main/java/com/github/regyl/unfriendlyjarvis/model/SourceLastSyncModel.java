package com.github.regyl.unfriendlyjarvis.model;

import com.github.regyl.unfriendlyjarvis.entity.enums.Source;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class SourceLastSyncModel {

    private Long accountId;
    private LocalDate lastSyncDate;
    private Source source;
}
