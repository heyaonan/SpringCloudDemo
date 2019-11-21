package com.nice.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
public class Constant {
    @Value("${spring.datasource.driver-class-name}")
    private String driver;

}
