package com.codecool.battle;

import java.util.Scanner;

public class IO {
    public Scanner scan;
    private UI ui;

    IO(UI ui){
        scan = new Scanner(System.in);
        scan.useDelimiter(System.lineSeparator());
        this.ui = ui;
    }


    public String gatherInput(String title) {
        ui.printOnTable(new String[]{title});
        boolean validInput = true;
        String userInput = "";
        do {
            if (!validInput) {
                ui.printOnTable(new String[]{"Your input must contain at least one character. Enter again: "});
            }
            validInput = false;
            userInput = scan.next().toUpperCase();
            if (!userInput.equals("")) {
                validInput = true;
            }
        } while (!validInput);
        return userInput;
    }

    public int gatherIntInput(String title, int range) {
        ui.printOnTable(new String[]{title});
        String userInput;
        int userInt = 1;
        boolean validInput = false;
        while (!validInput) {
            userInput = scan.next();
            if (!userInput.equals("")) {
                if (userInput.matches("^[0-9]*$")) {
                    userInt = Integer.parseInt(userInput);
                    if (userInt > 0 && userInt <= range) {
                        validInput = true;
                    }
                }
            }
        }
        return userInt;
    }
}