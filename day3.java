import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day3 {

    public static boolean isSymbol(char character) {
        /* Returns false if the character is a period
         * or if the character is a digit
         * otherwise, the character is a symbol, so return true */

        if (character == '.') {
            return false; 
        }

        if (Character.isDigit(character)) {
            return false;
        }

        return true;
    }

    public static boolean lineHasSymbol(String line) {
        // Iterates through a line and determines if any symbols are present

        boolean symbolFound = false;
        for (int i = 0; i < line.length(); i++) {
            if (isSymbol(line.charAt(i))) {
                symbolFound = true;
            }
        }
        return symbolFound;

    }

    public static int runPartOne() throws FileNotFoundException {
        File inputFile = new File("day3-sample.txt");
        Scanner scanner = new Scanner(inputFile);

        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            System.out.println(currentLine);
        }
        scanner.close();

        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        runPartOne();
    }
}
