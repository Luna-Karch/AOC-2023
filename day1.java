import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.Character;
import java.io.FileNotFoundException;

public class day1 {
    public static HashMap<String, String> numberMapping = new HashMap<String, String>() {{
        put("zero", "0");
        put("one", "1");
        put("two", "2");
        put("three", "3");
        put("four", "4");
        put("five", "5");
        put("six", "6");
        put("seven", "7");
        put("eight", "8");
        put("nine", "9");
        put("0", "0");
        put("1", "1");
        put("2", "2");
        put("3", "3");
        put("4", "4");
        put("5", "5");
        put("6", "6");
        put("7", "7");
        put("8", "8");
        put("9", "9");
    }};

    public static int runPartOne() throws FileNotFoundException {
        File inputFile = new File("day1-actual.txt");
        Scanner scanner = new Scanner(inputFile);

        char leftSide = ' ';
        char rightSide = ' ';

        int totalValue = 0;

        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();

            for (int i = 0; i < currentLine.length(); i++) {
                if (Character.isDigit(currentLine.charAt(i))) {
                    leftSide = currentLine.charAt(i); // Setting the left side of the number variable
                    break;
                }
            }

            for (int i = currentLine.length() - 1; i > -1; i--) {
                if (Character.isDigit(currentLine.charAt(i))) {
                    rightSide = currentLine.charAt(i); // Setting the right side of the number variable
                    break;
                }
            }

            String beforeResult = "" + leftSide + rightSide;
            totalValue += Integer.parseInt(beforeResult);

            leftSide = ' ';
            rightSide = ' '; 
            // ^^ Resetting the values on either side after going to the next line
        }
        scanner.close();

        return totalValue; 
        // ^^ Passes on sample text with value of 142
        // ^^ Passes on actual text with value of 53080
    }

    public static int runPartTwo() throws FileNotFoundException {
        File inputFile = new File("day1-sample-2.txt");
        Scanner scanner = new Scanner(inputFile);

        int totalValue = 0;

        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();    
            HashMap<String, Integer> lineStats = new HashMap<String, Integer>();

            numberMapping.forEach((key, value) -> {
                int numberIndex = currentLine.indexOf(key);
                
                if (numberIndex != -1) {
                    lineStats.put(key, numberIndex);
                    // ^^ If the word exists in the current line
                    // ^^ Add it to the temporary mapping
                }
            });

            // Walk forwards only this time
            // Add the numbers found to the lineStats map and take the smallest and largest
            // To find the first and last number

            for (int i = 0; i < currentLine.length(); i++) {
                if (Character.isDigit(currentLine.charAt(i))) {
                    lineStats.put(String.valueOf(currentLine.charAt(i)), i);
                }
            }

            String[] minmaxkeys = {"", ""};
            int[] minmaxnums = {-999999, 999999};

            lineStats.forEach((key, value) -> {
                if (value < minmaxnums[1]) {
                    minmaxnums[1] = value;
                    minmaxkeys[1] = key;
                }

                if (value > minmaxnums[0]) {
                    minmaxnums[0] = value;
                    minmaxkeys[0] = key;
                }
            });

            int valueAsInt = Integer.parseInt(numberMapping.get(minmaxkeys[1]) + numberMapping.get(minmaxkeys[0]));
            totalValue += valueAsInt; 
        }
        scanner.close();

        return totalValue;
    }

    public static void main(String args[]) throws FileNotFoundException {
        int partOne = runPartOne();
        System.out.println(String.format("Part One: %d", partOne));
        int partTwo = runPartTwo();
        System.out.println(String.format("Part Two: %d", partTwo));
    }

}