package com.github.regyl.unfriendlyjarvis.service.impl.login;

import com.github.regyl.unfriendlyjarvis.entity.LoginEntity;
import com.github.regyl.unfriendlyjarvis.model.LoginModel;
import com.github.regyl.unfriendlyjarvis.service.SecurityContextService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class LoginModelToLoginEntityMapperServiceImpl implements Function<LoginModel, LoginEntity> {

    private final Supplier<OffsetDateTime> dateTimeSupplier;
    private final SecurityContextService securityContextService;

    @Override
    public LoginEntity apply(LoginModel model) {
        return LoginEntity.builder()
                .originUrl(model.getOriginUrl())
                .usernameType(model.getUsernameType())
                .usernameValue(model.getUsernameValue())
                .loginCreated(model.getLoginCreated())
                .inBlacklist(model.getInBlacklist())
                .timesUsed(model.getTimesUsed())
                .lastUsed(model.getLastUsed())
                .passwordLastModified(model.getPasswordLastModified())
                .source(model.getSource())
                .account(securityContextService.getAuthorizedAccount())
                .created(dateTimeSupplier.get())
                .build();
    }
}
