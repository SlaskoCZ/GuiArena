/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ItemLoadClass {

    public static String[][] jarLoadItems(String fileName) {
        String[][] items = new String[255][10];
        Object object = new Object();
        System.out.println("Jar File !");
        System.out.println(object.getClass().getResource("/Resources/" + fileName + ".txt"));
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
}
