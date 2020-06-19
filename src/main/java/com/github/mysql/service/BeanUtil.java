package com.github.mysql.service;

import com.sun.org.apache.xalan.internal.utils.ObjectFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author shao
 */
@Service
public class BeanUtil implements ApplicationContextAware {

    private static ApplicationContext context;
    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
        applicationContext.getBeansOfType(ObjectFactory.class);
    }
    public static <T> @NotNull T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }
}