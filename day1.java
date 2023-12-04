import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day1 {
    public static void main(String args[]) throws FileNotFoundException {
        File inputFile = new File("day1-sample.txt");
        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}