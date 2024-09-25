package battle;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import droids.Droid;
import main.Main;

public class BattleTeamVsTeam {

    public static void Battle(List<Droid> droids) {
        if(droids.isEmpty()) {
            System.out.println("There is no droid");
            Main.menuPanel(droids);
        }
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        if (droids.isEmpty()) {
            System.out.println("No droids found");
            return;
        }

        System.out.println("Available droids:");
        for (int i = 0; i < droids.size(); i++) {
            System.out.println((i + 1) + ". " + droids.get(i).getName());
        }

        System.out.println("Choose droids for Team 1 (enter numbers separated by space):");
        List<Droid> team1 = chooseDroids(droids, scan);

        System.out.println("Choose droids for Team 2 (enter numbers separated by space):");
        List<Droid> team2 = chooseDroids(droids, scan);

        if (team1.isEmpty() || team2.isEmpty()) {
            System.out.println("Both teams must have at least one droid.");
            return;
        }

        if (!isTeamsValid(team1, team2)) {
            System.out.println("You cannot have the same droid in both teams.");
            return;
        }

        System.out.println("Starting battle between Team 1 and Team 2!");
        BattleToFile.logToFile("Starting battle between Team 1 and Team 2");

        int round = 1;
        while (!team1.isEmpty() && !team2.isEmpty()) {
            System.out.println("\n");
            System.out.println("Round " + round);
            BattleToFile.logToFile("\nRound " + round);

            teamAttack(team1, team2, random);

            if (team2.isEmpty()) {
                System.out.println("Team 1 wins!");
                BattleToFile.logToFile("Team 1 wins!");
                break;
            }

            teamAttack(team2, team1, random);

            if (team1.isEmpty()) {
                System.out.println("Team 2 wins!");
                BattleToFile.logToFile("Team 2 wins!");
                break;
            }

            round++;
        }
    }
    private static List<Droid> chooseDroids(List<Droid> availableDroids, Scanner scan) {
        String[] input = scan.nextLine().split(" ");
        List<Droid> team = new ArrayList<>();

        try {
            for (String s : input) {
                int index = Integer.parseInt(s) - 1;
                team.add(availableDroids.get(index));
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
        return team;
    }
    private static boolean isTeamsValid(List<Droid> team1, List<Droid> team2) {
        for (Droid droid : team1) {
            if (team2.contains(droid)) {
                return false;
            }
        }
        return true;
    }
    private static void teamAttack(List<Droid> attackingTeam, List<Droid> defendingTeam, Random random) {
        for (Droid attacker : attackingTeam) {
            if (defendingTeam.isEmpty()) break;

            Droid defender = defendingTeam.get(random.nextInt(defendingTeam.size()));
            attacker.attack(defender);

            if (defender.getHealth() <= 0) {
                defender.setHealth(0);
                System.out.println("Droid " + defender.getName() + " is dead!");
                defendingTeam.remove(defender);
            }
        }
    }
}
