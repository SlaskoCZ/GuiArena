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
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
            w.write("\t\t\t<inventory " + "items=" + quotationMarks + Hero.getInventoryItems() + quotationMarks + ">" + System.lineSeparator());
            for (int i = 0; i < Hero.getInventoryItems(); i++) {
                w.write("\t\t\t\t<item "
                        + "id=" + quotationMarks + i + quotationMarks + " "
                        + "name=" + quotationMarks + Hero.getInventory()[i][0].trim() + quotationMarks + " "
                        + "INT=" + quotationMarks + Hero.getInventory()[i][4].trim() + quotationMarks + " "
                        + "VIT=" + quotationMarks + Hero.getInventory()[i][3].trim() + quotationMarks + " "
                        + "DEX=" + quotationMarks + Hero.getInventory()[i][2].trim() + quotationMarks + " "
                        + "STR=" + quotationMarks + Hero.getInventory()[i][1].trim() + quotationMarks + " "
                        + "DMG=" + quotationMarks + Hero.getInventory()[i][5].trim() + quotationMarks + " "
                        + "DEF=" + quotationMarks + Hero.getInventory()[i][6].trim() + quotationMarks + " "
                        + "Type=" + quotationMarks + Hero.getInventory()[i][7].trim() + quotationMarks + " "
                        + "Price=" + quotationMarks + Hero.getInventory()[i][8].trim() + quotationMarks + "/>"
                        + System.lineSeparator());
            }
            w.write("\t\t\t</inventory>" + System.lineSeparator());

            w.write("\t\t</hero>" + System.lineSeparator());
            w.write("\t</root>" + System.lineSeparator());
            updateData("save" + fileNumber, "save", "1");
        } catch (FileNotFoundException ex) {

            Logger.getLogger(SaveAndLoad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveAndLoad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void updateData(String targetAtribute, String targetName, String target) {
        XPathExpression expr;
        Document doc;
        try {
            File data = new File(Utilities.getPathToDir() + "\\data.gad");
            DocumentBuilderFactory domFactory
                    = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware(true);
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            doc = builder.parse(data);
            XPath xpath = XPathFactory.newInstance().newXPath();
            System.out.println("save");
            if (targetName.equals("save")) {

                expr = xpath.compile("//save/@" + targetAtribute);
            } else {
                expr = xpath.compile("//root");
            }

            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            nodes.item(0).setTextContent(target);
            System.out.println("result");
            System.out.println(nodes.item(0).getTextContent());

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(Utilities.getPathToDir() + "\\data.gad"));
            transformer.transform(source, result);
        } catch (XPathExpressionException | SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(SaveAndLoad.class.getName()).log(Level.SEVERE, null, ex);

        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(SaveAndLoad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(SaveAndLoad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void load(int fileNumber) {
        Document doc;
        try {
            File data = new File(Utilities.getPathToSave() + "\\savegame" + fileNumber + ".gas");
            DocumentBuilderFactory domFactory
                    = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware(true);
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            doc = builder.parse(data);
            XPath xpath = XPathFactory.newInstance().newXPath();
            NodeList nodelist = (NodeList) xpath.evaluate("//info/@*", doc, XPathConstants.NODESET);
            for (int i = 0; i < nodelist.getLength(); i++) {
                System.out.println("Attribut: " + nodelist.item(i).getNodeName() + " Value: " + nodelist.item(i).getTextContent());
                switch (nodelist.item(i).getNodeName().toLowerCase()) {
                    case "exp":
                        Hero.setExperiance(Integer.valueOf(nodelist.item(i).getTextContent()));
                        break;
                    case "money":
                        Hero.setMoney(Integer.valueOf(nodelist.item(i).getTextContent()));
                        break;
                    case "name":
                        Hero.setName(nodelist.item(i).getTextContent());
                        break;
                }
            }
            System.out.println("Stats:");
            nodelist = (NodeList) xpath.evaluate("//stats/@*", doc, XPathConstants.NODESET);
            for (int i = 0; i < nodelist.getLength(); i++) {
                System.out.println("Attribut: " + nodelist.item(i).getNodeName() + " Value: " + nodelist.item(i).getTextContent());
                switch (nodelist.item(i).getNodeName().toLowerCase()) {
                    case "dex":
                        Hero.setDexterity(Integer.valueOf(nodelist.item(i).getTextContent()));
                        break;
                    case "int":
                        Hero.setInteligence(Integer.valueOf(nodelist.item(i).getTextContent()));
                        break;
                    case "level":
                        Hero.setLevel(Integer.valueOf(nodelist.item(i).getTextContent()));
                        break;
                    case "str":
                        Hero.setStrenght(Integer.valueOf(nodelist.item(i).getTextContent()));
                        break;
                    case "vit":
                        Hero.setVitality(Integer.valueOf(nodelist.item(i).getTextContent()));
                        break;
                    case "hp":
                        Hero.setHp(Integer.valueOf(nodelist.item(i).getTextContent()));
                        break;
                    case "mp":
                        Hero.setMp(Integer.valueOf(nodelist.item(i).getTextContent()));
                        break;
                }
            }
            System.out.println("Weapons:");
            nodelist = (NodeList) xpath.evaluate("//weapon/@*", doc, XPathConstants.NODESET);
            for (int i = 0; i < nodelist.getLength(); i++) {
                System.out.println("Attribut: " + nodelist.item(i).getNodeName() + " Value: " + nodelist.item(i).getTextContent());
                switch (nodelist.item(i).getNodeName().toLowerCase()) {
                    case "dex":
                        Hero.setCharacterInventory(1, 2, nodelist.item(i).getTextContent());
                        break;
                    case "int":
                        Hero.setCharacterInventory(1, 4, nodelist.item(i).getTextContent());
                        break;
                    case "dmg":
                        Hero.setCharacterInventory(1, 5, nodelist.item(i).getTextContent());
                        break;
                    case "str":
                        Hero.setCharacterInventory(1, 1, nodelist.item(i).getTextContent());
                        break;
                    case "vit":
                        Hero.setCharacterInventory(1, 3, nodelist.item(i).getTextContent());
                        break;
                    case "def":
                        Hero.setCharacterInventory(1, 6, nodelist.item(i).getTextContent());
                        break;
                    case "price":
                        Hero.setCharacterInventory(1, 8, nodelist.item(i).getTextContent());
                        break;
                    case "type":
                        Hero.setCharacterInventory(1, 7, nodelist.item(i).getTextContent());
                        break;
                    case "name":
                        Hero.setCharacterInventory(1, 0, nodelist.item(i).getTextContent());
                        break;
                }
            }
            System.out.println("Shield:");
            nodelist = (NodeList) xpath.evaluate("//shield/@*", doc, XPathConstants.NODESET);
            for (int i = 0; i < nodelist.getLength(); i++) {
                System.out.println("Attribut: " + nodelist.item(i).getNodeName() + " Value: " + nodelist.item(i).getTextContent());
                switch (nodelist.item(i).getNodeName().toLowerCase()) {
                    case "dex":
                        Hero.setCharacterInventory(2, 2, nodelist.item(i).getTextContent());
                        break;
                    case "int":
                        Hero.setCharacterInventory(2, 4, nodelist.item(i).getTextContent());
                        break;
                    case "dmg":
                        Hero.setCharacterInventory(2, 5, nodelist.item(i).getTextContent());
                        break;
                    case "str":
                        Hero.setCharacterInventory(2, 1, nodelist.item(i).getTextContent());
                        break;
                    case "vit":
                        Hero.setCharacterInventory(2, 3, nodelist.item(i).getTextContent());
                        break;
                    case "def":
                        Hero.setCharacterInventory(2, 6, nodelist.item(i).getTextContent());
                        break;
                    case "price":
                        Hero.setCharacterInventory(2, 8, nodelist.item(i).getTextContent());
                        break;
                    case "type":
                        Hero.setCharacterInventory(2, 7, nodelist.item(i).getTextContent());
                        break;
                    case "name":
                        Hero.setCharacterInventory(2, 0, nodelist.item(i).getTextContent());
                        break;
                }
            }
            System.out.println("Armor:");
            nodelist = (NodeList) xpath.evaluate("//armor/@*", doc, XPathConstants.NODESET);
            for (int i = 0; i < nodelist.getLength(); i++) {
                System.out.println("Attribut: " + nodelist.item(i).getNodeName() + " Value: " + nodelist.item(i).getTextContent());
                switch (nodelist.item(i).getNodeName().toLowerCase()) {
                    case "dex":
                        Hero.setCharacterInventory(3, 2, nodelist.item(i).getTextContent());
                        break;
                    case "int":
                        Hero.setCharacterInventory(3, 4, nodelist.item(i).getTextContent());
                        break;
                    case "dmg":
                        Hero.setCharacterInventory(3, 5, nodelist.item(i).getTextContent());
                        break;
                    case "str":
                        Hero.setCharacterInventory(3, 1, nodelist.item(i).getTextContent());
                        break;
                    case "vit":
                        Hero.setCharacterInventory(3, 3, nodelist.item(i).getTextContent());
                        break;
                    case "def":
                        Hero.setCharacterInventory(3, 6, nodelist.item(i).getTextContent());
                        break;
                    case "price":
                        Hero.setCharacterInventory(3, 8, nodelist.item(i).getTextContent());
                        break;
                    case "type":
                        Hero.setCharacterInventory(3, 7, nodelist.item(i).getTextContent());
                        break;
                    case "name":
                        Hero.setCharacterInventory(3, 0, nodelist.item(i).getTextContent());
                        break;
                }
            }
            nodelist = (NodeList) xpath.evaluate("//item", doc, XPathConstants.NODESET);
            System.out.println("number of items: " + nodelist.getLength());
            if (nodelist.getLength() > 0) {
                System.out.println("Loading Items!");

                for (int i = 0; i < nodelist.getLength(); i++) {
                    NodeList nl = (NodeList) xpath.evaluate("//item[@id='" + i + "']/@*", doc, XPathConstants.NODESET);
                    System.out.println(nl.getLength());
                    for (int j = 0; j < 10; j++) {
                        System.out.println("Item: " + i + " Attribut: " + nl.item(j).getNodeName() + " Value: " + nl.item(j).getTextContent());
                        switch (nl.item(j).getNodeName().toLowerCase()) {
                            case "dex":
                                Hero.setInventory(i, 2, nl.item(j).getTextContent());
                                break;
                            case "int":
                                Hero.setInventory(i, 4, nl.item(j).getTextContent());
                                break;
                            case "dmg":
                                Hero.setInventory(i, 5, nl.item(j).getTextContent());
                                break;
                            case "str":
                                Hero.setInventory(i, 1, nl.item(j).getTextContent());
                                break;
                            case "vit":
                                Hero.setInventory(i, 3, nl.item(j).getTextContent());
                                break;
                            case "def":
                                Hero.setInventory(i, 6, nl.item(j).getTextContent());
                                break;
                            case "price":
                                Hero.setInventory(i, 8, nl.item(j).getTextContent());
                                break;
                            case "type":
                                Hero.setInventory(i, 7, nl.item(j).getTextContent());
                                break;
                            case "name":
                                Hero.setInventory(i, 0, nl.item(j).getTextContent());
                                break;
                        }
                    }
                    Hero.setInventoryItems(1);
                }
            }

        } catch (SAXException | IOException | ParserConfigurationException | XPathExpressionException ex) {
            Logger.getLogger(SaveAndLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
