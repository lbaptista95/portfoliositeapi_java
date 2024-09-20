package com.lb.portfolio.api.configuration.logging;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Log4j2
@Aspect
@Component
public class LogExecutionTimeAdvice {

    @Around("@annotation(com.lb.portfolio.api.configuration.logging.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint point) throws Throwable {
        Long start = System.currentTimeMillis();
        Object o = point.proceed();

        Long end = System.currentTimeMillis();
        log.info("{} - method {} finished in {}ms",
                point.getSignature().getDeclaringTypeName(), point.getSignature().getName(), end - start);

        return o;
    }
}
