package brahim.enset.brahim_naji_examen_design_patterns_aop.patterns;

public class Connection {
    private double weight;
    private final Neuron source;
    private final Neuron destination;

    public Connection(Neuron source, Neuron destination) {
        this.source = source;
        this.destination = destination;
        this.weight = Math.random(); // Initialisation aléatoire entre 0 et 1
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight >= 0 && weight <= 1) {
            this.weight = weight;
        }
    }

    public Neuron getSource() {
        return source;
    }

    public Neuron getDestination() {
        return destination;
    }
}