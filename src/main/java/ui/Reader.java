package ui;

import java.util.Scanner;

class Reader {
    int getUserInput(String prompt) {
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        String userInputLine = sc.next();
        try {
            return Integer.parseInt(userInputLine);
        } catch (NumberFormatException ex) {
            getUserInput(prompt);
        }
        return 0;
    }

    String getUserInputLine(String prompt) {
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        if (inputLine.length() == 0) {
            System.out.println("Try again");
            getUserInputLine(prompt);
        }
        return inputLine;
    }

    double getUserInputDouble(String prompt) {
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextDouble();
        } catch (NumberFormatException ex) {
            System.out.println("Something wrong");
            getUserInputDouble(prompt);
        }
        return 0;
    }
}
