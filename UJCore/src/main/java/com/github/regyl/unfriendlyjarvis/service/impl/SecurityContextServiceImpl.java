package com.github.regyl.unfriendlyjarvis.service.impl;

import com.github.regyl.unfriendlyjarvis.entity.Account;
import com.github.regyl.unfriendlyjarvis.service.SecurityContextService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityContextServiceImpl implements SecurityContextService {

    private static final Account MOCK;

    static {
        MOCK = new Account();
        MOCK.setId(1L);
        MOCK.setLogin("Regyl");
        MOCK.setYandexMusicUserId(1430257434L);
    }

    @Override
    public Account getAuthorizedAccount() {
        return MOCK;
    }
}
