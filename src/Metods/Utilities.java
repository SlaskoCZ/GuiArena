package Metods;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

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
public class Utilities {

    private static File temp;
    private static double difficulty;
    private static int delay;
    private static String shopItemsDir;
    private static String pathToDir;
    private static String pathToSave;
//@todo Make Save system
    //@todo Make Load system

    public static void systemInit() {
//        try {
        // fill characterInventory array with 0
        for (int i = 0; i < Hero.getItemsOnHero().length; i++) {
            for (int j = 0; j < Hero.getItemsOnHero()[i].length; j++) {
                Hero.setCharacterInventory(i, j, "0");
            }
        }

        Object object = new Object();
        shopItemsDir = object.getClass().getResource("/Resources/").getPath();
//       Create dir in My Games/GuiArena/save
        String pathToUserHome = System.getProperty("user.home");
        pathToDir = pathToUserHome + "\\Documents\\My Games";
        File theDir = new File(pathToDir);
        if (!theDir.exists()) {
            try {
                theDir.mkdir();
                System.out.println("Created dir " + pathToDir);
            } catch (SecurityException error) {
                System.out.println(error);
            }

        }

        pathToDir += "\\GuiArena";
        theDir = new File(pathToDir);
        if (!theDir.exists()) {
            try {
                System.out.println("Created dir " + pathToDir);
                theDir.mkdir();
            } catch (SecurityException error) {
                System.out.println(error);
            }

        }

        pathToSave = pathToDir + "\\save";
        theDir = new File(pathToSave);
        if (!theDir.exists()) {
            try {
                System.out.println("Created dir " + pathToSave);
                theDir.mkdir();

            } catch (SecurityException error) {
                System.out.println(error);
            }

        }
        // create all save slots
        for (int i = 1; i < 6; i++) {

            String save = pathToSave + "\\savegame" + i + ".gas";
            File saves = new File(save);
            if (!saves.exists()) {
                try {
                    saves.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Created file: " + save);
            }
        }

        File dataFile = new File(pathToDir + "\\data.gad");
        if (!dataFile.exists()) {
            try {
                dataFile.createNewFile();
                try (Writer w = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(dataFile.getAbsolutePath()), "ISO-8859-1"))) {
                    char quotationMarks = '"';
                    w.write("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" + System.lineSeparator());
                    w.write("<root>" + System.lineSeparator());
                    w.write("\t<gamedata>" + System.lineSeparator());
                    w.write("\t\t<save "
                            + "save1=" + quotationMarks + "false" + quotationMarks + " "
                            + "save2=" + quotationMarks + "false" + quotationMarks + " "
                            + "save3=" + quotationMarks + "false" + quotationMarks + " "
                            + "save4=" + quotationMarks + "false" + quotationMarks + " "
                            + "save5=" + quotationMarks + "false" + quotationMarks + "/>"
                            + System.lineSeparator());
                    w.write("\t</gamedata>" + System.lineSeparator());
                    w.write("\t<settings>" + System.lineSeparator());
                    w.write("\t\t<localization "
                            + "lang=" + quotationMarks + "English" + quotationMarks + "/>"
                            + System.lineSeparator());
                    w.write("\t</settings>" + System.lineSeparator());
                    w.write("</root>" + System.lineSeparator());
                }
            } catch (IOException ex) {
                Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Created file: " + dataFile);
        }

        timer(100, "0.1 sec background timer");
        setDificulty("Normal");
    }

    void clearScreen() throws IOException {
//        Clearing the screen
        for (int i = 0; i < 50; i++) {
            System.out.println("\n");
        }

    }

    public static double randomNumber(double min, double max, boolean round) {
        if (round == true) {
            return Math.round(Math.random() * (max - min) + min);
        } else {
            return Math.random() * (max - min) + min;
        }
    }

    public static void waitForEnter() throws IOException {
        System.out.print("Press Enter to continue ...");
        System.in.read();
    }

    private static void timer(int delay, String task) {
        final Arena.MainClass mainClass = new Arena.MainClass();
        setDelay(delay);

        ActionListener timer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mainClass.reloadHeroStats();
            }

        };
        new Timer(delay, timer).start();
    }

    // <editor-fold defaultstate="collapsed" desc="Gettings and Settings">
    public static String getPathToDir() {
        return pathToDir;
    }

    public static String getPathToSave() {
        return pathToSave;
    }

    public static String getShopItemsDir() {
        return shopItemsDir;
    }

    public static File getTemp() {
        return temp;
    }

    public static void setTemp(File temp) {
        Utilities.temp = temp;
    }

    public static double getDifficulty() {
        return difficulty;
    }

    public static void setDificulty(String playerDifSelection) {
        double difficulty;
        switch (playerDifSelection) {
            case "Easy":
                difficulty = 0.1;
                break;
            case "Normal":
                difficulty = 0.5;
                break;
            case "Hard":
                difficulty = 1;
                break;
            default:
                difficulty = 0.5;
        }
        Utilities.difficulty = difficulty;
    }

    public static int getDelay() {
        return delay;
    }

    public static void setDelay(int delay) {
        Utilities.delay = delay;
    }
       // </editor-fold>     
}
