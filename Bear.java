import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Bear extends Animal {

    //create a static member variable that accumulates the number of hyenas created
    private static int numOfBears = 0;
    private static final List<String> myListOfBearNames = new ArrayList<>();
    public static int getNumOfHyenas() {
        return numOfBears;
    }

    //create a constructor that will increment numOfHyenas when a new hyena object is created


    public Bear() {
        System.out.println("\n A new Bear  was created.");
        numOfBears++;

    }
    //create a method that inputs hyena names from a file named: animalNames.txt

    public static void inputBearNames() {


        try (BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\Makal\\OneDrive\\Documents\\zooProgramFile\\animalNames.txt"));
             Scanner scanner = new Scanner(System.in)) {

            String line;
            //System.out.println("Press Enter to read the next line (or 'q' to quit): ");
            int lineNum = 1;

            while ((line = fileReader.readLine()) != null) {
                //System.out.println(line);

                if (lineNum == 3) {
                    String[] values = line.split(",");
                    for (String value : values) {
                        myListOfBearNames.add(value.trim());
                    }
                }

                lineNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();

//create an ID for our new animal


        }
    }


    public static void listOut() {
        for (String name : myListOfBearNames) {
            System.out.println(name);
        }
    }

    //pop one name off the list
    //
    static String removeBearName;
    public static String popBearName() {
        if (!myListOfBearNames.isEmpty()) {
            removeBearName = myListOfBearNames.remove(0);
        } else {
            System.out.println("ArrayList is empty. No elements to remove.");
            removeBearName = ""; // Assign an empty string or handle it as needed
        }
        return removeBearName;
    }
}
