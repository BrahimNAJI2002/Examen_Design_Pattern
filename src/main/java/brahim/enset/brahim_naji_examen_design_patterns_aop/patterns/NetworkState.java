package brahim.enset.brahim_naji_examen_design_patterns_aop.patterns;

public interface NetworkState {
    void train(NeuralNetwork network);
    void predict(NeuralNetwork network) throws IllegalStateException;
    void fit(NeuralNetwork network);
}