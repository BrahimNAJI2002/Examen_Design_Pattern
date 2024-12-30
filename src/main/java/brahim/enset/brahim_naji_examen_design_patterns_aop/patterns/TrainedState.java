package brahim.enset.brahim_naji_examen_design_patterns_aop.patterns;

public class TrainedState implements NetworkState {
    @Override
    public void train(NeuralNetwork network) {
        network.setState(new TrainingState());
    }

    @Override
    public void predict(NeuralNetwork network) {
        // Autorise la prédiction
    }

    @Override
    public void fit(NeuralNetwork network) {
        throw new IllegalStateException("Le réseau est déjà entraîné");
    }
}