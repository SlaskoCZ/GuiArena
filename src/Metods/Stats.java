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
        HeroStats.reloadItemStats();
        String[] heroStats = new String[12];
        heroStats[0] = Integer.toString(HeroStats.getStrenght() + HeroStats.getItemStrenght())+" ("+HeroStats.getItemStrenght()+")";
        heroStats[1] = Integer.toString(HeroStats.getInteligence() + HeroStats.getItemInteligence())+" ("+HeroStats.getItemInteligence()+")";
        heroStats[2] = Integer.toString(HeroStats.getVitality() + HeroStats.getItemVitality())+" ("+HeroStats.getItemVitality()+")";
        heroStats[3] = Integer.toString(HeroStats.getDexterity() + HeroStats.getItemDexterity())+" ("+HeroStats.getItemDexterity()+")";
        heroStats[4] = Integer.toString(HeroStats.getHp()) + " / " + Integer.toString(HeroStats.getItemVitality() + HeroStats.getVitality() * 10);
        heroStats[5] = Integer.toString(HeroStats.getMp()) + " / " + Integer.toString(HeroStats.getItemInteligence()+ HeroStats.getInteligence()* 10);
        heroStats[6] = Integer.toString(HeroStats.getMoney());
        heroStats[7] = Integer.toString(HeroStats.getLevel());
        heroStats[8] = Integer.toString(HeroStats.getExperiance());
        if (HeroStats.getCharacterInventory()[1][1] == "0") {
            heroStats[9] = "Right Hand";
        } else {
            heroStats[9] = HeroStats.getCharacterInventory()[1][0];
        }
        if (HeroStats.getCharacterInventory()[2][1] == "0") {
            heroStats[10] = "Left Hand";
        } else {
            heroStats[10] = HeroStats.getCharacterInventory()[2][0];
        }
        if (HeroStats.getCharacterInventory()[3][1] == "0") {
            heroStats[11] = "Hairy chest";
        } else {
            heroStats[11] = HeroStats.getCharacterInventory()[3][0];
        }

        return heroStats;

    }

    public String[] enemy(int enemyNumber) {
        String[] enemyStats = new String[7];
        enemyStats[0] = (Arena.MainClass.enemy[enemyNumber].getEnemyName());
        enemyStats[1] = Integer.toString(Arena.MainClass.enemy[enemyNumber].getEnemystrenght());
        enemyStats[2] = Integer.toString(Arena.MainClass.enemy[enemyNumber].getEnemydexterity());
        enemyStats[3] = Integer.toString(Arena.MainClass.enemy[enemyNumber].getEnemyvitality());
        enemyStats[4] = Integer.toString(Arena.MainClass.enemy[enemyNumber].getEnemyinteligence());
        enemyStats[5] = Integer.toString(Arena.MainClass.enemy[enemyNumber].getEnemyhp());
        enemyStats[6] = Integer.toString(Arena.MainClass.enemy[enemyNumber].getEnemymp());
        return enemyStats;

    }
}
