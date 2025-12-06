package com.github.regyl.unfriendlyjarvis.service;

import com.github.regyl.unfriendlyjarvis.enumeration.UserSecretKey;

import java.util.Optional;

public interface SecurityContextService {

    Optional<String> getAuthorizedUserSecret(UserSecretKey key);

    Long getUserId();
}
