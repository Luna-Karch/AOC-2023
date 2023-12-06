import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileNotFoundException;

public class day2 {
    public static int runPartOne() throws FileNotFoundException {
        File inputFile = new File("day2-actual.txt");
        Scanner scanner = new Scanner(inputFile);

        int totalPossible = 0;

        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            int gameNumber = Integer.parseInt(currentLine.split(":")[0].split(" ")[1]);

            String[] cubesList = currentLine.split(": ")[1].split(";"); 

            boolean gamePossible = true;

            for (int i = 0; i < cubesList.length; i++) {
                String cubeConfig = cubesList[i].trim();
                for (String pulledCubes : cubeConfig.split(", ")) {
                    String cubeColor = pulledCubes.split(" ")[1];
                    int cubeAmount = Integer.parseInt(pulledCubes.split(" ")[0]);

                    if (cubeColor.equals("red") && cubeAmount > 12) {
                        gamePossible = false;
                    }

                    if (cubeColor.equals("green") && cubeAmount > 13) {
                        gamePossible = false;
                    }

                    if (cubeColor.equals("blue") && cubeAmount > 14) {
                        gamePossible = false;
                    }
                }
            }

            if (gamePossible == true) {
                totalPossible += gameNumber;
            } else {
                gamePossible = true;
            }
        }
        scanner.close();

        return totalPossible;
    }

    public static int runPartTwo() throws FileNotFoundException {
        File inputFile = new File("day2-sample.txt");
        Scanner scanner = new Scanner(inputFile);

        int powerSet = 0;

        while (scanner.hasNextLine()) {
            HashMap<String, Integer> fewestPossibleCubes = new HashMap<String, Integer>();
            fewestPossibleCubes.put("red", 0);
            fewestPossibleCubes.put("green", 0);
            fewestPossibleCubes.put("blue", 0);

            String currentLine = scanner.nextLine().trim();
            String[] cubesList = currentLine.split(": ")[1].split(";");

            for (int i = 0; i < cubesList.length; i++) {
                String cubeConfig = cubesList[i].trim();
                for (String pulledCubes : cubeConfig.split(", ")) {
                    String cubeColor = pulledCubes.split(" ")[1];
                    int cubeAmount = Integer.parseInt(pulledCubes.split(" ")[0]);

                    int currentFewestCubeAmount = fewestPossibleCubes.get(cubeColor);

                    if (currentFewestCubeAmount < cubeAmount) {
                        fewestPossibleCubes.put(cubeColor, cubeAmount);
                    }
                }
            }

            int subtotal = 1;

            for (String key: fewestPossibleCubes.keySet()) {
                subtotal *= fewestPossibleCubes.get(key);
            }

            powerSet += subtotal;
        }
        scanner.close();

        return powerSet;
    }

    public static void main(String args[]) throws FileNotFoundException {
        System.out.println(String.format("Part One: %d", runPartOne()));
        System.out.println(String.format("Part Two: %d", runPartTwo()));
    }
}