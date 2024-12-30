package brahim.enset.brahim_naji_examen_design_patterns_aop.patterns;

import java.util.ArrayList;
import java.util.List;

public class Neuron {
    private final List<Connection> inputConnections = new ArrayList<>();
    private final List<Connection> outputConnections = new ArrayList<>();
    private final ActivationFunction activationFunction;
    private double output;

    public Neuron(ActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }

    public void addInputConnection(Connection connection) {
        inputConnections.add(connection);
    }

    public void addOutputConnection(Connection connection) {
        outputConnections.add(connection);
    }

    public double computeOutput() {
        double sum = inputConnections.stream()
                .mapToDouble(conn -> conn.getSource().getOutput() * conn.getWeight())
                .sum();
        output = activationFunction.compute(sum);
        return output;
    }

    public double getOutput() {
        return output;
    }

    public void setOutput(double value) {
        this.output = value;
    }
}