package droids;

import battle.BattleToFile;

public class RegenerationDroid extends Droid {
    private double regenRate;

    public RegenerationDroid(String name, double health, double damage, double regenRate) {
        super(name, health, damage);
        this.regenRate = regenRate;
    }

    public void show() {
        System.out.println("Regeneration Droid:");
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damage);
        System.out.println("Regeneration Rate: " + regenRate + " per turn\n");
    }
    public void attack(Droid enemy) {
        enemy.setHealth(enemy.getHealth() - this.getDamage());
        if(enemy.getHealth() < 0){
            enemy.setHealth(0);
        }

        this.health += regenRate;

        System.out.print(this.getName() + " attacks " + enemy.getName()  + "and regen " + regenRate + " health | ");
        System.out.print(enemy.getName() + "`s" + " remaining health: " + enemy.getHealth() + " | ");
        System.out.println(this.getName() + " current health: " + this.getHealth());
        BattleToFile.logToFile(this.getName() + " attacks " + enemy.getName()  + "and regen " + regenRate + " health | ");
        BattleToFile.logToFile(enemy.getName() + "`s" + " remaining health: " + enemy.getHealth() + " | ");
        BattleToFile.logToFile(this.getName() + " current health: " + this.getHealth());
    }
}
