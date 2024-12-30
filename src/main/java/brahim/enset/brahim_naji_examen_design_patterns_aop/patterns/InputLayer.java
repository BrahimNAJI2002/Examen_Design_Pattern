package brahim.enset.brahim_naji_examen_design_patterns_aop.patterns;

public class InputLayer extends Layer {
    public InputLayer(int size) {
        super(size, new IdentityActivation());
    }

    @Override
    public void computeOutput() {
    }
}