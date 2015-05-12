/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metods;

/**
 *
 * @author Petr
 */
public class Fight {

    public static void fightMain(String AttackType, Enemy enemy) {
        switch (AttackType.toLowerCase()) {
            case "light":
                lightAttack(enemy);
                break;
            case "medium":
                break;
            case "heavy":
                break;
        }

    }
    private static boolean hitChance(int chanceInPercentage){        
        boolean hit = false;
        if (Utilities.randomNumber(0, 100, false)>(100-chanceInPercentage)){
            hit = true;
        }
        return hit;
    }
    
    private static int lightAttack(Enemy enemy) {
        System.out.println("Light attack to: "+enemy.getName());
        int damage = 0;
        if (hitChance((Hero.getDexterity()+Hero.getItemDexterity()+100)-enemy.getDexterity())){
            damage = (int) (((Hero.getStrenght()+Hero.getItemStrenght())*0.75+Hero.getItemDamage())*0.5);
        }
        System.out.println("for: "+ damage);
        return damage;
    }

}
