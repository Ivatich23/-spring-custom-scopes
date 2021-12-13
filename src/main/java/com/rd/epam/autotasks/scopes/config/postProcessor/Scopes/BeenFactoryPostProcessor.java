package com.rd.epam.autotasks.scopes.config.postProcessor.Scopes;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeenFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        factory.registerScope("threeTimes", new ThreeTimes());
        factory.registerScope("thread", new ThreadScope());
        factory.registerScope("justASecond", new JustASecondScope());
    }
}
