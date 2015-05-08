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

    private int hp = 0;
    private int mp = 0;
    private int strenght = 0;
    private int dexterity = 0;
    private int vitality = 0;
    private int inteligence = 0;
    private int level = 0;
    private String name = null;
    private int baseExp = 0;
    private String[] enemyLoadStats = new String[]{"Name", "STR", "DEX", "VIT", "INT", "EXP"};

    public Enemy(int enemy) {

        name = Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[0]);
        strenght = Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[1]));
        dexterity = Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[2]));
        vitality = Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[3]));
        inteligence = Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[4]));
        baseExp = Integer.valueOf(Resources.ItemLoadClass.jarLoadEnemyFromXML("EnemyList.xml", Integer.toString(enemy), enemyLoadStats[5]));
        hp = (vitality * 10);
        mp = (inteligence * 10);

    }

    public Enemy() {
        int enemy = (int) Metods.Utilities.randomNumber(1, Resources.ItemLoadClass.getNumberOfEnemiesinXML("EnemyList.xml"), true);
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
        this.hp = hp;
    }

    int getMp() {
        return mp;
    }

    void setMp(int mp) {
        if (mp < 0) {
            mp = 0;
        }
        this.mp = mp;
    }

    int getStrenght() {
        return strenght;
    }

    void setStrenght(int strenght) {
        if (strenght < 0) {
            strenght = 0;
        }
        this.strenght = strenght;
    }

    int getDexterity() {
        return dexterity;
    }

    void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    int getVitality() {
        return vitality;
    }

    void setVitality(int vitality) {
        this.vitality = vitality;
    }

    int getInteligence() {
        return inteligence;
    }

    void setInteligence(int inteligence) {
        this.inteligence = inteligence;
    }

    int getLevel() {
        return level;
    }

    void setLevel(int level) {
        this.level = level;
    }

    String getName() {
        return name;
    }

    void setName(String Name) {
        this.name = Name;
    }

    int getBaseExp() {
        return baseExp;
    }

    void setBaseExp(int baseExp) {
        this.baseExp = baseExp;
    }

}
