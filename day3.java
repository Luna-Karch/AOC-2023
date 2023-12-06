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

                    NumberAndLocation numberValues = new NumberAndLocation(numberBuffer, indexBuffer, fileData.size(), fileData.get(0).length());
                    System.out.println(numberValues.getValue());
                    System.out.println(numberValues.getCoordinates());
                    numberValues.checkCoordinates();
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
    private int lineCount;
    private int lineLength;
    private ArrayList<ArrayList<Integer>> coordinates = new ArrayList<ArrayList<Integer>>();

    public NumberAndLocation (ArrayList<Character> numberBuffer, ArrayList<ArrayList<Integer>> coordinates, int lineCount, int lineLength) {
        String valueBuffer = "";
        for (char numberPart : numberBuffer) {
            valueBuffer += numberPart;
        }

        this.value = Integer.parseInt(valueBuffer);
        this.coordinates = coordinates;
        this.lineCount = lineCount;
        this.lineLength = lineLength;
    }

    public int getValue() {
        return this.value;
    }

    public ArrayList<ArrayList<Integer>> getCoordinates() {
        return this.coordinates;
    }

    private ArrayList<ArrayList<Integer>> getCheckableCoordinates() {
        // Implement
        ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> leftmost = this.coordinates.get(0);
        ArrayList<Integer> rightmost = this.coordinates.get(this.coordinates.size() - 1);

        ArrayList<Integer> topLeftCorner = new ArrayList<Integer>() {{
            add(leftmost.get(0) - 1);
            add(leftmost.get(1) - 1);
        }};

        ArrayList<Integer> topRightCorner = new ArrayList<Integer>() {{
            add(rightmost.get(0) + 1);
            add(rightmost.get(1) - 1);
        }};

        ArrayList<Integer> bottomLeftCorner = new ArrayList<Integer>() {{
            add(leftmost.get(0) - 1);
            add(leftmost.get(1) + 1);
        }};

        ArrayList<Integer> bottomRightCorner = new ArrayList<Integer>() {{
            add(rightmost.get(0) + 1);
            add(rightmost.get(1) - 1);
        }};
    
        for (int i = topLeftCorner.get(0); i < topRightCorner.get(0) + 1; i++) {
            int row = topLeftCorner.get(1);
            if (i < 0 || row < 0 || i > lineCount - 1 || row > lineCount - 1) {
                continue;
            }

            ArrayList<Integer> newPair = new ArrayList<Integer>();
            newPair.add(i);
            newPair.add(row);

            result.add(newPair);
        } // Above, including diagonals, accounting for out of bounds

        for (int i = bottomLeftCorner.get(0); i < bottomRightCorner.get(0) + 1; i++) {
            int row = bottomLeftCorner.get(1);
            if (i < 0 || row < 0 || i > lineCount - 1 || row > lineCount - 1) {
                continue;
            }

            ArrayList<Integer> newPair = new ArrayList<Integer>();
            newPair.add(i);
            newPair.add(row);

            result.add(newPair);
        } // Below, including diagonals, accounting for out of bounds

        if (leftmost.get(0) - 1 >= 0) {
            result.add(new ArrayList<Integer>() {{
                add(leftmost.get(0) - 1);
                add(leftmost.get(1));
            }});
        }

        if (rightmost.get(0) + 1 < this.lineLength - 1) {
            result.add(new ArrayList<Integer>() {{
                add(rightmost.get(0) + 1);
                add(rightmost.get(1));
            }});
        }

        return result;
    }

    public boolean checkCoordinates() {
        System.out.println("CHECKABLE COORDINATES:");
        System.out.println(this.getCheckableCoordinates());
        return true;
    }

}