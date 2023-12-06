import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class day3 {

    public static int runPartOne() throws FileNotFoundException {
        File inputFile = new File("day3-sample.txt");
        Scanner scanner = new Scanner(inputFile);
        ArrayList<String> fileData = new ArrayList<String>();

        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            fileData.add(currentLine.trim());
        }

        for (int i = 0; i < fileData.size(); i++) {
            System.out.println(fileData.get(i));
        }
        
        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        runPartOne();
    }
}
