package com.example.coding.demo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {


    public static final String CACHE_KEY_NAME = "employee";

    @Bean
    public CacheManager  getCacheManager(){
        return new ConcurrentMapCacheManager(CACHE_KEY_NAME);
    }
}
