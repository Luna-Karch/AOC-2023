import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Character;

public class day1 {
    public static void main(String args[]) throws FileNotFoundException {
        File inputFile = new File("day1-sample.txt");
        Scanner scanner = new Scanner(inputFile);

        char leftSide = ' ';
        char rightSide = ' ';

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

            // Get values from leftSide and rightSide

            leftSide = ' ';
            rightSide = ' '; 
            // ^^ Resetting the values on either side after going to the next line
        }
        scanner.close();
    }
}