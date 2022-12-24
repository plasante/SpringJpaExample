package com.uniksoft.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AspectConfig {

    Logger logger = LoggerFactory.getLogger(getClass());

//    @Before(value = "execution(* com.uniksoft.controller.*.*(..))")
//    public void beforeAdvice(JoinPoint joinPoint) {
//        logger.info("Inside Before Advice");
//    }

//    @Before(value = "execution(* com.uniksoft.controller.*.*(..)) and args(object)")
//    public void beforeAdvice(JoinPoint joinPoint, Object object) {
//        logger.info("Request = " + object);
//    }

    @After(value = "execution(* com.uniksoft.controller.*.*(..)) and args(object)")
    public void beforeAdvice(JoinPoint joinPoint, Object object) {
        logger.info("Request = " + object);
    }
}
