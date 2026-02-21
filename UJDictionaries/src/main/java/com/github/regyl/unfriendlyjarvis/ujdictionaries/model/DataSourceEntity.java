package com.github.regyl.unfriendlyjarvis.ujdictionaries.model;

import com.github.regyl.unfriendlyjarvis.ujdictionaries.enumeration.DictionaryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "data_source")
@EqualsAndHashCode(callSuper = true)
public class DataSourceEntity extends AbstractDictionary {
    
    @Column(name = "since", nullable = false)
    private LocalDate since;
    
    @Column(name = "url")
    private String url;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Override
    public DictionaryType getDictionaryType() {
        return DictionaryType.DATA_SOURCE;
    }
}
