package brahim.enset.brahim_naji_examen_design_patterns_aop.patterns;

public class OldActivationAdapter implements ActivationFunction {
    private final OldActivation oldActivation;

    public OldActivationAdapter(OldActivation oldActivation) {
        this.oldActivation = oldActivation;
    }

    @Override
    public double compute(double input) {
        return oldActivation.calculateOutput(input);
    }
}
