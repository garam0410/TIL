package com.example.customtablegeneratorproject.component;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationContext implements ApplicationContextAware {

    private static ApplicationContext CONTEXT;

    public static <T> T getBean(Class<T> requiredType) {
        if (CONTEXT == null) {
            return null;
        }
        return CONTEXT.getBean(requiredType);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        CONTEXT = context;
    }
}
