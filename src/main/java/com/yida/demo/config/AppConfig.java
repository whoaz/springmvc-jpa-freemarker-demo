package com.yida.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by helloz on 2016/7/27.
 */
@Configuration

@ComponentScan(basePackages={"com.yida.demo"},
        excludeFilters=@ComponentScan.Filter(type=FilterType.REGEX, pattern={"com.yida.demo.controller.*"}))
@PropertySource(value = {"classpath:config.properties"})
@EnableScheduling
@EnableAspectJAutoProxy
@EnableCaching
public class AppConfig {
    @Autowired
    private Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }


}
