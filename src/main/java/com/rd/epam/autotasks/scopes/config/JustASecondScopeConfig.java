package com.rd.epam.autotasks.scopes.config;

import com.rd.epam.autotasks.scopes.config.postProcessor.Scopes.BeenFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JustASecondScopeConfig {
    @Bean
    public BeenFactoryPostProcessor beenFactoryPostProcessor(){

        return new BeenFactoryPostProcessor();
    }


}
