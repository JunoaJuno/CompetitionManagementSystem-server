package com.juno.competitionmanagementsystemserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "wx")
@Data
public class WxConfig {

    private WxKey officialAccounts;

    private WxKey miniProgram;

    @Data
    public static class WxKey {
        private String appid;
        private String secret;
    }
}
