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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class Shop {

    private static String[][] inventory;
    private static String itemType;
    private static DefaultListModel listModel;
    // <editor-fold defaultstate="collapsed" desc="Old Buy()">

//    void buy() {
//        Utilities utilities = new Utilities();
//        Inputs input = new Inputs();
//        for (int i = 1; i < (inventory.length - 1); i++) {
//            if (i < 10) {
//                System.out.print("  ");
//            } else if (i < 100) {
//                System.out.print(" ");
//            }
//            System.out.print(i);
//            System.out.print(". ");
//            for (int j = 1; j < inventory[i].length; j++) {
//                System.out.print(inventory[i][j]);
//            }
//            System.out.println("");
//        }
//        System.out.print("Choose what do you want to buy: ");
//        int selection = Integer.valueOf(input.input());
//        System.out.println("");
//        String text = "Do you want to buy: "
//                + //Item name
//                inventory[selection][1]
//                + //Item Strenght
//                " STR: "
//                + inventory[selection][2]
//                + //Item Dexterity
//                " DEX: "
//                + inventory[selection][3]
//                + //Item Vitality
//                " VIT: "
//                + inventory[selection][4]
//                + //Item Inteligence
//                " INT: "
//                + inventory[selection][5]
//                + //Item damage
//                " DMG: "
//                + inventory[selection][6]
//                + //Item damage
//                " DEF: "
//                + inventory[selection][7]
//                + //Item price
//                " For: "
//                + inventory[selection][9]
//                + "gold ? [Yes/No]";
//        System.out.println(text);
//        switch (input.input()) {
//            case "Yes":
//
//                int line = 0;
//                try {
//                    line = getLines(Utilities.getTemp().getAbsolutePath());
//                } catch (IOException ex) {
//                    Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                String[] load = new String[line + 1];
//                if (Integer.valueOf(inventory[selection][9].trim()) > HeroStats.getMoney()) {
//                    System.out.println("You don't have enought money!");
//
//                } else {
//                    System.out.println("Sucessfuly bought " + inventory[selection][1]);
//
//                    FileReader fr = null;
//                    try {
//                        fr = new FileReader(Utilities.getTemp());
//                    } catch (FileNotFoundException ex) {
//                        Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    BufferedReader br = new BufferedReader(fr);
//                    HeroStats.setMoney(-Integer.valueOf(inventory[selection][9]));
//
//                    for (int i = 0; i < HeroStats.getInventoryItems(); i++) {
//                        try {
//                            load[i] = br.readLine();
//                        } catch (IOException ex) {
//                            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//
//                    }
//                    Utilities.getTemp().delete();
//                    try {
//                        Utilities.getTemp().createNewFile();
//                    } catch (IOException ex) {
//                        Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    FileWriter fw = null;
//                    try {
//                        fw = new FileWriter(Utilities.getTemp());
//                    } catch (IOException ex) {
//                        Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    BufferedWriter bw = new BufferedWriter(fw);
//                    Writer w = new BufferedWriter(bw);
//                    String[] work;
//                    for (int i = 0; i < HeroStats.getInventoryItems(); i++) {
//                        work = load[i].split(";");
//                        try {
//                            w.write(i + ";" + work[1] + ";" + work[2] + ";" + work[3] + ";" + work[4] + ";" + work[5] + ";" + work[6] + ";" + work[7] + ";" + work[8] + ";" + work[9]);
//                            w.write(System.lineSeparator());
//                            HeroStats.setInventoryItems(HeroStats.getInventoryItems() + 1);
//                            w.write(line
//                                    +//item name
//                                    ";"
//                                    + inventory[selection][1]
//                                    + //Item Strenght
//                                    ";"
//                                    + inventory[selection][2]
//                                    + //Item Dexterity
//                                    ";"
//                                    + inventory[selection][3]
//                                    + //Item Vitality
//                                    ";"
//                                    + inventory[selection][4]
//                                    + //Item Inteligence
//                                    ";"
//                                    + inventory[selection][5]
//                                    + //Item damage                           
//                                    ";"
//                                    + inventory[selection][6]
//                                    + //Item defense                          
//                                    ";"
//                                    + inventory[selection][7]
//                                    + //Item Type
//                                    ";"
//                                    + inventory[selection][8]
//                                    + //Item price
//                                    ";"
//                                    + (Integer.valueOf(inventory[selection][9]) / 2));
//                            System.out.println(Utilities.getTemp());
//                        } catch (IOException ex) {
//                            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//
//                    }
//
//                    try {
//                        w.close();
//                        fw.close();
//                        bw.close();
//                        fr.close();
//                        br.close();
//                    } catch (IOException ex) {
//                        Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                }
//
//        }
//
//    }
// </editor-fold> 
    public static void buy(int itemIndex) {
        System.out.println("Cena: "+inventory[itemIndex][9]);
        System.out.println("Aktualne: "+HeroStats.getMoney());
        if (Integer.valueOf(inventory[itemIndex][9]) <= HeroStats.getMoney()) {
            int j = 0;
            for (int i = 0; i < inventory[itemIndex].length; i++) {
                
                if (i != 8 && i != 0) {
                    HeroStats.setHeroInventory(HeroStats.getInventoryItems(), j, inventory[itemIndex][i]);
                    
                } else {
                    j--;
                }
                j++;
            }
            HeroStats.setInventoryItems(1);
        }
    }

    public static void loadShop() {
        String path = "./Resources/Shop/" + getItemType() + ".txt";
        int numberOfLines = 0;
        try {
            numberOfLines = getLines(path);
        } catch (IOException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader bufferedReader;
        try (FileReader fileReader = new FileReader(path)) {
            bufferedReader = new BufferedReader(fileReader);
            int i = 1;
            inventory = new String[numberOfLines + 1][10];
            while (i < numberOfLines) {
                String readed = bufferedReader.readLine();
                if (readed.contains("##")) {
                } else {
                    String[] part = readed.split(";");
                    //Item ID
                    inventory[i][0] = part[0];
                    //Item name
                    inventory[i][1] = part[1];
                    //Item Strenght
                    inventory[i][2] = part[2];
                    //Item Dexterity
                    inventory[i][3] = part[3];
                    //Item Vitality
                    inventory[i][4] = part[4];
                    //Item Inteligence
                    inventory[i][5] = part[5];
                    //Item damage
                    inventory[i][6] = part[6];
                    //Item defense
                    inventory[i][7] = part[7];
                    //Item Type
                    inventory[i][8] = part[8];
                    //Item price
                    inventory[i][9] = part[9];

                    i++;
                }
            }

            bufferedReader.close();
        } catch (IOException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int getLines(String path) throws IOException {
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
        FileReader fileReader = new FileReader(Utilities.getTemp());
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int numberOfItems = getLines(Utilities.getTemp().getPath());
        String[] items = new String[numberOfItems];
        if (numberOfItems == 0) {
            System.out.println("Nothing to sell in backpack.");

        } else {
            for (int i = 1; i < HeroStats.getInventoryItems(); i++) {
                String readed = bufferedReader.readLine();
                System.out.println(readed);
                items[i] = readed;
            }
            fileReader.close();
            bufferedReader.close();
        }
    }

    public static void removeInventory() {
        inventory = new String[0][0];
    }

    public static String[] getItemStats(int index) {
        String[] item = new String[10];
        System.arraycopy(inventory[index], 0, item, 0, inventory[index].length);
        return item;
    }

    public static String[][] getInventory() {
        return inventory;
    }

    public static void setLines(int Index1, int Index2, String lines) {
        Shop.inventory[Index1][Index2] = lines;
    }

    public static String getItemType() {
        if (itemType == null) {
            setItemType("Weapons");
        }
        return itemType;
    }

    public static void setItemType(String itemType) {
        Shop.itemType = itemType;
    }

    public static DefaultListModel getDefaultListModel() {
        return listModel;
    }

    public static void getItemNames() {
        listModel = new DefaultListModel();
        for (int i = 1; i < inventory.length - 1; i++) {
            listModel.addElement(getInventory()[i][1].trim());
        }

    }
}
