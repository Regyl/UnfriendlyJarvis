package com.github.regyl.unfriendlyjarvis.model;

import com.github.regyl.unfriendlyjarvis.model.enums.OAuthProviderType;
import com.github.regyl.unfriendlyjarvis.model.enums.Scope;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Permitted user's OAuth 2.0 scopes.
 */
@Data
@Entity
@Table(name = "scope", uniqueConstraints = @UniqueConstraint(columnNames = {"value", "provider"}))
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ScopeEntity extends AbstractEntity implements ScopeDetails {
    
    @NotEmpty
    @Column(name = "value", nullable = false)
    @Enumerated(EnumType.STRING)
    private Scope value;
    
    @NotNull
    @Column(name = "provider", nullable = false)
    @Enumerated(EnumType.STRING)
    private OAuthProviderType provider;
    
    @Override
    public String getScope() {
        return value.name();
    }
    
    @Override
    public String getProvider() {
        return provider.name();
    }
}
