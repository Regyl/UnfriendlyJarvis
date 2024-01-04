package com.github.regyl.unfriendlyjarvis.ujdictionaries.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@OnDelete(action = OnDeleteAction.CASCADE)
public abstract class AbstractDictionary {
    
    @Id
    @GeneratedValue
    private UUID id;
    
    @NotEmpty
    @Column(name = "value", nullable = false)
    private String value;
    
    @Column(name = "archived", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean archived;
    
    public abstract DictionaryType getDictionaryType();
}
