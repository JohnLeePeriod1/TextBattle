public class Mage extends Hero{
    protected int mana;
    public Mage(String name, String[] inventory){
        super(name, 60, 40, 32, inventory);
        this.mana = 40;
    }
    public void attack(Player enemy){
        if (this.mana < 8)
            System.out.println("Not enough mana!");
        else if (this.mana > 8){
            int hitDamage = (int) ((Math.random() * (maxDamage+1)) + minDamage);
            enemy.setHealth(enemy.getHealth() - hitDamage);
            this.mana = this.mana - 8;
            if (enemy.getHealth() <= 0)
                enemy.setHealth(0);
            System.out.println(this.name + " has " + this.mana + " mana left.");
            System.out.println(this.name + " attacks the " + enemy.getName() + " doing " + hitDamage + " damage.");
            System.out.println(enemy.getName() + " has " + enemy.getHealth() + " health left.");
        }
        System.out.println();
    }
    public void useItem(int choice){
        if (choice > 0 && choice < 4){
            String item = inventory[choice-1];
            if (item.equals("Health potion")){
                health = health + 20;
                System.out.println(name + " now has " + health + "health.");
                inventory[choice-1] = "empty";
            }
            else if (item.equals("Damage potion")){
                maxDamage = 10;
                System.out.println(name + " can do more damage.");
                inventory[choice-1] = "empty";
            }
            else if (item.equals("Mana potion")){
                this.mana = this.mana + 30;
                System.out.println(name + " now has " + mana + " mana.");
                inventory[choice-1] = "empty";
            }
            else {
                System.out.println("That inventory slot is empty!");
            }
        }
        else
            System.out.println("Inventory slot nonexistent. Please enter a valid inventory slot.");
        
    }
}
    
