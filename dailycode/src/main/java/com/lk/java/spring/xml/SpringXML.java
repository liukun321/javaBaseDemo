package com.lk.java.spring.xml;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@Component
@ImportResource(locations = {"classpath:overrideparam.xml"})
@Slf4j
public class SpringXML implements BeanFactoryPostProcessor {
	private final static Logger log = LoggerFactory.getLogger(SpringXML.class);
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanNames = configurableListableBeanFactory.getBeanDefinitionNames();
        log.info("BeanFactoryPostProcessor 1");
    }
}
