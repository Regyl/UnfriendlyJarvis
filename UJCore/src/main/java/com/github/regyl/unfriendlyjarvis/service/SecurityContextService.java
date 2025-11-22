package com.github.regyl.unfriendlyjarvis.service;

import com.github.regyl.unfriendlyjarvis.entity.Account;

public interface SecurityContextService {

    Account getAuthorizedAccount();
}
