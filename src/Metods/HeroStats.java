package Metods;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import static java.lang.Integer.parseInt;
import java.util.Arrays;

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
public class HeroStats {

    private static int strenght = 10;
    private static int dexterity = 10;
    private static int vitality = 10;
    private static int inteligence = 10;
    private static int level = 1;
    private static int statUpgrades = 0;
    private static int experiance = 0;
    private static int money = 200;
    private static int inventoryItems = 0;
    //characterInventory - 0.NAME 1.STR 2.DEX 3.VIT 4.INT 5.DMG 6.DEF 7.TYPE 8.PRICE
    private static String[][] characterInventory = new String[4][9];
    private static int itemStrenght = 0;
    private static int itemDexterity = 0;
    private static int itemVitality = 0;
    private static int itemInteligence = 0;
    private static int itemDamage = 0;
    private static int itemDefense = 0;
    private static int hp = 10 * (getVitality() + getItemVitality());
    private static int mp = 10 * (getInteligence()+ getItemInteligence());

    void nextLevel() {
        while (experiance > 100 + Math.pow(2, level - 1)) {
            experiance = 0;
            level++;
            System.out.println("Level Up");
            System.out.println("You're level " + level + " now ");
            statUpgrade();

        }

    }

    void statUpgrade() {
        Inputs input = new Inputs();
        boolean end = false;
        while ((level - statUpgrades - 1) > 0 && end == false) {
            System.out.println("Which stat do you want to upgrade?");
            System.out.println("You can upgrade " + (level - statUpgrades - 1) + " stat");
            System.out.println("1. Strenght");
            System.out.println("2. Dexterity");
            System.out.println("3. Vitality");
            System.out.println("4. Inteligence");
            System.out.println("5. Nothing");
            switch (Integer.valueOf(input.input())) {
                case 1:
                    strenght++;
                    statUpgrades++;
                    break;
                case 2:
                    dexterity++;
                    statUpgrades++;
                    break;
                case 3:
                    vitality++;
                    statUpgrades++;
                    break;
                case 4:
                    inteligence += 1;
                    statUpgrades++;
                    break;
                case 5:
                    end = true;
                    break;
            }
        }
        if ((statUpgrades - level - 1) == 0) {
            System.out.println("You don't have free stat points");

        }
    }

    void expGain() {
        int exp = (int) (Math.pow(2 - Utilities.difficulty, Enemies.getEnemylevel()) + Enemies.getBaseExp() + (Math.random() * 6 + 1) - (Math.random() * 6 + 1));

        if (exp <= 0) {
            while (exp < 0) {
                exp++;
            }
        }
        System.out.println("You got: " + exp + " experiance from " + Enemies.getEnemyName());
        experiance += exp;

        nextLevel();
    }

    void moneyGain() {
        int mon = (int) (Math.round((Math.random() * 10 - 5) * Enemies.getEnemylevel()));
        if (mon <= 0) {
            System.out.println("Enemy didnt had any money on him");
        } else {
            System.out.println("You got " + mon + " money from " + Enemies.getEnemyName());
            money += mon;
        }
    }

    void inventory() throws IOException {
        Shop shop = new Shop();
        Utilities utilities = new Utilities();
        utilities.clearScreen();
        int numberOfLines = shop.getLines(Utilities.temp.toString()) + 1;
        BufferedReader bufferedReader;
        try (FileReader fileReader = new FileReader(Utilities.temp)) {
            bufferedReader = new BufferedReader(fileReader);
            String[] load = new String[numberOfLines];
            if (numberOfLines == 1) {
                System.out.println("You don't have any items in backpack");
            } else {
                for (int i = 0; i < numberOfLines; i++) {
                    load[i] = bufferedReader.readLine();
                    if (load[i] != null) {
                        System.out.println(load[i]);
                    }
                }
            }
        }
        utilities.waitForEnter();
        bufferedReader.close();
    }

    void characterInventory() throws IOException {
        Utilities utilities = new Utilities();
        utilities.clearScreen();
        System.out.print("Weapon:");
        System.out.println(characterInventory[1][0]);
        System.out.print("Shield:");
        System.out.println(characterInventory[2][0]);
        System.out.print("Armor:");
        System.out.println(characterInventory[3][0]);
        utilities.waitForEnter();
    }

