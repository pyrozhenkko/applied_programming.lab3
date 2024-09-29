package droids;

import battle.BattleToFile;

public class LifestealerDroid extends Droid {
    private double lifestealPercentage = 0.3;

    public LifestealerDroid(String name, double health, double damage, double lifestealPercentage) {
        super(name, health, damage);
        this.lifestealPercentage = lifestealPercentage;
    }

    public void show() {
        System.out.println("Lifestealer Droid:");
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damage);
        System.out.println("Lifesteal Percentage: " + lifestealPercentage * 100 + "%\n");
    }
    public void attack(Droid enemy) {
        enemy.setHealth(enemy.getHealth() - this.getDamage());

        double lifestealAmount = this.getDamage() * lifestealPercentage;
        this.setHealth(this.getHealth() + lifestealAmount);

        if (this.getHealth() > 100) {
            this.setHealth(100);
        }

        System.out.print(this.getName() + " attacks " + enemy.getName() + " and steals " + lifestealAmount + " health! | ");
        System.out.print(enemy.getName() + "`s" + " remaining health: " + enemy.getHealth() + " | ");
        System.out.println(this.getName() + " current health: " + this.getHealth());
        BattleToFile.logToFile(this.getName() + " attacks " + enemy.getName() + " and steals " + lifestealAmount + " health! | ");
        BattleToFile.logToFile(enemy.getName() + "`s" + " remaining health: " + enemy.getHealth() + " | ");
        BattleToFile.logToFile(this.getName() + " current health: " + this.getHealth());
    }
}
