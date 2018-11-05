package pl.homeproject;

public class Utils {
    public static void countStandardScoring(int maxPointsInt) {
        double[] percentage = {0.9, 0.75, 0.5, 0.3};
        String[] grades = {"bdb", "db", "dost", "dop"};
        printScoring(percentage, grades, maxPointsInt);
    }

    public static void countFixedScoring(int maxPointsInt){
        double[] percentage = {0.9, 0.71, 0.55, 0.4, 0.2};
        String[] grades = {"cel", "bdb", "db", "dost", "dop"};
        printScoring(percentage, grades, maxPointsInt);
    }

    public static void countOvertime(double days, double hours) {
        double result = hours - days * 3.6;
        if (days <= 0 || hours <= 0) {
            System.out.println("Coś poszło nie tak");
        } else if (result <= 0) {
            System.out.println("Masz 0 nadgodzin");
        } else {
            System.out.println("Masz " + result + " nadgodzin.");
        }
    }

    private static double pointsCounter(double percentage, double maxPoints) {
        double result = percentage * maxPoints;
        return (double)  Math.round(result * 2) / 2.0;
    }

    private static String scoringString(double min, double max) {
        return min + " - " + max + " : ";
    }

    private static void printScoring (double[] percentage, String[] grades, int maxPointsInt) {
        double maxPoints = (double) maxPointsInt;
        for (int i = 0; i < percentage.length; i++) {
            double upperValue;
            double lowerValue = pointsCounter(percentage[i], maxPoints);
            if (i == 0) {
                upperValue = maxPoints;
            } else {
                upperValue = pointsCounter(percentage[i-1], maxPoints) - 0.5;
            }
            System.out.println(scoringString(lowerValue, upperValue) + grades[i]);
        }
    }
}
