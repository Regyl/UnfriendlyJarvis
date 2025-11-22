package com.github.regyl.unfriendlyjarvis.util;

import com.github.regyl.unfriendlyjarvis.configuration.datetime.DateTimeSupplierFactory;
import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

@UtilityClass
public class WebKitUtils {

    private static final Instant WEBKIT_EPOCH =
            LocalDateTime.of(1601, 1, 1, 0, 0).atZone(ZoneId.of("UTC")).toInstant();

    public static OffsetDateTime fromWebkitMicros(long microseconds) {
        Instant result = WEBKIT_EPOCH.plus(microseconds, ChronoUnit.MICROS);
        LocalDateTime ldt = LocalDateTime.ofInstant(result, ZoneId.of("UTC")); //FIXME get user's zone id
        return OffsetDateTime.of(ldt, DateTimeSupplierFactory.ZONE_OFFSET);
    }

    public static OffsetDateTime fromWebkitMicros(String microseconds) {
        long result = Long.parseLong(microseconds);
        return fromWebkitMicros(result);
    }

    public static boolean fromWebkitBoolean(String bool) {
        return "1".equals(bool);
    }
}
