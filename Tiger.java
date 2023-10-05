import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Tiger extends Animal {

    // Create a static member variable that accumulates the number of tigers created
    private static int numOfTigers = 0;
    private static final List<String> myListOfTigerNames = new ArrayList<>();

    public static int getNumOfTigers() {
        return numOfTigers;
    }

    // Create a constructor that will increment numOfTigers when a new tiger object is created
    public Tiger() {
        System.out.println("\n A new Tiger was created.");
        numOfTigers++;
    }

    // Create a method that inputs tiger names from a file named: animalNames.txt
    public static void inputTigerNames() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\Makal\\OneDrive\\Documents\\zooProgramFile\\animalNames.txt"));
             Scanner scanner = new Scanner(System.in)) {

            String line;
            int lineNum = 1;

            while ((line = fileReader.readLine()) != null) {
                if (lineNum == 15) {
                    String[] values = line.split(",");
                    for (String value : values) {
                        myListOfTigerNames.add(value.trim());
                    }
                }

                lineNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listOut() {
        for (String name : myListOfTigerNames) {
            System.out.println(name);
        }
    }

    // Pop one name off the list
    static String removeTigerName;
    public static String popTigerName() {
        if (!myListOfTigerNames.isEmpty()) {
            removeTigerName = myListOfTigerNames.remove(0);
        } else {
            System.out.println("ArrayList is empty. No elements to remove.");
            removeTigerName = ""; // Assign an empty string or handle it as needed
        }
        return removeTigerName;
    }
}

