package com.github.regyl.unfriendlyjarvis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "e_login")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "account"})
public class LoginEntity extends AbstractEntity {

    @NotNull
    @ManyToOne(cascade = CascadeType.REFRESH, optional = false, fetch = FetchType.LAZY)
    private Account account;

    @Column(columnDefinition = "VARCHAR(500)")
    private String originUrl;

    private String usernameType;

    private String usernameValue;

    /**
     * Differs from {@link AbstractEntity#created}.
     * This one is business, e.g. when the account registered.
     * In {@link AbstractEntity} created is when record was inserted.
     */
    private OffsetDateTime loginCreated;

    private Boolean inBlacklist;

    private Long timesUsed;

    private OffsetDateTime lastUsed;

    private OffsetDateTime passwordLastModified;
}
