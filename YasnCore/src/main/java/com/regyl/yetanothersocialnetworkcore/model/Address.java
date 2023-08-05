package com.regyl.yetanothersocialnetworkcore.model;

import com.regyl.yetanothersocialnetworkcore.model.enums.AddressType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
@EqualsAndHashCode(callSuper = true)
public class Address extends AbstractEntity {

    @ManyToOne
    private Person person;

    @Column(name = "value", nullable = false)
    private String value;

    @Column(name = "type", columnDefinition = "VARCHAR(30) NOT NULL DEFAULT 'OTHER'")
    private AddressType type;
}
