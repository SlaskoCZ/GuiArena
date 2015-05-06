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
    private static String[] enemyLoadStats = new String[]{"Name", "STR", "DEX", "VIT", "INT", "EXP"};

    public Enemies(int enemy) {
        
        this.setEnemyName(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[0]));
        this.setEnemystrenght(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[1])));
        this.setEnemydexterity(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[2])));
        this.setEnemyvitality(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[3])));
        this.setEnemyinteligence(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[4])));
        this.setBaseExp(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[5])));
        this.setEnemyhp(getEnemyvitality()*10);
        this.setEnemymp(getEnemyinteligence()*10);

    }

    public Enemies() {
        int enemy = (int)Metods.Utilities.randomNumber(1, Resources.ItemLoadClass.getNumberOfEnemiesinXML("EnemyList.xml"), true);
        this.setEnemyName(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[0]));
        this.setEnemystrenght(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[1])));
        this.setEnemydexterity(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[2])));
        this.setEnemyvitality(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[3])));
        this.setEnemyinteligence(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[4])));
        this.setBaseExp(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[5])));
    }

    public static String[] getEnemyList() {
        System.out.println("Loading Enemies");
        String[] enemyList = Resources.ItemLoadClass.getNamesOfAllEnemiesInXML("EnemyList.xml", "Enemy", 0);
        System.out.println("Loading Bosses");
        enemyList = Resources.ItemLoadClass.getNamesOfAllEnemiesInXML("EnemyList.xml", "Boss", enemyList.length);
        return enemyList;
    }

    int getEnemyhp() {
        return enemyhp;
    }

    void setEnemyhp(int enemyhp) {
        if (enemyhp < 0) {
            enemyhp = 0;
        }
        Enemies.enemyhp = enemyhp;
    }

    int getEnemymp() {
        return enemymp;
    }

    void setEnemymp(int enemymp) {
        if (enemymp < 0) {
            enemymp = 0;
        }
        Enemies.enemymp = enemymp;
    }

    int getEnemystrenght() {
        return enemystrenght;
    }

    void setEnemystrenght(int enemystrenght) {
        if (enemystrenght < 0) {
            enemystrenght = 0;
        }
        Enemies.enemystrenght = enemystrenght;
    }

    int getEnemydexterity() {
        return enemydexterity;
    }

    void setEnemydexterity(int enemydexterity) {
        Enemies.enemydexterity = enemydexterity;
    }

    int getEnemyvitality() {
        return enemyvitality;
    }

    void setEnemyvitality(int enemyvitality) {
        Enemies.enemyvitality = enemyvitality;
    }

    int getEnemyinteligence() {
        return enemyinteligence;
    }

    void setEnemyinteligence(int enemyinteligence) {
        Enemies.enemyinteligence = enemyinteligence;
    }

    int getEnemylevel() {
        return enemylevel;
    }

    void setEnemylevel(int enemylevel) {
        Enemies.enemylevel = enemylevel;
    }

    String getEnemyName() {
        return enemyName;
    }

    void setEnemyName(String enemyName) {
        Enemies.enemyName = enemyName;
    }

    int getBaseExp() {
        return baseExp;
    }

    void setBaseExp(int baseExp) {
        Enemies.baseExp = baseExp;
    }

}
