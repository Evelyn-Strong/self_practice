package com.practice.demo.annoExample;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnoAspect {


    @Pointcut("@annotation(com.practice.demo.annoExample.NewComponent)")
    public void annoPointCut(){
        System.out.println("test annoPointCut()");
    }

    @Around("annoPointCut()")
    public Object newComponentLogMethods(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        System.out.println("NewComponent : " + methodName);
        return joinPoint.proceed();
    }



}
