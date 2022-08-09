package com.example.core.exception.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Configuration
public class LoggerAspect {
    
    // logs info whenever enter any service
    @Before("execution(* com.example.application.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        log.info("Enter service " + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        log.info("Arguments " + args.toString());
    }

    // logs info whenever exit any service
    @AfterReturning(pointcut =  "execution(* com.example.application.service.*.*(..))", returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        log.info("Exit service with return object " + result.toString());
    }
}
