package pl.homeproject;

public class Utils {
    public static void countOvertime(double days, double hours) {
        double result = hours - days * 3.6;
        if (result < -15 || result > 15) {
            System.out.println("Coś tu nie pasuje");
        } else if (result <= 0 && result >= -15) {
            System.out.println("Masz 0 nadgodzin");
        } else {
            System.out.println("Masz " + result + " nadgodzin.");
        }
    }
}
