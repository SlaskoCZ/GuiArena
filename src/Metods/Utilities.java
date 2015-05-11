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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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

    public static void systemInit() {
        System.out.println("System Init");
//        try {
        // fill characterInventory array with 0
        for (int i = 0; i < Hero.getItemsOnHero().length; i++) {
            for (int j = 0; j < Hero.getItemsOnHero()[i].length; j++) {
                Hero.setCharacterInventory(i, j, "0");
            }
        }

        timer(100, "reload");
        setDificulty("Normal");

        //set Loads
        createFiles();
        setLoads();
    }

    public static void setLoads() {
        try {
            File data = new File(Utilities.getPathToDir() + "\\data.gad");
            DocumentBuilderFactory domFactory
                    = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware(true);
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document doc = builder.parse(data);
            XPath xpath = XPathFactory.newInstance().newXPath();
            NodeList nodeListSaves = (NodeList) xpath.evaluate("//gamedata/save/@*", doc, XPathConstants.NODESET);
            //@todo make timestamps on saves
            NodeList nodeListSaveTimes = (NodeList) xpath.evaluate("//gamedata/saveTimes/@*", doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeListSaves.getLength(); i++) {
                switch (nodeListSaves.item(i).getNodeName()) {
                    case "save1":
                        System.out.println("Save1: " + nodeListSaves.item(i).getNodeValue());
                        if (nodeListSaves.item(i).getNodeValue().equalsIgnoreCase("1")) {
                            Arena.MainClass.menuFileLoadMenuLoad1.setEnabled(true);
                        } else {
                            Arena.MainClass.menuFileLoadMenuLoad1.setEnabled(false);
                        }
                        break;
                    case "save2":
                        System.out.println("Save2: " + nodeListSaves.item(i).getNodeValue());
                        if (nodeListSaves.item(i).getNodeValue().equalsIgnoreCase("1")) {
                            Arena.MainClass.menuFileLoadMenuLoad2.setEnabled(true);
                        } else {
                            Arena.MainClass.menuFileLoadMenuLoad2.setEnabled(false);
                        }
                        break;
                    case "save3":
                        System.out.println("Save3: " + nodeListSaves.item(i).getNodeValue());
                        if (nodeListSaves.item(i).getNodeValue().equalsIgnoreCase("1")) {
                            Arena.MainClass.menuFileLoadMenuLoad3.setEnabled(true);
                        } else {
                            Arena.MainClass.menuFileLoadMenuLoad3.setEnabled(false);
                        }
                        break;
                    case "save4":
                        System.out.println("Save4: " + nodeListSaves.item(i).getNodeValue());
                        if (nodeListSaves.item(i).getNodeValue().equalsIgnoreCase("1")) {
                            Arena.MainClass.menuFileLoadMenuLoad4.setEnabled(true);
                        } else {
                            Arena.MainClass.menuFileLoadMenuLoad4.setEnabled(false);
                        }
                        break;
                    case "save5":
                        System.out.println("Save5: " + nodeListSaves.item(i).getNodeValue());
                        if (nodeListSaves.item(i).getNodeValue().equalsIgnoreCase("1")) {
                            Arena.MainClass.menuFileLoadMenuLoad5.setEnabled(true);
                        } else {
                            Arena.MainClass.menuFileLoadMenuLoad5.setEnabled(false);
                        }
                        break;
                }
            }
        } catch (SAXException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void createFiles() {
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
                    SaveAndLoad.updateData("save"+i, "save", "0");
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
                            + "save1=" + quotationMarks + "0" + quotationMarks + " "
                            + "save2=" + quotationMarks + "0" + quotationMarks + " "
                            + "save3=" + quotationMarks + "0" + quotationMarks + " "
                            + "save4=" + quotationMarks + "0" + quotationMarks + " "
                            + "save5=" + quotationMarks + "0" + quotationMarks + "/>"
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
    }


    public static double randomNumber(double min, double max, boolean round) {
        if (round == true) {
            return Math.round(Math.random() * (max - min) + min);
        } else {
            return Math.random() * (max - min) + min;
        }
    }


    private static void timer(int delay, final String task) {
        setDelay(delay);

        ActionListener timer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (task.equalsIgnoreCase("reload")){
                    Arena.MainClass.reloadHeroStats();
                }
                
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
