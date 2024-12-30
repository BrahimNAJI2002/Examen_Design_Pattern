package brahim.enset.brahim_naji_examen_design_patterns_aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SecurityAspect {
    @Before("execution(* brahim.enset.brahim_naji_examen_design_patterns_aop.patterns.NeuralNetwork.predict(..))")
    public void checkSecurity() {
        if (!SecurityContext.isAuthenticated()) {
            throw new SecurityException("Accès non autorisé");
        }
    }
}