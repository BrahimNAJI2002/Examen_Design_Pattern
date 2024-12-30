package brahim.enset.brahim_naji_examen_design_patterns_aop.patterns;

public class TrainingState implements NetworkState {
    @Override
    public void train(NeuralNetwork network) {
        // Déjà en entraînement
        System.out.println("Le réseau est déjà en cours d'entraînement");
    }

    @Override
    public void predict(NeuralNetwork network) {
        throw new IllegalStateException("Impossible de prédire pendant l'entraînement");
    }

    @Override
    public void fit(NeuralNetwork network) {
        // Permet de passer à l'état Trained
        network.setState(new TrainedState());
    }
}