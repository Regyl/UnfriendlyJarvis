package com.github.regyl.unfriendlyjarvis.ujdictionaries.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country")
@EqualsAndHashCode(callSuper = true)
public class CountryModel extends AbstractDictionary {
    
    @Column
    private String alpha;
    
    @Override
    public DictionaryType getDictionaryType() {
        return DictionaryType.COUNTRY;
    }
}
