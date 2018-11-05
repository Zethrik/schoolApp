package pl.homeproject;

import java.util.Scanner;

public class Application {
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int userSelection = -1;

        do {
            printMentu();
            System.out.print("\nTwój wybór: ");
            userSelection = getUserInt();
            System.out.println();
            switch (userSelection) {
                case 1:
                    System.out.print("Podaj maks punktów: ");
                    int maxPoints = getUserInt();
                    Utils.countStandardScoring(maxPoints);
                    pause();
                    break;
                case 2:
                    System.out.print("Podaj maks punktów: ");
                    int maxPoints2 = getUserInt();
                    Utils.countFixedScoring(maxPoints2);
                    pause();
                    break;
                case 3:
                    System.out.print("Liczba dni: ");
                    int daysInt = getUserInt();
                    double daysDouble = (double) daysInt;
                    System.out.print("Liczba godzin: ");
                    double hours = getUserDouble();
                    Utils.countOvertime(daysDouble, hours);
                    pause();
                    break;
                case 0:
                    System.out.println("Do zobaczenia");
                    break;
                default:
                    System.out.println("Błędny wybór\n");
            }

        } while (userSelection != 0);

    }

    private void printMentu() {
        System.out.println("\n1) Punktacja zwykła");
        System.out.println("2) Punktacja dostosowana");
        System.out.println("3) Nadgodziny");
        System.out.println("0) Wyjdź");
    }

    private int getUserInt() {
        String userInput = scanner.nextLine();
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    private double getUserDouble() {
        String userInput = scanner.nextLine();
        try {
            return Double.parseDouble(userInput);
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    private void pause() {
        System.out.println("\nEnter, by kontynuować");
        scanner.nextLine();
    }
}
