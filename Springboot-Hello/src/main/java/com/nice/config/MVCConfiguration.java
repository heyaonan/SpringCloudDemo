package com.nice.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class MVCConfiguration {

    @Bean
    public HttpMessageConverters fastJsonConverTers(){
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //配置fastjson
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
        config.setSerializerFeatures(SerializerFeature.WriteNullListAsEmpty);
        config.setSerializerFeatures(SerializerFeature.WriteNullStringAsEmpty);
        config.setSerializerFeatures(SerializerFeature.WriteNullBooleanAsFalse);
        config.setSerializerFeatures(SerializerFeature.WriteDateUseDateFormat);
        fastJsonHttpMessageConverter.setFastJsonConfig(config);
        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
        return new HttpMessageConverters(converter);
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INFO/page");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
