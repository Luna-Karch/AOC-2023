import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class day4 {
    public static void main(String args[]) throws FileNotFoundException {
        System.out.println(String.format("Part One: %d", runPartOne()));
        runPartTwo();
    }

    public static int runPartTwo() throws FileNotFoundException {
        File inputFile = new File("day4-sample.txt");
        Scanner scanner = new Scanner(inputFile);

        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine().trim();
            lineAnalyzerPartTwo analyzer = new lineAnalyzerPartTwo(currentLine);
            int gameNumber = analyzer.getGameNumber();
            int winningNumberCount = analyzer.getWinningNumberCount();
            System.out.println(String.format("Game #%d: %d", gameNumber, winningNumberCount));
        }
        scanner.close();

        return 0;
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

class lineAnalyzerPartTwo {
    private String raw;
    private int gameNumber;
    private int winningNumberCount;
    
    public lineAnalyzerPartTwo(String line) {
        this.raw = line;
        this.gameNumber = this.findGameNumber();
        this.winningNumberCount = findWinningNumberCount();
    }

    public int getWinningNumberCount() {
        return this.winningNumberCount;
    }

    private int findWinningNumberCount() {
        ArrayList<Integer> yourNumbers = new ArrayList<>();
        for (String number: this.raw.split("\\|")[1].trim().split("\\s+")) {
            yourNumbers.add(Integer.parseInt(number));
        }

        ArrayList<Integer> winningNumbers = new ArrayList<>();
        for (String number: this.raw.split(": ")[1].split("\\|")[0].trim().split("\\s+")) {
            winningNumbers.add(Integer.parseInt(number));
        }

        int totalWinningNumbers = 0;

        for (int number: yourNumbers) {
            if (winningNumbers.contains(number)) {
                totalWinningNumbers++;
            }
        }

        return totalWinningNumbers;
    }

    public int getGameNumber() {
        return this.gameNumber;
    }

    private int findGameNumber() {
        return Integer.parseInt(this.raw.split(": ")[0].split("\\s+")[1]);
    }
}