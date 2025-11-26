package com.github.regyl.unfriendlyjarvis.service.impl.meme;

import com.github.regyl.unfriendlyjarvis.entity.Account;
import com.github.regyl.unfriendlyjarvis.entity.MemeEntity;
import com.github.regyl.unfriendlyjarvis.entity.enums.Source;
import com.github.regyl.unfriendlyjarvis.service.SecurityContextService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.function.BiFunction;
import java.util.function.Supplier;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemeEntityMapperServiceImpl implements BiFunction<String, String, MemeEntity> {

    private final Supplier<OffsetDateTime> dateTimeSupplier;
    private final SecurityContextService securityContextService;

    @Override
    public MemeEntity apply(String s1, String s2) {
        Account account = securityContextService.getAuthorizedAccount();

        return MemeEntity.builder()
                .account(account)
                .bucketPath(s1)
                .source(parseSource(s2))
                .created(dateTimeSupplier.get())
                .build();
    }

    /**
     * Parse source string to Source enum.
     * Returns OTHER if source is null or invalid.
     *
     * @param source source string
     * @return Source enum
     */
    private Source parseSource(String source) {
        if (source == null || source.isBlank()) {
            return Source.OTHER;
        }
        try {
            return Source.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            log.warn("Invalid source value: {}, using OTHER", source);
            return Source.OTHER;
        }
    }
}
