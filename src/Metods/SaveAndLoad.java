/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metods;

import Resources.ItemLoadClass;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
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
                w.write("\t\t\t\t<item"
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

            w.write("\t\t<hero>" + System.lineSeparator());
            w.write("\t<root>" + System.lineSeparator());
            updateData("save"+fileNumber, "save", "1");
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
            StreamResult result = new StreamResult(new File(Utilities.getPathToDir()+"\\data.gad"));
            transformer.transform(source, result);
        } catch (XPathExpressionException | SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(SaveAndLoad.class.getName()).log(Level.SEVERE, null, ex);

        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(SaveAndLoad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(SaveAndLoad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
