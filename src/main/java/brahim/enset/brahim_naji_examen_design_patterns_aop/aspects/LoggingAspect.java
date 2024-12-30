package brahim.enset.brahim_naji_examen_design_patterns_aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* brahim.enset.brahim_naji_examen_design_patterns_aop.patterns..*(..))")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Début d'exécution: " + joinPoint.getSignature());
        Object result = joinPoint.proceed();
        logger.info("Fin d'exécution: " + joinPoint.getSignature());
        return result;
    }
}
