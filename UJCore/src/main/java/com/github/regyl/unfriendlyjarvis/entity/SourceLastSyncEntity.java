package com.github.regyl.unfriendlyjarvis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "e_source_last_sync")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class SourceLastSyncEntity extends AbstractEntity {

    /**
     * Account owner of the meme.
     */
    @NotNull
    @Column(name = "accountId", unique = true, nullable = false)
    private Long accountId;

    @NotNull
    private LocalDate lastSyncDate;
}
