package com.codecool.battle;

import java.util.Scanner;

public class IO {
    public Scanner scan;

    public void initializeScanner() {
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
}