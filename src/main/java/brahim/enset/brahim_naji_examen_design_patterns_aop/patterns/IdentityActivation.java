package brahim.enset.brahim_naji_examen_design_patterns_aop.patterns;

public class IdentityActivation implements ActivationFunction {
    @Override
    public double compute(double input) {
        return input;
    }
}