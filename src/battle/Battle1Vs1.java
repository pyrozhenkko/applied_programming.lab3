package battle;
import java.util.List;
import java.util.Scanner;
import droids.Droid;
import main.Main;

public class Battle1Vs1 {
    public static void Battle(List<Droid> droids) {
        if(droids.isEmpty()) {
            System.out.println("There is no droid");
            Main.menuPanel(droids);
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Available droids:");
        for( int i = 0; i < droids.size(); i++ ) {
            System.out.println((i + 1) + ". " + droids.get(i).getName());
        }
        System.out.println("Choose the first droid by number: ");
        int droid1Index = scan.nextInt() - 1;
        Droid droid1 = droids.get(droid1Index);

        System.out.println("Choose the second droid by number: ");
        int droid2Index = scan.nextInt() - 1;
        Droid droid2 = droids.get(droid2Index);
        if (droid1 == droid2) {
            System.out.println("You cannot choose the same droid for both teams.");
            return;
        }
        System.out.println("Starting battle between " + droid1.getName() + " and " + droid2.getName() + "!");
        BattleToFile.logToFile("Starting battle between " + droid1.getName() + " and " + droid2.getName() + "!");
        int round = 0;

        while (droid1.getHealth() > 0 && droid2.getHealth() > 0) {
            round++;
            System.out.println("Round " + round);
            BattleToFile.logToFile("Round " + round);
            droid1.attack(droid2);
            droid2.attack(droid1);
            if(droid1.getHealth() <= 0) {
                droid1.setHealth(0);
                System.out.println("Droid " + droid1.getName() + " is dead!");
                System.out.println(droid2.getName() + " is a winner!");
                BattleToFile.logToFile("Droid " + droid1.getName() + " is dead!");
                BattleToFile.logToFile(droid2.getName() + " is a winner!");
                break;
            }
            if(droid2.getHealth() <= 0) {
                droid2.setHealth(0);
                System.out.println("Droid " + droid2.getName() + " is dead!");
                System.out.println(droid1.getName() + " is a winner!");
                BattleToFile.logToFile("Droid " + droid2.getName() + " is dead!");
                BattleToFile.logToFile(droid1.getName() + " is a winner!");
                break;
            }
        }
    }
}
