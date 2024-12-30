package brahim.enset.brahim_naji_examen_design_patterns_aop;

import brahim.enset.brahim_naji_examen_design_patterns_aop.aspects.SecurityContext;
import brahim.enset.brahim_naji_examen_design_patterns_aop.patterns.Dashboard;
import brahim.enset.brahim_naji_examen_design_patterns_aop.patterns.NeuralNetwork;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BrahimNajiExamenDesignPatternsAopApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(BrahimNajiExamenDesignPatternsAopApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            System.out.println("=== Test Simple du Réseau de Neurones ===\n");

            // 1. Création du réseau (3 entrées, 5 neurones cachés, 2 sorties)
            System.out.println("1. Création du réseau de neurones");
            NeuralNetwork network = new NeuralNetwork(3, new int[]{5}, 2);
            System.out.println("Réseau créé avec succès\n");

            // 2. Ajout d'un observateur pour suivre l'état
            Dashboard dashboard = new Dashboard();
            network.addObserver(dashboard);

            // 3. Simulation de l'entraînement
            System.out.println("2. Entraînement du réseau");
            System.out.println("Démarrage de l'entraînement...");
            network.train();  // Passage à l'état d'entraînement

            // Simulation du temps d'entraînement
            Thread.sleep(1000);

            System.out.println("Finalisation de l'entraînement...");
            network.fit();    // Passage à l'état entraîné

            // 4. Test de prédiction
            System.out.println("\n3. Test de prédiction");
            SecurityContext.setAuthenticated(true);
            double[] input = {0.1, 0.2, 0.3};
            System.out.println("Entrée: " + Arrays.toString(input));

            double[] prediction = network.predict(input);
            System.out.println("Sortie: " + Arrays.toString(prediction));

        } catch (Exception e) {
            System.err.println("Erreur: " + e.getMessage());
        }
    }
}
