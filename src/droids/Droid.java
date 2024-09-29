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

    public  void setName(String name){
        this.name = name;
    }
    public  void setHealth( double health){
        this.health = health;
    }
    public  void setDamage(double damage){
        this.damage = damage;
    }
    public  String getName(){
        return name;
    }
    public  double getHealth(){
        return health;
    }
    public  double getDamage(){
        return damage;
    }
    public abstract void attack(Droid enemy);
    public abstract void show();
}