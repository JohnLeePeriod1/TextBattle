public class Hero extends Player{
    protected String[] inventory;
    public Hero(String name, int health, int minDamage, int maxDamage, String[] input){
        super(name, health, minDamage, maxDamage);
        this.inventory = input;
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
                maxDamage = maxDamage + 10;
                System.out.println(name + " can do more damage.");
                inventory[choice-1] = "empty";
            }
            else {
                System.out.println("That inventory slot is empty!");
            }
        }
        else
            System.out.println("Inventory slot nonexistent. Please enter a valid inventory slot.");
        System.out.println();
        }    
    public void show_inventory(){
        System.out.println("Your inventory holds: 1. " + inventory[0] + "; 2. " + inventory[1] + "; 3. " + inventory[2] + ";");
    }
}
        
