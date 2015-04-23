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
 * @author Petr
 */
public class Hospital {

    void steroid() {
        System.out.println("Work in progress");
    }

    void regenHealth() {
        Inputs input = new Inputs();
        int maxHp = (HeroStats.getVitality() + HeroStats.getItemVitality()) * 10;
        int healingPrice = (int) (10 * Utilities.getDifficulty());
        if (HeroStats.getHp() < maxHp) {
            System.out.println("Heal: " + (maxHp - HeroStats.getHp()) + " for " + ((maxHp - HeroStats.getHp()) * healingPrice) + " money ? [Yes/No]");
            String userInput = input.input();
            if (userInput.equals("Yes") && HeroStats.getMoney() > ((maxHp - HeroStats.getHp()) * healingPrice)) {
                HeroStats.setMoney((maxHp - HeroStats.getHp()) * healingPrice);
                HeroStats.setHp(maxHp);
            } else if (HeroStats.getMoney() < ((maxHp - HeroStats.getHp()) * healingPrice) && userInput.equals("Yes")) {
                System.out.println("You don't have enough money");
            }
        } else {
            System.out.println("You already have full Hp");
        }
    }

    void regenMana() {
        Inputs input = new Inputs();
        int maxMp = (HeroStats.getInteligence() + HeroStats.getItemInteligence()) * 10;
        int regenPrice = (int) (10 * Utilities.getDifficulty());
        if (HeroStats.getMp() < maxMp) {
            System.out.println("Heal: " + (maxMp - HeroStats.getMp()) + " for " + ((maxMp - HeroStats.getMp()) * regenPrice) + " ? [Yes/No]");
            String userInput = input.input();
            if (userInput.equals("Yes") && HeroStats.getMoney() > ((maxMp - HeroStats.getMp()) * regenPrice)) {
                HeroStats.setMoney((maxMp - HeroStats.getMp()) * regenPrice);
                HeroStats.setMp(maxMp);
            } else if (HeroStats.getMoney() < ((maxMp - HeroStats.getMp()) * regenPrice) && userInput.equals("Yes")) {
                System.out.println("You don't have enough money");
            }
        } else {
            System.out.println("You already have full Mp");
        }
    }
}
