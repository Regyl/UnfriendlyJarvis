package com.github.regyl.unfriendlyjarvis.service.impl.login.google;

import com.github.regyl.unfriendlyjarvis.entity.enums.Source;
import com.github.regyl.unfriendlyjarvis.model.LoginModel;
import com.github.regyl.unfriendlyjarvis.util.FormatUtils;
import com.github.regyl.unfriendlyjarvis.util.WebKitUtils;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GoogleLoginCsvRowToLoginModelMapperServiceImpl implements Function<String, LoginModel> {

    private static final String DELIMITER = ",";

    @Override
    public LoginModel apply(String s) {
        String[] values = s.split(DELIMITER);
        return LoginModel.builder()
                .originUrl(FormatUtils.getUrlDomain(values[0]))
                .usernameType(values[1])
                .usernameValue(values[2])
                .loginCreated(WebKitUtils.fromWebkitMicros(values[3]))
                .inBlacklist(WebKitUtils.fromWebkitBoolean(values[4]))
                .timesUsed(Long.parseLong(values[5]))
                .lastUsed(WebKitUtils.fromWebkitMicros(values[7]))
                .passwordLastModified(WebKitUtils.fromWebkitMicros(values[8]))
                .source(Source.GOOGLE_PASSWORD_MANAGER)
                .build();
    }
}
