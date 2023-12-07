import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class day4 {
    public static void main(String args[]) throws FileNotFoundException {
        runPartOne();
    }

    public static int runPartOne() throws FileNotFoundException {
        File inputFile = new File("day4-sample.txt");
        Scanner scanner = new Scanner(inputFile);

        int totalPoints = 0;
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine().trim();
            System.out.println(currentLine);
        }
        scanner.close();

        return totalPoints;
    }
}

class lineAnalyzer {
    private String raw;

    public lineAnalyzer(String line) {
        this.raw = line;
    }

    public String getRaw() {
        return this.raw;
    }
}