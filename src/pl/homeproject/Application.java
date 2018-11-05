package pl.homeproject;

import java.util.Scanner;

public class Application {
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int userSelection = -1;

        do {
            printMentu();
            System.out.print("Twój wybór: ");
            userSelection = getUserInt();
            switch (userSelection) {
                case 3:
                    System.out.print("\nLiczba dni: ");
                    int daysInt = getUserInt();
                    double daysDouble = (double) daysInt;
                    System.out.print("Liczba godzin: ");
                    double hours = getUserDouble();
                    Utils.countOvertime(daysDouble, hours);
                    break;
                case 0:
                    System.out.println("\nDo zobaczenia");
                    break;
                default:
                    System.out.println("\nBłędny wybór\n");
            }

        } while (userSelection != 0);

    }

    private void printMentu() {
        System.out.println("1) Punktacja zwykła");
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
            return 100000;
        }
    }
}
