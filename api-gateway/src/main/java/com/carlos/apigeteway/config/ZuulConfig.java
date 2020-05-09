package com.carlos.apigeteway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/9 17:03
 */
@Component
public class ZuulConfig {

    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }

}
