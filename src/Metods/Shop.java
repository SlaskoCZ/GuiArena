package Metods;


/*
 * Copyright (c) 2015 Petr Linhart.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Petr - initial API and implementation and/or initial documentation
 */
/**
 *
 * @author Petr Linhart
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Shop {

    public static String[][] lines;

    void buy() throws IOException {
        Utilities utilities = new Utilities();
        Inputs input = new Inputs();
        for (int i = 1; i < (lines.length - 1); i++) {
            if (i < 10) {
                System.out.print("  ");
            } else if (i < 100) {
                System.out.print(" ");
            }
            System.out.print(i);
            System.out.print(". ");
            for (int j = 1; j < lines[i].length; j++) {
                System.out.print(lines[i][j]);
            }
            System.out.println("");
        }
        System.out.print("Choose what do you want to buy: ");
        int selection = Integer.valueOf(input.input());
        System.out.println("");
        String text = "Do you want to buy: "
                + //Item name
                lines[selection][1]
                + //Item Strenght
                " STR: "
                + lines[selection][2]
                + //Item Dexterity
                " DEX: "
                + lines[selection][3]
                + //Item Vitality
                " VIT: "
                + lines[selection][4]
                + //Item Inteligence
                " INT: "
                + lines[selection][5]
                + //Item damage
                " DMG: "
                + lines[selection][6]
                + //Item damage
                " DEF: "
                + lines[selection][7]
                + //Item price
                " For: "
                + lines[selection][9]
                + "gold ? [Yes/No]";
        System.out.println(text);
        switch (input.input()) {
            case "Yes":

                int line = getLines(Utilities.temp.getAbsolutePath());
                String[] load = new String[line + 1];
                if (Integer.valueOf(lines[selection][9].trim()) > HeroStats.money) {
                    System.out.println("You don't have enought money!");
                    utilities.waitForEnter();
                    utilities.clearScreen();
                } else {
                    System.out.println("Sucessfuly bought " + lines[selection][1]);

                    FileReader fr = new FileReader(Utilities.temp);
                    BufferedReader br = new BufferedReader(fr);
                    HeroStats.money -= Integer.valueOf(lines[selection][9]);

                    for (int i = 0; i < HeroStats.inventoryItems; i++) {
                        load[i] = br.readLine();

                    }
                    Utilities.temp.delete();
                    Utilities.temp.createNewFile();
                    FileWriter fw = new FileWriter(Utilities.temp);
                    BufferedWriter bw = new BufferedWriter(fw);
                    Writer w = new BufferedWriter(bw);
                    String[] work;
                    for (int i = 0; i < HeroStats.inventoryItems; i++) {
                        work = load[i].split(";");
                        w.write(i + ";" + work[1] + ";" + work[2] + ";" + work[3] + ";" + work[4] + ";" + work[5] + ";" + work[6] + ";" + work[7] + ";" + work[8] + ";" + work[9]);
                        w.write(System.lineSeparator());
                    }
                    HeroStats.inventoryItems += 1;
                    w.write(line
                            +//item name
                            ";"
                            + lines[selection][1]
                            + //Item Strenght
                            ";"
                            + lines[selection][2]
                            + //Item Dexterity
                            ";"
                            + lines[selection][3]
                            + //Item Vitality
                            ";"
                            + lines[selection][4]
                            + //Item Inteligence
                            ";"
                            + lines[selection][5]
                            + //Item damage                           
                            ";"
                            + lines[selection][6]
                            + //Item defense                          
                            ";"
                            + lines[selection][7]
                            + //Item Type
                            ";"
                            + lines[selection][8]
                            + //Item price
                            ";"
                            + (Integer.valueOf(lines[selection][9]) / 2));
                    System.out.println(Utilities.temp);
                    w.close();
                    fw.close();
                    bw.close();
                    fr.close();
                    br.close();
                }

        }

    }

    void loadShop(String type) throws FileNotFoundException, IOException {
        String path = "./resource/files/" + type + ".txt";
        int numberOfLines = getLines(path);
        BufferedReader bufferedReader;
        FileReader fileReader = new FileReader(path);
        bufferedReader = new BufferedReader(fileReader);
        int i = 1;
        lines = new String[numberOfLines + 1][10];
        while (i < numberOfLines) {
            String readed = bufferedReader.readLine();
            if (readed.contains("##")) {
            } else {
                String[] part = readed.split(";");
                //Item ID
                lines[i][0] = part[0];
                //Item name
                lines[i][1] = part[1];
                //Item Strenght
                lines[i][2] = part[2];
                //Item Dexterity
                lines[i][3] = part[3];
                //Item Vitality
                lines[i][4] = part[4];
                //Item Inteligence
                lines[i][5] = part[5];
                //Item damage
                lines[i][6] = part[6];
                //Item defense
                lines[i][7] = part[7];
                //Item Type
                lines[i][8] = part[8];
                //Item price
                lines[i][9] = part[9];

                i++;
            }
        }

        bufferedReader.close();
        fileReader.close();
    }

    int getLines(String path) throws IOException {
        int numberOfLines = 0;
        try {
            FileReader fileReader = new FileReader(path);

            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while (bufferedReader.readLine() != null) {

                    numberOfLines++;

                }
            }
        } catch (Exception error) {
            System.out.println(error);
        }
        return numberOfLines;
    }

    void sell() throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(Utilities.temp);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int numberOfItems = getLines(Utilities.temp.getPath());
        String[] items = new String[numberOfItems];
        if (numberOfItems == 0) {
            System.out.println("Nothing to sell in backpack.");

        } else {
            for (int i = 1; i < HeroStats.inventoryItems; i++) {
                String readed = bufferedReader.readLine();
                System.out.println(readed);
                items[i] = readed;
            }
            fileReader.close();
            bufferedReader.close();
        }
    }
}
