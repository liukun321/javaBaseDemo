package com.lk.java.spring.xml;

import com.lk.java.spring.overrideparam.Person;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/2/19 9:47
 */
@Configuration
public class MyBeanConfig {

    @Bean(initMethod = "myInit", destroyMethod = "myDestory")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Person getPerson(){
     return new Person();
    }
}
