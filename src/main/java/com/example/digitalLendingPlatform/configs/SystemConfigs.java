package com.example.digitalLendingPlatform.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties("dlp")
public class SystemConfigs {
    private int successStatusCode;
    private int failedStatusCode;
    private String successStatusMessage;
}
