package org.jxch.capital.gui.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.setting")
public class AppSettingConfig {
    private Proxy proxy;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Proxy {
        private String host;
        private Integer port;
    }

}
