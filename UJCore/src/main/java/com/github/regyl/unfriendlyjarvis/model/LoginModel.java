package com.github.regyl.unfriendlyjarvis.model;

import com.github.regyl.unfriendlyjarvis.entity.AbstractEntity;
import com.github.regyl.unfriendlyjarvis.entity.enums.Source;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class LoginModel {

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

    private Source source;
}
