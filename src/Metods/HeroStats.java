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
import javax.swing.DefaultListModel;

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
    private static String[][] heroInventory = new String[255][9];
    //characterInventory - 0.NAME 1.STR 2.DEX 3.VIT 4.INT 5.DMG 6.DEF 7.TYPE 8.PRICE
    private static final String[][] characterInventory = new String[4][9];
    private static int itemStrenght = 0;
    private static int itemDexterity = 0;
    private static int itemVitality = 0;
    private static int itemInteligence = 0;
    private static int itemDamage = 0;
    private static int itemDefense = 0;
    private static int hp = 10 * (getVitality() + getItemVitality());
    private static int mp = 10 * (getInteligence() + getItemInteligence());



    public static DefaultListModel inventory() {
        DefaultListModel items = new DefaultListModel();
        try {
            for (int i = 0; i < heroInventory.length; i++) {
                if (heroInventory[i][0] != null) {
                    items.addElement(heroInventory[i][0]);
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e);
            System.out.println("Inventory is empty");
            items.addElement("Empty");
        }
        return items;
    }

    public static String[] getInventoryStats(int index) {
        String[] item = new String[9];
        System.arraycopy(heroInventory[index], 0, item, 0, heroInventory[index].length);
        return item;
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

    public static void addCharacterItems(int inventorySlot) {
        int slot = 0;
        switch (heroInventory[inventorySlot][7].trim()) {
            case "Weapon":
                slot = 1;
                break;
            case "Shield":
                slot = 2;
                break;
            case "Armor":
                slot = 3;
                break;
        }
        
        for (int i = 0; i < getCharacterInventory()[slot].length; i++) {
            setCharacterInventory(slot, i, getHeroInventory()[inventorySlot][i]);
        }

    }


    public static void reloadItemStats() {
        itemStrenght = parseInt(characterInventory[1][1].trim()) + parseInt(characterInventory[2][1].trim()) + parseInt(characterInventory[3][1].trim());
        itemDexterity = parseInt(characterInventory[1][2].trim()) + parseInt(characterInventory[2][2].trim()) + parseInt(characterInventory[3][2].trim());
        itemVitality = parseInt(characterInventory[1][3].trim()) + parseInt(characterInventory[2][3].trim()) + parseInt(characterInventory[3][3].trim());
        itemInteligence = parseInt(characterInventory[1][4].trim()) + parseInt(characterInventory[2][4].trim()) + parseInt(characterInventory[3][4].trim());
        itemDamage = parseInt(characterInventory[1][5].trim());
        itemDefense = parseInt(characterInventory[2][6].trim()) + parseInt(characterInventory[3][6].trim());
    }

    public static String[][] getHeroInventory() {
        return heroInventory;
    }

    public static void setHeroInventory(int indexX, int indexY, String value) {
        HeroStats.heroInventory[indexX][indexY] = value;
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
        HeroStats.money += money;
    }

    public static int getInventoryItems() {
        return inventoryItems;
    }

    public static void setInventoryItems(int inventoryItems) {
        HeroStats.inventoryItems += inventoryItems;
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
