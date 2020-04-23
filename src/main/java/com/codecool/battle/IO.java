package com.codecool.battle;

import java.util.Scanner;

public class IO {
    public Scanner scan;

    IO() {
        scan = new Scanner(System.in);
        scan.useDelimiter(System.lineSeparator());
    }

    public String gatherInput(String title) {
        System.out.println(title);
        boolean validInput = true;
        String userInput = "";
        do {
            if (!validInput) {
                System.out.println("Your input must contain at least one character. Enter again: ");
            }
            validInput = false;
            userInput = scan.next().toUpperCase();
            if (!userInput.equals("")) {
                validInput = true;
            }
        } while (!validInput);
        return userInput;
    }

    public String gatherEmptyInput(String title) {
        System.out.println(title);
        return scan.next().toUpperCase();
    }

    public int gatherIntInput(String title, int rangeMin, int rangeMax) {
        System.out.println(title);
        String userInput = "";
        boolean validInput = false;
        while (!validInput) {
            userInput = scan.next();
            validInput = isNumberInRange(userInput, rangeMin, rangeMax);
        }
        return Integer.parseInt(userInput);
    }

    private boolean isNumberInRange(String userInput, int rangeMin, int rangeMax) {
        int userInt = 1;
        if (!userInput.equals("")) {
            if (userInput.matches("^[0-9]*$")) {
                userInt = Integer.parseInt(userInput);
                if (userInt >= rangeMin && userInt <= rangeMax) {
                    return true;
                }
            }
        }
        return false;
    }
}
