package brahim.enset.brahim_naji_examen_design_patterns_aop.patterns;

public class Dashboard implements NetworkObserver {
    @Override
    public void update(NetworkState state) {
        System.out.println("Dashboard mis à jour - Avec une nouvelle etat ");
    }
}