package com.yida.demo.config;

import freemarker.template.utility.XmlEscape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by helloz on 2016/7/27.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.yida.demo.controller"})
public class MvcConfig extends WebMvcConfigurerAdapter {
    private Logger logger = LoggerFactory.getLogger(MvcConfig.class);


    @Bean
    public HandlerAdapter handlerAdapter() {
        logger.info("=======init HandlerAdapter==========");

        RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();

        List<HttpMessageConverter<?>> converters = new ArrayList<>();

        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(stringHttpMessageConverter);

        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        jackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        jackson2HttpMessageConverter.setPrettyPrint(true);
        converters.add(jackson2HttpMessageConverter);

        handlerAdapter.setMessageConverters(converters);

        return handlerAdapter;
    }

    @Bean
    public MultipartResolver multipartResolver() {
        logger.info("=======init MultipartResolver==========");

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(-1);
        multipartResolver.setDefaultEncoding("UTF-8");
        return multipartResolver;
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        logger.info("=======init FreeMarkerConfigurer==========");

        FreeMarkerConfigurer config = new FreeMarkerConfigurer();
        config.setTemplateLoaderPath("/WEB-INF/templates/");
        config.setDefaultEncoding("UTF-8");
        Map<String, Object> map = new HashMap<>();
        map.put("xml_escape", new XmlEscape());
        config.setFreemarkerVariables(map);
        return config;
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.ignoreUnknownPathExtensions(false).defaultContentType(MediaType.TEXT_HTML);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.freeMarker();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