    void addCharacterItems() throws IOException {
        Shop shop = new Shop();
        Inputs input = new Inputs();
        Utilities utilities = new Utilities();
        utilities.clearScreen();
        int numberOfLines = shop.getLines(Utilities.temp.toString()) + 1;
        BufferedReader bufferedReader;
        boolean process = true;
        try (FileReader fileReader = new FileReader(Utilities.temp)) {
            bufferedReader = new BufferedReader(fileReader);
            String[] load = new String[numberOfLines];
            if (numberOfLines == 0) {
                System.out.println("You don't have any items in backpack");
            } else {
                for (int i = 0; i < numberOfLines; i++) {
                    load[i] = bufferedReader.readLine();
                    if (load[i] != null) {
                        System.out.println(load[i]);
                    }
                }

                System.out.print("Weapon:");
                System.out.println(characterInventory[1][0]);
                System.out.print("Shield:");
                System.out.println(characterInventory[2][0]);
                System.out.print("Armor:");
                System.out.println(characterInventory[3][0]);
                System.out.println("What item do you want to put on?");
                int selection = Integer.valueOf(input.input());
                String[] work = load[selection].split(";");
                int number = 0;
                if (work[7].contains("Weapon")) {
                    if (characterInventory[1][0] == "0") {
                        number = 1;
                    } else {
                        System.out.println("You already have " + characterInventory[1][0] + " equipped");
                        process = false;
                    }
                } else if (work[7].contains("Shield")) {
                    if (characterInventory[2][0] == "0") {
                        number = 2;
                    } else {
                        System.out.println("You already have " + characterInventory[2][0] + " equipped");
                        process = false;
                    }
                } else if (work[7].contains("Armor")) {
                    if (characterInventory[3][0] == "0") {
                        number = 3;
                    } else {
                        System.out.println("You already have " + characterInventory[3][0] + " equipped");
                        process = false;
                    }
                }
                if (process == true) {
                    // name
                    characterInventory[number][0] = work[1];
                    //STR
                    characterInventory[number][1] = work[2];
                    //DEX
                    characterInventory[number][2] = work[3];
                    //VIT
                    characterInventory[number][3] = work[4];
                    //INT
                    characterInventory[number][4] = work[5];
                    //DMG
                    characterInventory[number][5] = work[6];
                    //DEF
                    characterInventory[number][6] = work[7];
                    //Type
                    characterInventory[number][7] = work[8];
                    //Price
                    characterInventory[number][8] = work[9];

                    Utilities.temp.delete();
                    Utilities.temp.createNewFile();
                    File filePath = new File(Utilities.temp.getAbsolutePath());
                    try (FileOutputStream fos = new FileOutputStream(filePath)) {
                        OutputStreamWriter osw = new OutputStreamWriter(fos);
                        Writer w = new BufferedWriter(osw);
                        int j = 0;
                        for (int i = 0; i < numberOfLines - 1; i++) {
                            if (i != selection) {
                                work = load[i].split(";");
                                w.write(j + ";" + work[1] + ";" + work[2] + ";" + work[3] + ";" + work[4] + ";" + work[5] + ";" + work[6] + ";" + work[7] + ";" + work[8] + ";" + work[9]);
                                w.write(System.lineSeparator());
                                j++;
                            } else {

                            }
                        }
                        w.close();
                        osw.close();
                        fos.close();
                        bufferedReader.close();
                        fileReader.close();
                    }
                }
            }

            utilities.waitForEnter();
        } catch (Exception error) {
            System.out.println(error);
        }
        System.out.println("reload");
        reloadItemStats();
    }

    void removeCharacterItems() throws FileNotFoundException, IOException {
        Shop shop = new Shop();
        Inputs input = new Inputs();
        System.out.println("Which item do you want to remove ?");
        System.out.println("1. Weapon: " + characterInventory[1][0]);
        System.out.println("2. Shield: " + characterInventory[2][0]);
        System.out.println("3. Armor: " + characterInventory[3][0]);
        System.out.print("Your choice: ");
        int selection = Integer.parseInt(input.input());
        int numberOfLines = shop.getLines(Utilities.temp.toString()) + 1;
        BufferedReader bufferedReader;
        String[] load;
        FileReader fileReader = new FileReader(Utilities.temp);
        bufferedReader = new BufferedReader(fileReader);
        load = new String[numberOfLines + 1];
        System.out.println("Number of lines: " + numberOfLines);
        for (int i = 0; i < numberOfLines + 1; i++) {
            load[i] = bufferedReader.readLine();
        }
        if (load[numberOfLines] == null) {
            numberOfLines--;

        }
        fileReader.close();
        bufferedReader.close();
        load[numberOfLines] = ("1"
                + ";" + HeroStats.characterInventory[selection][0]
                + ";" + HeroStats.characterInventory[selection][1]
                + ";" + HeroStats.characterInventory[selection][2]
                + ";" + HeroStats.characterInventory[selection][3]
                + ";" + HeroStats.characterInventory[selection][4]
                + ";" + HeroStats.characterInventory[selection][5]
                + ";" + HeroStats.characterInventory[selection][6]
                + ";" + HeroStats.characterInventory[selection][7]
                + ";" + HeroStats.characterInventory[selection][8]);

        Utilities.temp.delete();
        Utilities.temp.createNewFile();
        File filePath = new File(Utilities.temp.getAbsolutePath());
        FileOutputStream fos = new FileOutputStream(filePath);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        Writer w = new BufferedWriter(osw);
        int j = 0;
        String[] work;
        for (int i = 0; i < numberOfLines + 1; i++) {
            work = load[i].split(";");
            w.write(j + ";" + work[1] + ";" + work[2] + ";" + work[3] + ";" + work[4] + ";" + work[5] + ";" + work[6] + ";" + work[7] + ";" + work[8] + ";" + work[9]);
            w.write(System.lineSeparator());
            j++;

        }
        Arrays.fill(HeroStats.characterInventory[selection], "0");
        w.close();
        osw.close();
        fos.close();
    }

