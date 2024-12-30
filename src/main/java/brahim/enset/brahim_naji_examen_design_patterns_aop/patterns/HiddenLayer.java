package brahim.enset.brahim_naji_examen_design_patterns_aop.patterns;

public class HiddenLayer extends Layer {
    public HiddenLayer(int size, ActivationFunction activationFunction) {
        super(size, activationFunction);
    }

    @Override
    public void computeOutput() {
        for (Neuron neuron : neurons) {
            neuron.computeOutput();
        }
    }
}