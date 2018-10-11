package com.lk.java.spring.overrideparam;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Service;

import com.lk.java.guava.eventbus.OrderEventListener;

/**
 * @author:gaoguangjin
 * @date:2017/10/31
 */
@Service
@Slf4j
public class PropertiestService implements BeanFactoryPostProcessor {
    @Value("${lion.test.url}")
    private String url;
    private final static Logger log = LoggerFactory.getLogger(PropertiestService.class);
    public String test() {
        return url;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanNames = configurableListableBeanFactory.getBeanDefinitionNames();
        log.info("BeanFactoryPostProcessor 2");
    }
}
