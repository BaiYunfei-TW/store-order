package com.example.storeorder.config;

import feign.Contract;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Value("${spring.application.name}")
    private String serverName;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new ServerAuthenticationInterceptor();
    }

    private class ServerAuthenticationInterceptor implements RequestInterceptor {

        @Override
        public void apply(RequestTemplate template) {
            template.header("x-server-auth", serverName);
        }
    }

}
