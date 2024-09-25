package droids;

public abstract class Droid {
    protected String name;
    protected double health;
    protected double damage;

    public Droid(String name, double health, double damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public abstract void setName(String name);
    public abstract void setHealth( double health);
    public abstract void setDamage(double damage);
    public abstract String getName();
    public abstract double getHealth();
    public abstract double getDamage();
    public abstract void attack(Droid enemy);
    public abstract void show();
}