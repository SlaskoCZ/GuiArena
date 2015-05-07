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
public class Enemy {

    private static int hp = 0;
    private static int mp = 0;
    private static int strenght = 0;
    private static int dexterity = 0;
    private static int vitality = 0;
    private static int inteligence = 0;
    private static int level = 0;
    private static String Name = null;
    private static int baseExp = 0;
    private static String[] enemyLoadStats = new String[]{"Name", "STR", "DEX", "VIT", "INT", "EXP"};

    public Enemy(int enemy) {
        
        this.setName(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[0]));
        this.setStrenght(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[1])));
        this.setDexterity(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[2])));
        this.setVitality(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[3])));
        this.setInteligence(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[4])));
        this.setBaseExp(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[5])));
        this.setHp(getVitality()*10);
        this.setMp(getInteligence()*10);

    }

    public Enemy() {
        int enemy = (int)Metods.Utilities.randomNumber(1, Resources.ItemLoadClass.getNumberOfEnemiesinXML("EnemyList.xml"), true);
        this.setName(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[0]));
        this.setStrenght(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[1])));
        this.setDexterity(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[2])));
        this.setVitality(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[3])));
        this.setInteligence(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[4])));
        this.setBaseExp(Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[5])));
    }

    public static String[] getEnemyList() {
        System.out.println("Loading Enemies");
        String[] enemyList = Resources.ItemLoadClass.getNamesOfAllEnemiesInXML("EnemyList.xml", "Enemy", 0);
        System.out.println("Loading Bosses");
        enemyList = Resources.ItemLoadClass.getNamesOfAllEnemiesInXML("EnemyList.xml", "Boss", enemyList.length);
        return enemyList;
    }

    int getHp() {
        return hp;
    }

    void setHp(int hp) {
        if (hp < 0) {
            hp = 0;
        }
        Enemy.hp = hp;
    }

    int getMp() {
        return mp;
    }

    void setMp(int mp) {
        if (mp < 0) {
            mp = 0;
        }
        Enemy.mp = mp;
    }

    int getStrenght() {
        return strenght;
    }

    void setStrenght(int strenght) {
        if (strenght < 0) {
            strenght = 0;
        }
        Enemy.strenght = strenght;
    }

    int getDexterity() {
        return dexterity;
    }

    void setDexterity(int dexterity) {
        Enemy.dexterity = dexterity;
    }

    int getVitality() {
        return vitality;
    }

    void setVitality(int vitality) {
        Enemy.vitality = vitality;
    }

    int getInteligence() {
        return inteligence;
    }

    void setInteligence(int inteligence) {
        Enemy.inteligence = inteligence;
    }

    int getLevel() {
        return level;
    }

    void setLevel(int level) {
        Enemy.level = level;
    }

    String getName() {
        return Name;
    }

    void setName(String Name) {
        Enemy.Name = Name;
    }

    int getBaseExp() {
        return baseExp;
    }

    void setBaseExp(int baseExp) {
        Enemy.baseExp = baseExp;
    }

}
