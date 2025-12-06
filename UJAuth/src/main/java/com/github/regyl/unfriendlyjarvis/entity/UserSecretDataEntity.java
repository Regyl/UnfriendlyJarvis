package com.github.regyl.unfriendlyjarvis.entity;

import com.github.regyl.unfriendlyjarvis.enumeration.UserSecretKey;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Entity for storing user's sensitive data in key-value format.
 * Stores API keys, unique identifiers in external services, etc.
 */
@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "e_user_secret_data", 
       uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "key"}))
@EqualsAndHashCode(callSuper = true)
public class UserSecretDataEntity extends AbstractEntity {
    
    /**
     * User who owns this secret data.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    
    /**
     * Key identifying the type of secret data.
     * Must not exceed 128 characters.
     */
    @NotNull
    @Column(name = "key", nullable = false, length = 128)
    @Enumerated(EnumType.STRING)
    private UserSecretKey key;
    
    /**
     * Encrypted or plain value of the secret data.
     */
    @NotNull
    @Column(name = "value", nullable = false, length = 512)
    private String value;
}

