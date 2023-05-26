package com.example.sampleeventapplication.aop;

import com.example.sampleeventapplication.common.ThreadContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EventThreadAspect {

    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void controller() {
    }

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restController() {
    }

    @Around("controller() || restController()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        ThreadContext.clearEventThread();
        ThreadContext.initEventThread();

        return joinPoint.proceed();
    }
}

