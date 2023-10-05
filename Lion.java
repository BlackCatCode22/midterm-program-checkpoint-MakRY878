import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Lion extends Animal {

    // Create a static member variable that accumulates the number of lions created
    private static int numOfLions = 0;
    private static final List<String> myListOfLionNames = new ArrayList<>();

    public static int getNumOfLions() {
        return numOfLions;
    }

    // Create a constructor that will increment numOfLions when a new lion object is created
    public Lion() {
        System.out.println("\n A new Lion was created.");
        numOfLions++;
    }

    // Create a method that inputs lion names from a file named: animalNames.txt
    public static void inputLionNames() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\Makal\\OneDrive\\Documents\\zooProgramFile\\animalNames.txt"));
             Scanner scanner = new Scanner(System.in)) {

            String line;
            int lineNum = 1;

            while ((line = fileReader.readLine()) != null) {
                if (lineNum == 7) {
                    String[] values = line.split(",");
                    for (String value : values) {
                        myListOfLionNames.add(value.trim());
                    }
                }

                lineNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listOut() {
        for (String name : myListOfLionNames) {
            System.out.println(name);
        }
    }

    // Pop one name off the list
    static String removeLionName;
    public static String popLionName() {
        if (!myListOfLionNames.isEmpty()) {
            removeLionName = myListOfLionNames.remove(0);
        } else {
            System.out.println("ArrayList is empty. No elements to remove.");
            removeLionName = ""; // Assign an empty string or handle it as needed
        }
        return removeLionName;
    }
}

