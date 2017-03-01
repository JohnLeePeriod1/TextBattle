import java.util.Scanner;
public class Battle{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        String charName = "";
        int charChoice = 0;
        int turnCount = 0;
        int roundCount = 1;
        String[] blank = new String[0];
        Hero bueno = new Hero("", 0, 0, 0, blank);
        Player mal = new Player("", 0, 0, 0);
        System.out.print("Choose a name for your character: ");
        charName = console.nextLine();
        System.out.print("Choose a class for your character(1 for warrior; 2 for rogue; 3 for mage): ");
        charChoice = console.nextInt(); 
        while (charChoice > 3 || charChoice < 1){
            System.out.println("Please enter a valid int value");
            System.out.print("Choose a class for your character(1 for warrior; 2 for rogue; 3 for mage): ");
            charChoice = console.nextInt(); 
            System.out.println();
        }
        if (charChoice == 1){
            String[] warriorInventory = {"Damage potion", "empty", "Health potion"};
            bueno = new Warrior(charName, warriorInventory);
        }
        else if (charChoice ==2){
            String[] rogueInventory = {"Damage potion", "empty", "Damage potion"};
            bueno = new Rogue(charName, rogueInventory);
        }
        else if (charChoice ==3){
            String[] mageInventory = {"Mana potion", "empty", "Health potion"};
            bueno = new Mage(charName, mageInventory);
        }
        
        int monsterType = (int) (Math.random() * 3 + 1);
        if (monsterType == 1){
            String monsterType1 = "mom";
            mal = new Player(monsterType1, 200, 10, 5);
            System.out.println(charName + " has encountered a " + monsterType1);
            System.out.println();
        }
        else if (monsterType == 2){
            String monsterType2 = "dad";
            mal = new Player(monsterType2, 120, 25, 15);
            System.out.println(charName + " has encountered a " + monsterType2);
            System.out.println();
        }
        else if (monsterType == 3){
            String monsterType3 = "sisters";
            mal = new Player(monsterType3, 80, 80, 50);
            System.out.println(charName + " has encountered " + monsterType3);
            System.out.println();
        }
        do {
            if (turnCount % 2 == 0)
                System.out.println("++++++++++++++++++++++++++++++++++++ ROUND " + roundCount + " ++++++++++++++++++++++++++++++++++++");
            bueno.show_inventory();
            System.out.print("Type an inventory slot number or 0 to attack: ");
            int decision = console.nextInt();
            while (decision > 3 || decision < 0) {
                System.out.println("Please enter a valid value");
                System.out.print("Type an inventory slot number or 0 to attack: ");
                decision = console.nextInt();
           }
           System.out.println();
           if (decision == 1){
                bueno.useItem(1);
                turnCount++;
           }
           else if (decision ==2){
                bueno.useItem(2);
                turnCount++;
           }
           else if (decision == 3){
                bueno.useItem(3);
                turnCount++;
           }
           else if (decision == 0){
                bueno.attack(mal);
                turnCount++;
           }
           if(mal.getHealth() == 0)
               System.out.println(bueno.getName() + " has defeated " + mal.getName());
           if (mal.getHealth() > 0)
               mal.attack(bueno);
           if (bueno.getHealth() == 0)
               System.out.println(mal.getName() + " has defeated " + bueno.getName());
           turnCount++;
           roundCount++;
           System.out.println();
        } while (mal.getHealth() != 0 && bueno.getHealth() != 0);
    }
}
            
