public class Rogue extends Hero{
    protected double secondAttackChance;
    public Rogue(String name, String[] input){
        super(name, 80, 36, 26, input);
        this.secondAttackChance = 0.3;
    }
    public void attack(Player enemy){
        int hitDamage = (int) ((Math.random() * (maxDamage+1)) + minDamage);
        enemy.setHealth(enemy.getHealth() - hitDamage);
        if (enemy.getHealth() <= 0)
            enemy.setHealth(0);
        System.out.println(this.name + " attacks the " + enemy.getName() + " doing " + hitDamage + " damage.");
        System.out.println(enemy.getName() + " has " + enemy.getHealth() + " health left.");
        if (secondAttackChance > Math.random()){
            System.out.println();
            System.out.println(name + " gets a double attack!");
            int secondHitDamage = (int) ((Math.random() * (maxDamage+1)) + minDamage);
            enemy.setHealth(enemy.getHealth() - hitDamage);
            if (enemy.getHealth() <= 0)
                enemy.setHealth(0);
            System.out.println(this.name + " attacks the " + enemy.getName() + " doing " + hitDamage + " damage.");
            System.out.println(enemy.getName() + " has " + enemy.getHealth() + " health left.");
        }
        System.out.println();
    }
}
    
