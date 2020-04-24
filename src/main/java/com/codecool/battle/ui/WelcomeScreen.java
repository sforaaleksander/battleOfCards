package com.codecool.battle.ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * WelcomeScreen
 */
public class WelcomeScreen {
    private UI ui;

    public WelcomeScreen(UI ui) {
        this.ui = ui;
    }

    private String[] readTxt() {
        String fileName = "src/main/resources/intro.txt";
        Path path = Paths.get(fileName);
        FileReader fileReader;
        try {
            fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int lineCount = (int) Files.lines(path).count();
            
            String[] lines = new String[lineCount];
            String line;
            int i = 0;
        while ((line = bufferedReader.readLine()) != null) {
            lines[i++] = line;
        }
        bufferedReader.close();
        return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printWelcomeScreen() {
        ui.displayNewTable(readTxt());
    }
}