/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metods;

import Arena.Messages.CustomMessage;
import javax.swing.JFrame;

/**
 *
 * @author Petr
 */
public class Fight {

    public static void fightMain(JFrame parent, String AttackType, Enemy enemy) {
        switch (AttackType.toLowerCase()) {
            case "light":
                lightAttack(enemy);
                break;
            case "medium":
                mediumAttack(enemy);
                break;
            case "heavy":
                heavyAttack(enemy);
                break;
        }
        if (!enemy.isAlive()) {
            Arena.MainClass.enemyKilled(enemy.id);
            CustomMessage cm = new CustomMessage(parent, true, "Enemy Dead", enemy.getName()+ " died. You got "+enemy.getBaseExp()+" EXP and "+ enemy.getMoney()+" money");
            cm.setVisible(true);

        } else {
            System.out.println("Hp left: " + enemy.getHp());
        }
        if (Arena.MainClass.getEnemyNumber() == 0) {
            Arena.MainClass.backToMainScreen();
        }
    }

    private static boolean hitChance(int chanceInPercentage) {
        if (Utilities.randomNumber(0, 100, false) > (100 - chanceInPercentage)) {
            return true;
        } else {
            return false;
        }
        
    }

    private static void lightAttack(Enemy enemy) {
        System.out.print("Light attack to: " + enemy.getName());
        int damage = 0;
        if (hitChance((Hero.getDexterity() + Hero.getItemDexterity() + 100) - enemy.getDexterity())) {
            damage = (int) (((Hero.getStrenght() + Hero.getItemStrenght()) * 0.75 + Hero.getItemDamage()) * 0.5);
        }
        System.out.println(" for: " + damage);
        enemy.setHp(enemy.getHp() - damage);
    }

    private static void mediumAttack(Enemy enemy) {
        System.out.print("Medium attack to: " + enemy.getName());
        int damage = 0;
        if (hitChance((Hero.getDexterity() + Hero.getItemDexterity() + 50) - enemy.getDexterity())) {
            damage = (int) (((Hero.getStrenght() + Hero.getItemStrenght()) * 0.75 + Hero.getItemDamage()) * 1);
        }
        System.out.println(" for: " + damage);
        enemy.setHp(enemy.getHp() - damage);
    }

    private static void heavyAttack(Enemy enemy) {
        System.out.print("Heavy attack to: " + enemy.getName());
        int damage = 0;
        if (hitChance((Hero.getDexterity() + Hero.getItemDexterity() + 25) - enemy.getDexterity())) {
            damage = (int) (((Hero.getStrenght() + Hero.getItemStrenght()) * 0.75 + Hero.getItemDamage()) * 2);
        }
        System.out.println(" for: " + damage);
        enemy.setHp(enemy.getHp() - damage);
    }

}
