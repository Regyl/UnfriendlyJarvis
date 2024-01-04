package com.github.regyl.unfriendlyjarvis.ujdictionaries.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
@EqualsAndHashCode(callSuper = true)
public class CityModel extends AbstractDictionary {
    
    @NotNull
    @ManyToOne(optional = false)
    private CountryModel country;
    
    @Override
    public DictionaryType getDictionaryType() {
        return DictionaryType.CITY;
    }
}
