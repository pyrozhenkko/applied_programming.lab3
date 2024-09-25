package battle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BattleToFile {
    private static String logFilename = "battle_log.txt";

    public static void logToFile(String data) {
        if (true) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilename, true))) {
                writer.write(data);
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        }
    }
}
