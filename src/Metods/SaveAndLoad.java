/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metods;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveAndLoad {

    public static void save(int fileNumber) {
        File file = new File(Utilities.getPathToSave() + "\\savegame" + fileNumber + ".gas");
        try {
            if (file.exists()) {
                file.delete();
                file.createNewFile();
            } else {
                file.createNewFile();
            }

        } catch (IOException ex) {
            Logger.getLogger(SaveAndLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(file.getAbsolutePath());
        try (Writer w = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file.getAbsolutePath()), "ISO-8859-1"))) {
            char quotationMarks = '"';
            System.out.println("Started Writing...");
            w.write("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" + System.lineSeparator());
            w.write("\t<root>" + System.lineSeparator());
            w.write("\t\t<hero>" + System.lineSeparator());
            w.write("\t\t\t<info "
                    + "EXP=" + quotationMarks + Metods.Hero.getExperiance() + quotationMarks + " "
                    + "money=" + quotationMarks + Metods.Hero.getMoney() + quotationMarks + " "
                    + "name=" + quotationMarks + Metods.Hero.getName() + quotationMarks + "/>"
                    + System.lineSeparator());
            w.write("\t\t\t<stats "
                    + "mp=" + quotationMarks + Hero.getMp() + quotationMarks + " "
                    + "hp=" + quotationMarks + Hero.getHp() + quotationMarks + " "
                    + "Level=" + quotationMarks + Hero.getLevel() + quotationMarks + " "
                    + "INT=" + quotationMarks + Hero.getInteligence() + quotationMarks + " "
                    + "VIT=" + quotationMarks + Hero.getVitality() + quotationMarks + " "
                    + "DEX=" + quotationMarks + Hero.getDexterity() + quotationMarks + " "
                    + "STR=" + quotationMarks + Hero.getStrenght() + quotationMarks + "/>"
                    + System.lineSeparator());
            w.write("\t\t\t<characterInventory>" + System.lineSeparator());
            w.write("\t\t\t\t<weapon "
                    + "name=" + quotationMarks + Hero.getItemsOnHero()[1][0] + quotationMarks + " "
                    + "INT=" + quotationMarks + Hero.getItemsOnHero()[1][4] + quotationMarks + " "
                    + "VIT=" + quotationMarks + Hero.getItemsOnHero()[1][3] + quotationMarks + " "
                    + "DEX=" + quotationMarks + Hero.getItemsOnHero()[1][2] + quotationMarks + " "
                    + "STR=" + quotationMarks + Hero.getItemsOnHero()[1][1] + quotationMarks + " "
                    + "DMG=" + quotationMarks + Hero.getItemsOnHero()[1][5] + quotationMarks + " "
                    + "DEF=" + quotationMarks + Hero.getItemsOnHero()[1][6] + quotationMarks + " "
                    + "Type=" + quotationMarks + Hero.getItemsOnHero()[1][7] + quotationMarks + " "
                    + "Price=" + quotationMarks + Hero.getItemsOnHero()[1][8] + quotationMarks + "/>"
                    + System.lineSeparator());
            w.write("\t\t\t\t<shield "
                    + "name=" + quotationMarks + Hero.getItemsOnHero()[2][0] + quotationMarks + " "
                    + "INT=" + quotationMarks + Hero.getItemsOnHero()[2][4] + quotationMarks + " "
                    + "VIT=" + quotationMarks + Hero.getItemsOnHero()[2][3] + quotationMarks + " "
                    + "DEX=" + quotationMarks + Hero.getItemsOnHero()[2][2] + quotationMarks + " "
                    + "STR=" + quotationMarks + Hero.getItemsOnHero()[2][1] + quotationMarks + " "
                    + "DMG=" + quotationMarks + Hero.getItemsOnHero()[2][5] + quotationMarks + " "
                    + "DEF=" + quotationMarks + Hero.getItemsOnHero()[2][6] + quotationMarks + " "
                    + "Type=" + quotationMarks + Hero.getItemsOnHero()[2][7] + quotationMarks + " "
                    + "Price=" + quotationMarks + Hero.getItemsOnHero()[2][8] + quotationMarks + "/>"
                    + System.lineSeparator());
            w.write("\t\t\t\t<armor "
                    + "name=" + quotationMarks + Hero.getItemsOnHero()[3][0] + quotationMarks + " "
                    + "INT=" + quotationMarks + Hero.getItemsOnHero()[3][4] + quotationMarks + " "
                    + "VIT=" + quotationMarks + Hero.getItemsOnHero()[3][3] + quotationMarks + " "
                    + "DEX=" + quotationMarks + Hero.getItemsOnHero()[3][2] + quotationMarks + " "
                    + "STR=" + quotationMarks + Hero.getItemsOnHero()[3][1] + quotationMarks + " "
                    + "DMG=" + quotationMarks + Hero.getItemsOnHero()[3][5] + quotationMarks + " "
                    + "DEF=" + quotationMarks + Hero.getItemsOnHero()[3][6] + quotationMarks + " "
                    + "Type=" + quotationMarks + Hero.getItemsOnHero()[3][7] + quotationMarks + " "
                    + "Price=" + quotationMarks + Hero.getItemsOnHero()[3][8] + quotationMarks + "/>"
                    + System.lineSeparator());
            w.write("\t\t\t</characterInventory>" + System.lineSeparator());
            w.write("\t\t\t<inventory>" + System.lineSeparator());
            for (int i = 0; i < Hero.getInventoryItems(); i++) {
                w.write("\t\t\t\t<item"
                        + "name=" + quotationMarks + Hero.getInventory()[i][0] + quotationMarks + " "
                        + "INT=" + quotationMarks + Hero.getInventory()[i][4] + quotationMarks + " "
                        + "VIT=" + quotationMarks + Hero.getInventory()[i][3] + quotationMarks + " "
                        + "DEX=" + quotationMarks + Hero.getInventory()[i][2] + quotationMarks + " "
                        + "STR=" + quotationMarks + Hero.getInventory()[i][1] + quotationMarks + " "
                        + "DMG=" + quotationMarks + Hero.getInventory()[i][5] + quotationMarks + " "
                        + "DEF=" + quotationMarks + Hero.getInventory()[i][6] + quotationMarks + " "
                        + "Type=" + quotationMarks + Hero.getInventory()[i][7] + quotationMarks + " "
                        + "Price=" + quotationMarks + Hero.getInventory()[i][8] + quotationMarks + "/>"
                        + System.lineSeparator());
            }
            w.write("\t\t\t</inventory>" + System.lineSeparator());

            w.write("\t\t<hero>" + System.lineSeparator());
            w.write("\t<root>" + System.lineSeparator());
        } catch (FileNotFoundException ex) {

            Logger.getLogger(SaveAndLoad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveAndLoad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
