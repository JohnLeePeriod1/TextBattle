public class Player{
    protected String name;
    protected int health;
    protected int minDamage;
    protected int maxDamage;
    public Player(String inputName, int hP, int minD, int maxD){
        name = inputName;
        health = hP;
        minDamage = minD;
        maxDamage = maxD;
    }
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public int getMinDamage(){
        return minDamage;
    }
    public int getMaxDamage(){
        return maxDamage;
    }
    public void setName(String newName){
        name = newName;
    }
    public void setHealth(int newHP){
        health = newHP;
    }
    public void setMinDamage(int newMinD){
        minDamage = newMinD;
    }
    public void setMaxDamage(int newMaxD){
        maxDamage = newMaxD;
    }
    public void receiveDamage(int damage){
        if (health - damage >=0){
            health = health - damage;
            System.out.println(name + "has " + health + "health left.");
        }
        else 
            System.out.println(name + "is dead.");
    }
    public void attack(Player enemy){
        int hitDamage = (int) (Math.random() * (maxDamage+1) + minDamage);
        enemy.setHealth(enemy.getHealth() - hitDamage);
        if (enemy.getHealth() <= 0)
            enemy.setHealth(0);
        System.out.println(this.name + " attacks " + enemy.getName() + " doing " + hitDamage + " damage.");
        System.out.println(enemy.getName() + " has " + enemy.getHealth() + " health left.");
        System.out.println();
    }
}
        
