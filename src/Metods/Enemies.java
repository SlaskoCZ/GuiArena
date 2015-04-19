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
public class Enemies {

    private static int enemyhp = 0;
    private static int enemymp = 0;
    private static int enemystrenght = 0;
    private static int enemydexterity = 0;
    private static int enemyvitality = 0;
    private static int enemyinteligence = 0;
    private static int enemylevel = 0;
    private static String enemyName = null;
    private static int baseExp = 0;

    public static void enemy(int enemy) {
        //Enemy level
        Enemies.enemylevel = (int) (Math.round((Math.random() * HeroStats.getLevel() + 1) - (Math.random() * HeroStats.getLevel() + 1)));
        while (Enemies.enemylevel < 1) {
            Enemies.enemylevel++;
        }
        //Enemy declaration
        switch (enemy) {
            case 69696969:
                System.out.println("Test Monster");
                Enemies.enemyName = "TEST CUBE";
                Enemies.enemystrenght = (int) (1);
                Enemies.enemydexterity = (int) (1000);
                Enemies.enemyvitality = (int) (10);
                Enemies.enemyinteligence = (int) (10);
                Enemies.enemymp = enemyinteligence * 100;
                Enemies.enemyhp = enemyvitality * 1000;
                Enemies.baseExp = 100;

                break;
            case 1:
                troll();
                break;
            case 2:
                dwarf();
                break;
            case 3:
                wolf();
                break;
            case 4:
                pixie();
                break;
            case 5:
                rock();
                break;
            case 6:
                boss();
                break;

        }

    }

    public static String[] getEnemyList() {
        String[] enemyList = {"1. Troll",
            "2. Dwarf",
            "3. Wolf",
            "4. Pixie",
            "5. Rock"

        };
        return enemyList;
    }

    private static void troll() {
        Enemies.enemyName = "Troll";
        Enemies.enemystrenght = (int) (10);
        Enemies.enemydexterity = (int) (10);
        Enemies.enemyvitality = (int) (10);
        Enemies.enemyinteligence = (int) (10);
        Enemies.enemymp = Enemies.enemyinteligence * 10;
        Enemies.enemyhp = Enemies.enemyvitality * 10;
        Enemies.baseExp = 20;
    }

    private static void dwarf() {
        Enemies.enemyName = "Dwarf";
        Enemies.enemystrenght = (int) (10);
        Enemies.enemydexterity = (int) (10);
        Enemies.enemyvitality = (int) (10);
        Enemies.enemyinteligence = (int) (10);
        Enemies.enemymp = Enemies.enemyinteligence * 10;
        Enemies.enemyhp = Enemies.enemyvitality * 10;
        Enemies.baseExp = 20;
    }

    private static void wolf() {
        Enemies.enemyName = "Wolf";
        Enemies.enemystrenght = (int) (10);
        Enemies.enemydexterity = (int) (10);
        Enemies.enemyvitality = (int) (10);
        Enemies.enemyinteligence = (int) (10);
        Enemies.enemymp = Enemies.enemyinteligence * 10;
        Enemies.enemyhp = Enemies.enemyvitality * 10;
        Enemies.baseExp = 20;
    }

    private static void pixie() {
        Enemies.enemyName = "Pixie";
        Enemies.enemystrenght = (int) (10);
        Enemies.enemydexterity = (int) (10);
        Enemies.enemyvitality = (int) (10);
        Enemies.enemyinteligence = (int) (10);
        Enemies.enemymp = Enemies.enemyinteligence * 10;
        Enemies.enemyhp = Enemies.enemyvitality * 10;
        Enemies.baseExp = 20;
    }

    private static void rock() {
        Enemies.enemyName = "Rock";
        Enemies.enemystrenght = (int) (10);
        Enemies.enemydexterity = (int) (10);
        Enemies.enemyvitality = (int) (10);
        Enemies.enemyinteligence = (int) (10);
        Enemies.enemymp = Enemies.enemyinteligence * 10;
        Enemies.enemyhp = Enemies.enemyvitality * 10;
        Enemies.baseExp = 20;
    }

    private static void boss() {
        Enemies.enemyName = "Potatoe";
        Enemies.enemystrenght = (int) (100);
        Enemies.enemydexterity = (int) (100);
        Enemies.enemyvitality = (int) (100);
        Enemies.enemyinteligence = (int) (100);
        Enemies.enemymp = Enemies.enemyinteligence * 10;
        Enemies.enemyhp = Enemies.enemyvitality * 100;
        Enemies.baseExp = 1000;
    }

    public static int getEnemyhp() {
        return enemyhp;
    }

    public static void setEnemyhp(int enemyhp) {
        if (enemyhp<0) {
            enemyhp = 0;
            }      
        Enemies.enemyhp = enemyhp;
    }

    public static int getEnemymp() {
        return enemymp;
    }

    public static void setEnemymp(int enemymp) {
        if (enemymp<0) {
            enemymp = 0;
            }   
        Enemies.enemymp = enemymp;
    }

    public static int getEnemystrenght() {
        return enemystrenght;
    }

    public static void setEnemystrenght(int enemystrenght) {
        if (enemystrenght<0) {
            enemystrenght = 0;
            }   
        Enemies.enemystrenght = enemystrenght;
    }

    public static int getEnemydexterity() {
        return enemydexterity;
    }

    public static void setEnemydexterity(int enemydexterity) {
        Enemies.enemydexterity = enemydexterity;
    }

    public static int getEnemyvitality() {
        return enemyvitality;
    }

    public static void setEnemyvitality(int enemyvitality) {
        Enemies.enemyvitality = enemyvitality;
    }

    public static int getEnemyinteligence() {
        return enemyinteligence;
    }

    public static void setEnemyinteligence(int enemyinteligence) {
        Enemies.enemyinteligence = enemyinteligence;
    }

    public static int getEnemylevel() {
        return enemylevel;
    }

    public static void setEnemylevel(int enemylevel) {
        Enemies.enemylevel = enemylevel;
    }

    public static String getEnemyName() {
        return enemyName;
    }

    public static void setEnemyName(String enemyName) {
        Enemies.enemyName = enemyName;
    }

    public static int getBaseExp() {
        return baseExp;
    }

    public static void setBaseExp(int baseExp) {
        Enemies.baseExp = baseExp;
    }

}
