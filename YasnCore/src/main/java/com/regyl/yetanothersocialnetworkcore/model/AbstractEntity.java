package com.regyl.yetanothersocialnetworkcore.model;

import com.regyl.yetanothersocialnetworkcore.model.enums.Source;
import jakarta.persistence.*;
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
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "source", columnDefinition = "VARCHAR(50) NOT NULL DEFAULT 'OTHER'")
    @Enumerated(EnumType.STRING)
    private Source source;
}