    void reloadItemStats() {
        itemStrenght = parseInt(characterInventory[1][1].trim()) + parseInt(characterInventory[2][1].trim()) + parseInt(characterInventory[3][1].trim());
        itemDexterity = parseInt(characterInventory[1][2].trim()) + parseInt(characterInventory[2][2].trim()) + parseInt(characterInventory[3][2].trim());
        itemVitality = parseInt(characterInventory[1][3].trim()) + parseInt(characterInventory[2][3].trim()) + parseInt(characterInventory[3][3].trim());
        itemInteligence = parseInt(characterInventory[1][4].trim()) + parseInt(characterInventory[2][4].trim()) + parseInt(characterInventory[3][4].trim());
        itemDamage = parseInt(characterInventory[1][5].trim());
        itemDefense = parseInt(characterInventory[2][6].trim()) + parseInt(characterInventory[3][6].trim());
    }

    public static int getStrenght() {
        return strenght;
    }

    public static void setStrenght(int strenght) {
        HeroStats.strenght = strenght;
    }

    public static int getDexterity() {
        return dexterity;
    }

    public static void setDexterity(int dexterity) {
        HeroStats.dexterity = dexterity;
    }

    public static int getVitality() {
        return vitality;
    }

    public static void setVitality(int vitality) {
        HeroStats.vitality = vitality;
    }

    public static int getInteligence() {
        return inteligence;
    }

    public static void setInteligence(int inteligence) {
        HeroStats.inteligence = inteligence;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        HeroStats.level = level;
    }

    public static int getStatUpgrades() {
        return statUpgrades;
    }

    public static void setStatUpgrades(int statUpgrades) {
        HeroStats.statUpgrades = statUpgrades;
    }

    public static int getExperiance() {
        return experiance;
    }

    public static void setExperiance(int experiance) {
        HeroStats.experiance = experiance;
    }

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        HeroStats.money = money;
    }

    public static int getInventoryItems() {
        return inventoryItems;
    }

    public static void setInventoryItems(int inventoryItems) {
        HeroStats.inventoryItems = inventoryItems;
    }

    public static String[][] getCharacterInventory() {
        return characterInventory;
    }

    public static void setCharacterInventory(int type, int stat, String content) {
        HeroStats.characterInventory[type][stat] = content;
    }

    public static int getItemStrenght() {
        return itemStrenght;
    }

    public static void setItemStrenght(int itemStrenght) {
        HeroStats.itemStrenght = itemStrenght;
    }

    public static int getItemDexterity() {
        return itemDexterity;
    }

    public static void setItemDexterity(int itemDexterity) {
        HeroStats.itemDexterity = itemDexterity;
    }

    public static int getItemVitality() {
        return itemVitality;
    }

    public static void setItemVitality(int itemVitality) {
        HeroStats.itemVitality = itemVitality;
    }

    public static int getItemInteligence() {
        return itemInteligence;
    }

    public static void setItemInteligence(int itemInteligence) {
        HeroStats.itemInteligence = itemInteligence;
    }

    public static int getItemDamage() {
        return itemDamage;
    }

    public static void setItemDamage(int itemDamage) {
        HeroStats.itemDamage = itemDamage;
    }

    public static int getItemDefense() {
        return itemDefense;
    }

    public static void setItemDefense(int itemDefense) {
        HeroStats.itemDefense = itemDefense;
    }

    public static int getHp() {
        return hp;
    }

    public static void setHp(int hp) {
        HeroStats.hp = hp;
    }

    public static int getMp() {
        return mp;
    }

    public static void setMp(int mp) {
        HeroStats.mp = mp;
    }
    
}
