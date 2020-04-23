package com.codecool.battle;

import java.util.Scanner;

public class IO {
    public Scanner scan;

    IO() {
        scan = new Scanner(System.in);
        scan.useDelimiter(System.lineSeparator());
    }

    public String gatherInput(String title) {
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

    public void gatherEmptyInput(String title) {
        scan.next();
    }

    public int gatherIntInput(String title, int rangeMin, int rangeMax) {
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
