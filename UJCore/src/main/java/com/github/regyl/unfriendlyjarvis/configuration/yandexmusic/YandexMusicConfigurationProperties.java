package com.github.regyl.unfriendlyjarvis.configuration.yandexmusic;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.application.services.yandex-music")
public class YandexMusicConfigurationProperties {

    private int trackFetchBatchSize;
}
