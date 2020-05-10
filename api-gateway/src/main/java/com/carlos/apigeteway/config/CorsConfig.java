package com.carlos.apigeteway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

/**
 * 跨域配置
 *
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/10 13:09
 * C - Cross O - Origin R - Resource S - Sharing
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        final CorsConfiguration config = new CorsConfiguration();

        // 是否支持 cookie 跨域
        config.setAllowCredentials(true);
        // 原始域
        // http://www.a.com
        config.setAllowedOrigins(Collections.singletonList("*"));
        // 允许的请求头
        config.setAllowedHeaders(Collections.singletonList("*"));
        // 允许的请求方法
        config.setAllowedMethods(Collections.singletonList("*"));
        // 相同请求时间
        config.setMaxAge(300L);

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }

}
