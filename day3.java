import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileNotFoundException;

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

    public static HashMap<Character, Integer> findSymbols(String line) {
        // Returns a mapping of the symbol character to the index at which the symbol was found in the line
        HashMap<Character, Integer> symbolMapping = new HashMap<Character, Integer>();

        for (int i = 0; i < line.length(); i++) {
            if (isSymbol(line.charAt(i))) {
                symbolMapping.put(line.charAt(i), i);
            }
        }

        // HashMap will be empty if nothing is found

        return symbolMapping;
    }

    public static ArrayList<ArrayList<Integer>> generateIndices(int lineCount, int symbolIndex, int totalLines) {
        // lineCount = X
        // symbolIndex = Y
        int totalFileLinesIndex = totalLines - 1;

        ArrayList<ArrayList<Integer>> pointsToCheck = new ArrayList<ArrayList<Integer>>();

        for (int i = lineCount - 1; i < lineCount + 2; i++) {
            for (int j = symbolIndex - 1; j < symbolIndex + 2; j++) {
                ArrayList<Integer> currentPair = new ArrayList<Integer>();

                if (i < 0 || i > totalFileLinesIndex) {
                    continue;
                } // If the X index is out of range

                if (j < 0 || j > totalFileLinesIndex) {
                    continue;
                } // If the Y index is out of range

                if (i == lineCount && j == symbolIndex) {
                    continue;
                } // If the point is the point where the symbol is

                currentPair.add(i);
                currentPair.add(j);
                pointsToCheck.add(currentPair);
            }
        }

        return pointsToCheck;
    }

    public static int getLineCount(String path) throws FileNotFoundException {
        File inputFile = new File(path);
        Scanner scanner = new Scanner(inputFile);

        int totalLines = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            totalLines++;
        }

        scanner.close();

        return totalLines;
    }

    public static int runPartOne() throws FileNotFoundException {
        File inputFile = new File("day3-sample.txt");
        Scanner scanner = new Scanner(inputFile);
        int totalFileLines = getLineCount("day3-sample.txt");

        int lineCounter = 0;
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            System.out.println(currentLine);

            HashMap<Character, Integer> symbolMapping = findSymbols(currentLine);
            
            for (char key: symbolMapping.keySet()) {
                ArrayList<ArrayList<Integer>> generatedIndices = generateIndices(lineCounter, symbolMapping.get(key), totalFileLines);
                System.out.println(String.format("Symbol: %c | X: %d | Y: %d", key, lineCounter, symbolMapping.get(key)));
                System.out.println("Generated Indices: ");
                System.out.println(generatedIndices);
            }

            // Algorithm plan:
            // Loop over every line
            // Loop over every character
            // Check if you have found a symbol
            // If a symbol was found, check the 9 x 9 area around the sybol for digits
            // If a digit is found, walk left from the digits index and walk right from the digits index until you have the entire number
            // Add the number to a sum
            // return the sum 
            lineCounter++;
        }
        scanner.close();

        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        runPartOne();
    }
}
