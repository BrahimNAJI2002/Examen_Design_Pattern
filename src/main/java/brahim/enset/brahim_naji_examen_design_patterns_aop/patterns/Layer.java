package brahim.enset.brahim_naji_examen_design_patterns_aop.patterns;

import java.util.ArrayList;
import java.util.List;

public abstract class Layer {
    protected List<Neuron> neurons;

    public Layer(int size, ActivationFunction activationFunction) {
        neurons = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            neurons.add(new Neuron(activationFunction));
        }
    }

    public List<Neuron> getNeurons() {
        return neurons;
    }

    public abstract void computeOutput();
}