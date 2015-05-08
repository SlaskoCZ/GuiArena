package Metods;

import Arena.MainClass;
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
public class Stats {

    public String[] hero() {
        Hero.reloadItemStats();
        String[] heroStats = new String[12];
        heroStats[0] = Integer.toString(Hero.getStrenght() + Hero.getItemStrenght())+" ("+Hero.getItemStrenght()+")";
        heroStats[1] = Integer.toString(Hero.getInteligence() + Hero.getItemInteligence())+" ("+Hero.getItemInteligence()+")";
        heroStats[2] = Integer.toString(Hero.getVitality() + Hero.getItemVitality())+" ("+Hero.getItemVitality()+")";
        heroStats[3] = Integer.toString(Hero.getDexterity() + Hero.getItemDexterity())+" ("+Hero.getItemDexterity()+")";
        heroStats[4] = Integer.toString(Hero.getHp()) + " / " + Integer.toString(Hero.getItemVitality() + Hero.getVitality() * 10);
        heroStats[5] = Integer.toString(Hero.getMp()) + " / " + Integer.toString(Hero.getItemInteligence()+ Hero.getInteligence()* 10);
        heroStats[6] = Integer.toString(Hero.getMoney());
        heroStats[7] = Integer.toString(Hero.getLevel());
        heroStats[8] = Integer.toString(Hero.getExperiance());
        if (Hero.getItemsOnHero()[1][1] == "0") {
            heroStats[9] = "Right Hand";
        } else {
            heroStats[9] = Hero.getItemsOnHero()[1][0];
        }
        if (Hero.getItemsOnHero()[2][1] == "0") {
            heroStats[10] = "Left Hand";
        } else {
            heroStats[10] = Hero.getItemsOnHero()[2][0];
        }
        if (Hero.getItemsOnHero()[3][1] == "0") {
            heroStats[11] = "Hairy chest";
        } else {
            heroStats[11] = Hero.getItemsOnHero()[3][0];
        }

        return heroStats;

    }

    public String[] enemy(int enemyNumber) {
        String[] enemyStats = new String[7];
        enemyStats[0] = (Arena.MainClass.enemy[enemyNumber].getName());
        enemyStats[1] = Integer.toString(Arena.MainClass.enemy[enemyNumber].getStrenght());
        enemyStats[2] = Integer.toString(Arena.MainClass.enemy[enemyNumber].getDexterity());
        enemyStats[3] = Integer.toString(Arena.MainClass.enemy[enemyNumber].getVitality());
        enemyStats[4] = Integer.toString(Arena.MainClass.enemy[enemyNumber].getInteligence());
        enemyStats[5] = Integer.toString(Arena.MainClass.enemy[enemyNumber].getHp());
        enemyStats[6] = Integer.toString(Arena.MainClass.enemy[enemyNumber].getMp());
        System.out.println("Stats for enemy: "+enemyNumber);
        return enemyStats;

    }
}
