package droids;

import battle.BattleToFile;

public class CasualDroid extends Droid {

    public CasualDroid(String name, double health, double damage) {
        super(name, health, damage);
    }

    public void show(){
        System.out.println("Casual Droid:");
        System.out.println("Name: "+name);
        System.out.println("Health: "+health);
        System.out.println("Damage: "+damage + "\n");
    }
    public void attack(Droid enemy) {
        enemy.setHealth(enemy.getHealth() - this.getDamage());
        if(enemy.getHealth() < 0){
            enemy.setHealth(0);
        }
        System.out.print(this.getName() + " attacks " + enemy.getName()  + " | ");
        System.out.print(enemy.getName() + "`s" + " remaining health: " + enemy.getHealth() + " | ");
        System.out.println(this.getName() + " current health: " + this.getHealth());
        BattleToFile.logToFile(this.getName() + " attacks " + enemy.getName()  + " | ");
        BattleToFile.logToFile(enemy.getName() + "`s" + " remaining health: " + enemy.getHealth() + " | ");
        BattleToFile.logToFile(this.getName() + " current health: " + this.getHealth());
    }

}
