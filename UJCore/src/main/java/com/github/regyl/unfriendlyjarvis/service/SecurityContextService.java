package com.github.regyl.unfriendlyjarvis.service;

import com.github.regyl.unfriendlyjarvis.model.AccountModel;

public interface SecurityContextService {

    AccountModel getAuthorizedAccount();

    Long getUserId();
}
