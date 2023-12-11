import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class day4 {
    public static void main(String args[]) throws FileNotFoundException {
        System.out.println(String.format("Part One: %d", runPartOne()));
    }

    public static int runPartOne() throws FileNotFoundException {
        File inputFile = new File("day4-actual.txt");
        Scanner scanner = new Scanner(inputFile);

        int totalPoints = 0;
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine().trim();
            lineAnalyzerPartOne analyzer = new lineAnalyzerPartOne(currentLine);
            ArrayList<Integer> yourWinningNumbers = analyzer.calculateYourWinningNumbers();

            if (yourWinningNumbers.size() == 0) {
                continue;
            }

            totalPoints += Math.pow(2, yourWinningNumbers.size() - 1);
        }
        scanner.close();

        return totalPoints;
    }
}

class lineAnalyzerPartOne {
    private String raw;
    private int gameNumber;
    private ArrayList<Integer> winningNumbers;
    private ArrayList<Integer> yourNumbers;

    public lineAnalyzerPartOne(String line) {
        this.raw = line;

        this.winningNumbers = this.findWinningNumbers();
        this.yourNumbers = this.findYourNumbers();
        this.gameNumber = this.findGameNumber();
    }

    public String getRaw() {
        return this.raw;
    }

    public int getGameNumber() {
        return this.gameNumber;
    }

    public ArrayList<Integer> getYourNumbers() {
        return this.yourNumbers;
    }

    public ArrayList<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public ArrayList<Integer> calculateYourWinningNumbers() {
        ArrayList<Integer> yourWinningNumbers = new ArrayList<Integer>();

        for (int yourNumber: this.yourNumbers) {
            if (this.winningNumbers.contains(yourNumber)) {
                yourWinningNumbers.add(yourNumber);
            }
        }

        return yourWinningNumbers;
    }

    private int findGameNumber() {
        return Integer.parseInt(this.raw.split(": ")[0].split("\\s+")[1]);
    }

    private ArrayList<Integer> findYourNumbers() {
        ArrayList<Integer> yourNumbers = new ArrayList<Integer>();

        for (String number: this.raw.split(": ")[1].split("[|]")[1].trim().split("\\s+")) {
            yourNumbers.add(Integer.parseInt(number));
        }

        return yourNumbers;
    }

    private ArrayList<Integer> findWinningNumbers() {
        ArrayList<Integer> winningNumbers = new ArrayList<Integer>();
        
        for (String number: this.raw.split(": ")[1].split("[|]")[0].trim().split("\\s+")) {
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }
}