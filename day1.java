import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.Character;
import java.io.FileNotFoundException;

public class day1 {
    public static HashMap<String, String> numberMapping = new HashMap<String, String>() {{
        put("one", "1");
        put("two", "2");
        put("three", "3");
        put("four", "4");
        put("five", "5");
        put("six", "6");
        put("seven", "7");
        put("eight", "8");
        put("nine", "9");
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

        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            System.out.println(currentLine);
            // ^^ Just printing the output of each line for now
        }
        scanner.close();

        // Implement Part 2
        return 0;
    }


    public static void main(String args[]) throws FileNotFoundException {
        int partOne = runPartOne();
        System.out.println(String.format("Part One: %d", partOne));
        int partTwo = runPartTwo();
        System.out.println(String.format("Part Two: %d", partTwo));
    }

}