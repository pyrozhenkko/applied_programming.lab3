package battle;
import main.Main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReadFile {
    private final String fileName;

    public ReadFile(String fileName) {
        this.fileName = fileName;
    }
    public void readFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        Main.main(null);
    }
    public static void reading() {
        String fileName = "battle_log.txt";
        ReadFile fileReader = new ReadFile(fileName);

        try {
            fileReader.readFile();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }


}
