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
        scanner.close();

        for (int y = 0; y < fileData.size(); y++) {
            String currentLine = fileData.get(y);

            boolean digitMode = false;
            ArrayList<Character> numberBuffer = new ArrayList<Character>();
            ArrayList<ArrayList<Integer>> indexBuffer = new ArrayList<ArrayList<Integer>>();

            for (int x = 0; x < currentLine.length(); x++) {
                char character = currentLine.charAt(x);

                if (!Character.isDigit(character) && digitMode) {
                    digitMode = false;

                    NumberAndLocation numberValues = new NumberAndLocation(numberBuffer, indexBuffer);

                    System.out.println(numberValues.getValue());
                    System.out.println(numberValues.getCoordinates());
                    System.out.println();

                    numberBuffer.clear();
                    indexBuffer.clear();
                    continue;
                } // ^^ When reaching end of buffer

                if (Character.isDigit(character)) {
                    digitMode = true;
                    numberBuffer.add(character);

                    ArrayList<Integer> indicesPair = new ArrayList<Integer>();
                    indicesPair.add(x);
                    indicesPair.add(y);

                    indexBuffer.add(indicesPair);
                } // ^^ If character is a digit and the buffer hasn't begun
            }
        }

        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        runPartOne();
    }
}

class NumberAndLocation {
    private int value;
    private ArrayList<ArrayList<Integer>> coordinates = new ArrayList<ArrayList<Integer>>();

    public NumberAndLocation (ArrayList<Character> numberBuffer, ArrayList<ArrayList<Integer>> coordinates) {
        String valueBuffer = "";
        for (char numberPart : numberBuffer) {
            valueBuffer += numberPart;
        }

        this.value = Integer.parseInt(valueBuffer);
        this.coordinates = coordinates;
    }

    public int getValue() {
        return this.value;
    }

    public ArrayList<ArrayList<Integer>> getCoordinates() {
        return this.coordinates;
    }

}