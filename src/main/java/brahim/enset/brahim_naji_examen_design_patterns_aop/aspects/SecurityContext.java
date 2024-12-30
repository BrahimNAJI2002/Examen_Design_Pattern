package brahim.enset.brahim_naji_examen_design_patterns_aop.aspects;

public class SecurityContext {
    private static boolean authenticated = false;

    public static boolean isAuthenticated() {
        return authenticated;
    }

    public static void setAuthenticated(boolean auth) {
        authenticated = auth;
    }
}