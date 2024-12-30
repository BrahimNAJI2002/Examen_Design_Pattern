package brahim.enset.brahim_naji_examen_design_patterns_aop.patterns;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {
    private NetworkState state;
    private final List<Layer> layers;
    private final List<NetworkObserver> observers;

    public NeuralNetwork(int inputSize, int[] hiddenSizes, int outputSize) {
        this.state = new ConstructionState();
        this.observers = new ArrayList<>();
        this.layers = new ArrayList<>();

        // Création des couches
        layers.add(new InputLayer(inputSize));
        for (int size : hiddenSizes) {
            layers.add(new HiddenLayer(size, new SigmoidActivation()));
        }
        layers.add(new OutputLayer(outputSize, new SoftmaxActivation()));

        connectLayers();
    }

    private void connectLayers() {
        for (int i = 0; i < layers.size() - 1; i++) {
            Layer currentLayer = layers.get(i);
            Layer nextLayer = layers.get(i + 1);

            for (Neuron source : currentLayer.getNeurons()) {
                for (Neuron destination : nextLayer.getNeurons()) {
                    Connection connection = new Connection(source, destination);
                    source.addOutputConnection(connection);
                    destination.addInputConnection(connection);
                }
            }
        }
    }

    public void addObserver(NetworkObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(NetworkObserver observer) {
        observers.remove(observer);
    }

    public void setState(NetworkState state) {
        this.state = state;
        notifyObservers();
    }

    private void notifyObservers() {
        for (NetworkObserver observer : observers) {
            observer.update(state);
        }
    }

    public double[] predict(double[] input) {
        state.predict(this);

        InputLayer inputLayer = (InputLayer) layers.get(0);
        List<Neuron> inputNeurons = inputLayer.getNeurons();
        for (int i = 0; i < input.length; i++) {
            inputNeurons.get(i).setOutput(input[i]);
        }

        for (int i = 1; i < layers.size(); i++) {
            layers.get(i).computeOutput();
        }

        OutputLayer outputLayer = (OutputLayer) layers.get(layers.size() - 1);
        List<Neuron> outputNeurons = outputLayer.getNeurons();
        double[] output = new double[outputNeurons.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = outputNeurons.get(i).getOutput();
        }

        return output;
    }

    public void train() {
        state.train(this);
    }

    public void fit() {
        state.fit(this);
    }
}