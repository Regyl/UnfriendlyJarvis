package com.github.regyl.unfriendlyjarvis.configuration.datetime;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.function.Supplier;

@Component
public class DateTimeSupplierFactory {

    public static final ZoneOffset ZONE_OFFSET = ZoneOffset.UTC;

    @Bean
    public Supplier<OffsetDateTime> dateTimeSupplier() {
        return () -> OffsetDateTime.now(ZONE_OFFSET);
    }
}
