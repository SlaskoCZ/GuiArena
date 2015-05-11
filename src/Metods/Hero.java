package Metods;

import java.io.IOException;
import static java.lang.Integer.parseInt;
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
public class Hero {
    private static String name = "Argus Pyrrhus";
    private static int strenght = 10;
    private static int dexterity = 10;
    private static int vitality = 10;
    private static int inteligence = 10;
    private static int level = 1;
    private static int statUpgrades = 0;
    private static int experiance = 0;
    private static int money = 200;
    private static int inventoryItems = 0;
    private static final String[][] inventory = new String[255][9];
    //characterInventory - 0.NAME 1.STR 2.DEX 3.VIT 4.INT 5.DMG 6.DEF 7.TYPE 8.PRICE
    private static String[][] itemsOnHero = new String[4][9];
    private static int itemStrenght = 0;
    private static int itemDexterity = 0;
    private static int itemVitality = 0;
    private static int itemInteligence = 0;
    private static int itemDamage = 0;
    private static int itemDefense = 0;
    private static int hp = 10 * (getVitality() + getItemVitality());
    private static int mp = 10 * (getInteligence() + getItemInteligence());


    public Hero(String name){
        this.name = name;
    }
    
    public static DefaultListModel inventory() {
        DefaultListModel items = new DefaultListModel();
        try {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i][0] != null) {
                    items.addElement(inventory[i][0]);
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
        System.arraycopy(inventory[index], 0, item, 0, inventory[index].length);
        return item;
    }

    

    public static void addCharacterItems(int inventorySlot) {
        int slot = 0;
        switch (inventory[inventorySlot][7].trim()) {
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
        
        for (int i = 0; i < getItemsOnHero()[slot].length; i++) {
            setCharacterInventory(slot, i, getInventory()[inventorySlot][i]);
        }

    }


    public static void reloadItemStats() {
        itemStrenght = parseInt(itemsOnHero[1][1].trim()) + parseInt(itemsOnHero[2][1].trim()) + parseInt(itemsOnHero[3][1].trim());
        itemDexterity = parseInt(itemsOnHero[1][2].trim()) + parseInt(itemsOnHero[2][2].trim()) + parseInt(itemsOnHero[3][2].trim());
        itemVitality = parseInt(itemsOnHero[1][3].trim()) + parseInt(itemsOnHero[2][3].trim()) + parseInt(itemsOnHero[3][3].trim());
        itemInteligence = parseInt(itemsOnHero[1][4].trim()) + parseInt(itemsOnHero[2][4].trim()) + parseInt(itemsOnHero[3][4].trim());
        itemDamage = parseInt(itemsOnHero[1][5].trim());
        itemDefense = parseInt(itemsOnHero[2][6].trim()) + parseInt(itemsOnHero[3][6].trim());
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Hero.name = name;
    }

    public static void setInventory(int position, int stat, String value) {
        Hero.inventory[position][stat] = value;
    }
    
    public static String[][] getInventory() {
        return inventory;
    }

    public static void setHeroInventory(int indexX, int indexY, String value) {
        Hero.inventory[indexX][indexY] = value;
    }

    public static int getStrenght() {
        return strenght;
    }

    public static void setStrenght(int strenght) {
        Hero.strenght = strenght;
    }

    public static int getDexterity() {
        return dexterity;
    }

    public static void setDexterity(int dexterity) {
        Hero.dexterity = dexterity;
    }

    public static int getVitality() {
        return vitality;
    }

    public static void setVitality(int vitality) {
        Hero.vitality = vitality;
    }

    public static int getInteligence() {
        return inteligence;
    }

    public static void setInteligence(int inteligence) {
        Hero.inteligence = inteligence;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        Hero.level = level;
    }

    public static int getStatUpgrades() {
        return statUpgrades;
    }

    public static void setStatUpgrades(int statUpgrades) {
        Hero.statUpgrades = statUpgrades;
    }

    public static int getExperiance() {
        return experiance;
    }

    public static void setExperiance(int experiance) {
        Hero.experiance = experiance;
    }

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        Hero.money += money;
    }

    public static int getInventoryItems() {
        return inventoryItems;
    }

    public static void setInventoryItems(int inventoryItems) {
        Hero.inventoryItems += inventoryItems;
    }

    public static String[][] getItemsOnHero() {
        return itemsOnHero;
    }

    public static void setCharacterInventory(int type, int stat, String content) {
        Hero.itemsOnHero[type][stat] = content;
    }

    public static int getItemStrenght() {
        return itemStrenght;
    }


    public static void setItemStrenght(int itemStrenght) {
        Hero.itemStrenght = itemStrenght;
    }

    public static int getItemDexterity() {
        return itemDexterity;
    }

    public static void setItemDexterity(int itemDexterity) {
        Hero.itemDexterity = itemDexterity;
    }

    public static int getItemVitality() {
        return itemVitality;
    }

    public static void setItemVitality(int itemVitality) {
        Hero.itemVitality = itemVitality;
    }

    public static int getItemInteligence() {
        return itemInteligence;
    }

    public static void setItemInteligence(int itemInteligence) {
        Hero.itemInteligence = itemInteligence;
    }

    public static int getItemDamage() {
        return itemDamage;
    }

    public static void setItemDamage(int itemDamage) {
        Hero.itemDamage = itemDamage;
    }

    public static int getItemDefense() {
        return itemDefense;
    }

    public static void setItemDefense(int itemDefense) {
        Hero.itemDefense = itemDefense;
    }

    public static int getHp() {
        return hp;
    }

    public static void setHp(int hp) {
        Hero.hp = hp;
    }

    public static int getMp() {
        return mp;
    }

    public static void setMp(int mp) {
        Hero.mp = mp;
    }

}
