package Metods;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
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

    public static void systemInit() {
//        try {
        // fill characterInventory array with 0
        for (int i = 0; i < HeroStats.getCharacterInventory().length; i++) {
            for (int j = 0; j < HeroStats.getCharacterInventory().length; j++) {
                HeroStats.setCharacterInventory(i, j, "0");
            }
        }
        Object object = new Object();
        shopItemsDir = object.getClass().getResource("/Resources/").getPath();
//       Create Temp dir with temp file Inventory.txt
//            File theDir = new File("temp");
//            if (!theDir.exists()) {
//                try {
//                    theDir.mkdir();
//                } catch (SecurityException error) {
//                    System.out.println(error);
//                }
//                
//            }
        timer(100, "1 sec background timer");
//            theDir.deleteOnExit();
//            temp = new File(theDir.getAbsolutePath() + "/Inventory.txt");
//            temp.delete();
//            temp.createNewFile();
//            temp.deleteOnExit();
//        Dificulty

//        } catch (IOException ex) {
//            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
//        }
        setDificulty("Normal");
    }

    void clearScreen() throws IOException {
//        Clearing the screen
        for (int i = 0; i < 50; i++) {
            System.out.println("\n");
        }

    }

    public static void waitForEnter() throws IOException {
        System.out.print("Press Enter to continue ...");
        System.in.read();
    }

    void save() throws FileNotFoundException, UnsupportedEncodingException, IOException {
//       Creating dir save
        String path;
        File theDir = new File("save");
        if (!theDir.exists()) {

            try {
                theDir.mkdir();
            } catch (SecurityException error) {
                System.out.println(error);
            }

        }
        path = theDir.getAbsolutePath();
        saveProcess(path);

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

    public void saveProcess(String path) {
//        Creating file with save information in dir save
        try {

            File filePath = new File(path);
            FileOutputStream fos = new FileOutputStream(filePath);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            //stats
            try (Writer w = new BufferedWriter(osw)) {
                //Hero stats
                w.write("## Hero Stats");
                w.write(System.lineSeparator());
                w.write(HeroStats.getLevel() + ";" + HeroStats.getExperiance() + ";" + HeroStats.getStrenght() + ";" + HeroStats.getDexterity() + ";" + HeroStats.getVitality() + ";" + HeroStats.getInteligence() + ";" + HeroStats.getHp() + ";" + HeroStats.getMp() + ";" + HeroStats.getMoney());
                //Character inventory
                for (int i = 1; i < 4; i++) {
                    try {
                        String text = null;
                        switch (i) {
                            case 1:
                                text = "Weapon";
                                break;
                            case 2:
                                text = "Shield";
                                break;
                            case 3:
                                text = "Armor";
                                break;
                        }
                        w.write(System.lineSeparator());
                        w.write("## Type: " + text);
                        w.write(System.lineSeparator());
                        //Name
                        w.write(HeroStats.getCharacterInventory()[i][0] + ";");
                        //STR
                        w.write(HeroStats.getCharacterInventory()[i][1] + ";");
                        //DEX
                        w.write(HeroStats.getCharacterInventory()[i][2] + ";");
                        //VIT
                        w.write(HeroStats.getCharacterInventory()[i][3] + ";");
                        //INT
                        w.write(HeroStats.getCharacterInventory()[i][4] + ";");
                        //DMG
                        w.write(HeroStats.getCharacterInventory()[i][5] + ";");
                        //DEF
                        w.write(HeroStats.getCharacterInventory()[i][6] + ";");
                        //Type
                        w.write(HeroStats.getCharacterInventory()[i][7] + ";");
                        //Price
                        w.write(HeroStats.getCharacterInventory()[i][8]);

                    } catch (NullPointerException error) {
                        System.out.println(error);
                    }
                }
                //Inventory
                w.write(System.lineSeparator());
                int lines = Shop.getLines(temp.getAbsolutePath());
                String load = null;
                FileReader fr = new FileReader(Utilities.temp);
                try (BufferedReader br = new BufferedReader(fr)) {
                    w.write("## Inventory: ");
                    for (int i = 0; i < lines; i++) {
                        load = br.readLine();
                        w.write(System.lineSeparator());
                        w.write(load);
                    }
                }
            }
        } catch (IOException error) {
            System.out.println(error);
        }

    }

    void load() throws IOException {
        Inputs input = new Inputs();
        HeroStats heroStats = new HeroStats();
        String path = System.getProperty("user.dir");
        File folder = new File(path + "/save/");
        File[] listOfFiles = folder.listFiles();

        for (int i = 1; i < listOfFiles.length + 1; i++) {
            System.out.println(i + ". file " + listOfFiles[i - 1].getName());
        }
        System.out.print("Which file to load ?");
        String targetFile = listOfFiles[Integer.valueOf(input.input()) - 1].getPath();
        loadProcess(targetFile);
        heroStats.reloadItemStats();
    }

    public void loadProcess(String path) throws FileNotFoundException, IOException {

        Shop shop = new Shop();
//        System.out.println(path);
        FileReader filr = new FileReader(path);
        BufferedReader buffr = new BufferedReader(filr);
        FileOutputStream fos;
        OutputStreamWriter osw;
        Writer w;
        fos = new FileOutputStream(temp);
        osw = new OutputStreamWriter(fos);
        w = new BufferedWriter(osw);
        String next = null;
        int o = 0;
        int numberOfLines = shop.getLines(path);
        String read = null;
        try {
            for (int i = 1; i < numberOfLines + 1; i++) {
                read = buffr.readLine();
                o++;
                if (read != null) {
                    if (read.contains("##")) {
                        if (read.contains("Hero Stats")) {
                            next = "Hero Stats";
                        } else if (read.contains("Weapon")) {
                            next = "Weapon";
                        } else if (read.contains("Shield")) {
                            next = "Shield";
                        } else if (read.contains("Armor")) {
                            next = "Armor";
                        } else if (read.contains("Inventory")) {
                            next = "Inventory";
                        } else if (read.contains("Misc")) {
                            next = "Misc";
                        }
                    } else {
                        String[] part;
                        switch (next) {
                            case "Hero Stats":
                                part = read.split(";");
                                HeroStats.setLevel(Integer.valueOf(part[0]));
                                HeroStats.setExperiance(Integer.valueOf(part[1]));
                                HeroStats.setStrenght(Integer.valueOf(part[2]));
                                HeroStats.setDexterity(Integer.valueOf(part[3]));
                                HeroStats.setVitality(Integer.valueOf(part[4]));
                                HeroStats.setInteligence(Integer.valueOf(part[5]));
                                HeroStats.setHp(Integer.valueOf(part[6]));
                                HeroStats.setMp(Integer.valueOf(part[7]));
                                HeroStats.setMoney(Integer.valueOf(part[8]));

                                break;
                            case "Weapon":
                                part = read.split(";");
                                // item name
                                HeroStats.setCharacterInventory(1, 0, part[0].trim());
                                // item Strenght
                                HeroStats.setCharacterInventory(1, 1, part[1].trim());
                                // item Dexterity
                                HeroStats.setCharacterInventory(1, 2, part[2].trim());
                                // item vitality
                                HeroStats.setCharacterInventory(1, 3, part[3].trim());
                                // item inteligence
                                HeroStats.setCharacterInventory(1, 4, part[4].trim());
                                // item Damage
                                HeroStats.setCharacterInventory(1, 5, part[5].trim());
                                // item Defense
                                HeroStats.setCharacterInventory(1, 6, part[6].trim());
                                // item Type
                                HeroStats.setCharacterInventory(1, 7, part[7].trim());
                                // item Price
                                HeroStats.setCharacterInventory(1, 8, part[8].trim());
                                break;
                            case "Shield":
                                part = read.split(";");
                                // item name
                                HeroStats.setCharacterInventory(2, 0, part[0].trim());
                                // item Strenght
                                HeroStats.setCharacterInventory(2, 1, part[1].trim());
                                // item Dexterity
                                HeroStats.setCharacterInventory(2, 2, part[2].trim());
                                // item vitality
                                HeroStats.setCharacterInventory(2, 3, part[3].trim());
                                // item inteligence
                                HeroStats.setCharacterInventory(2, 4, part[4].trim());
                                // item Damage
                                HeroStats.setCharacterInventory(2, 5, part[5].trim());
                                // item Defense
                                HeroStats.setCharacterInventory(2, 6, part[6].trim());
                                // item Type
                                HeroStats.setCharacterInventory(2, 7, part[7].trim());
                                // item Price
                                HeroStats.setCharacterInventory(2, 8, part[8].trim());
                                break;
                            case "Armor":
                                part = read.split(";");
                                // item name
                                HeroStats.setCharacterInventory(3, 0, part[0].trim());
                                // item Strenght
                                HeroStats.setCharacterInventory(3, 1, part[1].trim());
                                // item Dexterity
                                HeroStats.setCharacterInventory(3, 2, part[2].trim());
                                // item vitality
                                HeroStats.setCharacterInventory(3, 3, part[3].trim());
                                // item inteligence
                                HeroStats.setCharacterInventory(3, 4, part[4].trim());
                                // item Damage
                                HeroStats.setCharacterInventory(3, 5, part[5].trim());
                                // item Defense
                                HeroStats.setCharacterInventory(3, 6, part[6].trim());
                                // item Type
                                HeroStats.setCharacterInventory(3, 7, part[7].trim());
                                // item Price
                                HeroStats.setCharacterInventory(3, 8, part[8].trim());
                                break;
                            case "Inventory":
                                w.write(read);
                                w.write(System.lineSeparator());
                                break;
                            default:
                                break;
                            case "Misc":
                                break;
                        }
                    }
                }

            }
            w.close();
            buffr.close();
            filr.close();
            fos.close();
            osw.close();
        } catch (IOException | NumberFormatException error) {
            System.out.println(error);
        }

    }
    // <editor-fold defaultstate="collapsed" desc="Gettings and Settings">

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
