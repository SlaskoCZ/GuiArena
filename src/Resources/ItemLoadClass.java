/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ItemLoadClass {

    private static String[] enemyNames;

    public static String[][] jarLoadItems(String fileName) {
        String[][] items = new String[255][10];
        Object object = new Object();
        BufferedReader txtReader = new BufferedReader(new InputStreamReader(object.getClass().getResourceAsStream("/Resources/" + fileName + ".txt")));
        try {
            for (int i = 0; txtReader.ready(); i++) {
                String[] part = txtReader.readLine().split(";");
                for (int j = 0; j < part.length; j++) {
                    items[i][j] = part[j].trim();
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return items;
    }

    public static String jarLoadEnemyFromXML(String XMLFile, String EnemyNumber, String statName) {
        NodeList nodes = null;
        if (Integer.valueOf(EnemyNumber)<10 && Integer.valueOf(EnemyNumber)>=1) {
            EnemyNumber = "E00"+ EnemyNumber;
        } else if (Integer.valueOf(EnemyNumber)<100 && Integer.valueOf(EnemyNumber)>10) {
            EnemyNumber = "E0"+ EnemyNumber;
        } else if (Integer.valueOf(EnemyNumber)<100) {
            EnemyNumber = "E"+ EnemyNumber;
        } else {
            System.out.println("Error Somewhere ! returning 1st enemy");
            EnemyNumber = "E001";
        }
        try {
            InputStream inputStream = ItemLoadClass.class.getResourceAsStream(XMLFile);
            DocumentBuilderFactory domFactory
                    = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware(true);
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document doc = builder.parse(inputStream);
            XPath xpath = XPathFactory.newInstance().newXPath();
            // XPath Query for showing all nodes value
            System.out.println(EnemyNumber +" "+ statName);
            XPathExpression expr = xpath.compile("//Enemy[@ID='" + EnemyNumber + "']/" + statName.trim() + "/text()");

            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            nodes = (NodeList) result;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ItemLoadClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(ItemLoadClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ItemLoadClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemLoadClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("ItemLoadClass:jarLoadEnemyFromXML = " + nodes.item(0).getNodeValue());
        return nodes.item(0).getNodeValue();
    }

    public static int getNumberOfEnemiesinXML(String XMLFile) {
        NodeList nodes = null;
        try {
            InputStream inputStream = ItemLoadClass.class.getResourceAsStream(XMLFile);
            DocumentBuilderFactory domFactory
                    = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware(true);
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document doc = builder.parse(inputStream);
            XPath xpath = XPathFactory.newInstance().newXPath();
            // XPath Query for showing all nodes value

            XPathExpression expr = xpath.compile("//Enemy");

            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            nodes = (NodeList) result;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ItemLoadClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(ItemLoadClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ItemLoadClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemLoadClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nodes.getLength();
    }

    public static String[] getNamesOfAllEnemiesInXML(String XMLFile, String EnemyType, int numberOfFirstEnemyInList) {
        NodeList nodes = null;

        try {
            InputStream inputStream = ItemLoadClass.class.getResourceAsStream(XMLFile);
            DocumentBuilderFactory domFactory
                    = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware(true);
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document doc = builder.parse(inputStream);
            XPath xpath = XPathFactory.newInstance().newXPath();
            // XPath Query for showing all nodes value

            XPathExpression expr = xpath.compile("//" + EnemyType + "-List/Enemy[@level<='"+Metods.Hero.getLevel()+"']/Name/text()");

            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            nodes = (NodeList) result;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ItemLoadClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(ItemLoadClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ItemLoadClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemLoadClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (EnemyType.equalsIgnoreCase("Boss") && enemyNames!= null) {
            String[] temp = enemyNames;
            enemyNames = new String[nodes.getLength() + numberOfFirstEnemyInList];
            for (int i = 0; i < temp.length; i++) {
                enemyNames[i] = temp[i];
            }
        } else {
            enemyNames = new String[nodes.getLength() + numberOfFirstEnemyInList];
        }
        int j = 0;
        for (int i = numberOfFirstEnemyInList; i < nodes.getLength() + numberOfFirstEnemyInList; i++) {
            System.out.println("Enemy Loaded: " + nodes.item(j).getNodeValue());
            enemyNames[i] = (j + 1) + ". " + nodes.item(j).getNodeValue();
            j++;
        }
        return enemyNames;
    }
}
