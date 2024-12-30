package brahim.enset.brahim_naji_examen_design_patterns_aop.patterns;

public class SigmoidActivation implements ActivationFunction {
    @Override
    public double compute(double input) {
        return 1.0 / (1.0 + Math.exp(-input));
    }
}