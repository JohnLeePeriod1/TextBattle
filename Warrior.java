public class Warrior extends Hero{
    protected double critChance;
    public Warrior(String name, String[] input){
        super(name, 100, 20, 10, input);
        critChance = 0.5;
    }
    public void attack(Player enemy){
        int hitDamage = (int) ((Math.random() * (maxDamage+1)) + minDamage);
        if (critChance > Math.random()){
            hitDamage = hitDamage * 2;
            System.out.println(name + " gets a critical hit!");
        }
        enemy.setHealth(enemy.getHealth() - hitDamage);
        System.out.println(this.name + " attacks the " + enemy.getName() + " doing " + hitDamage + " damage.");
        if (enemy.getHealth() <= 0)
            enemy.setHealth(0);
        System.out.println(enemy.getName() + " has " + enemy.getHealth() + " health left.");
        System.out.println();
    }
}
        
    
