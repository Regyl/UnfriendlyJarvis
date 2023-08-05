package com.github.regyl.unfriendlyjarvis.model;

import java.util.Set;

/**
 * OAuth user details.
 */
public interface OAuthUserDetails {
    
    /**
     * Returns the user permitted scopes.
     *
     * @return the user permitted scopes
     */
    Set<? extends ScopeDetails> getScopes();
}
