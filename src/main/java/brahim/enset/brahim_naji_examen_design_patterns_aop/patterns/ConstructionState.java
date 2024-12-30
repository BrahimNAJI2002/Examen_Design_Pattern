package brahim.enset.brahim_naji_examen_design_patterns_aop.patterns;

public class ConstructionState implements NetworkState {
    @Override
    public void train(NeuralNetwork network) {
        network.setState(new TrainingState());
    }

    @Override
    public void predict(NeuralNetwork network) {
        throw new IllegalStateException("Impossible de prédire en état de construction");
    }

    @Override
    public void fit(NeuralNetwork network) {
        network.setState(new TrainedState());
    }
}