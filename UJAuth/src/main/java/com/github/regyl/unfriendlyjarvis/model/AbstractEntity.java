package com.github.regyl.unfriendlyjarvis.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Abstract entity.
 * <p>
 * This class is used to provide common fields to all entities. Default id type is {@link UUID}.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@OnDelete(action = OnDeleteAction.CASCADE)
public abstract class AbstractEntity {

    //TODO change to custom scalable generator
    @Id
    @GeneratedValue
    private UUID id;

    @CreationTimestamp
    @Column(name = "creation_date_time", nullable = false)
    private OffsetDateTime creationDateTime;

    @UpdateTimestamp
    @Column(name = "update_date_time", nullable = false)
    private OffsetDateTime updateDateTime;
}
