import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class day2 {
    public static void runPartOne() throws FileNotFoundException {
        File inputFile = new File("day2-sample.txt");
        Scanner scanner = new Scanner(inputFile);

        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            System.out.println(currentLine);
        }
        scanner.close();

    }


    public static void main(String args[]) throws FileNotFoundException {
        runPartOne();
    }
}