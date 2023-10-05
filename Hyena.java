import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Hyena extends Animal {

    //create a static member variable that accumulates the number of hyenas created
    private static int numOfHyenas = 0;
    private static final List<String> myListOfHyenaNames = new ArrayList<>();
    public static int getNumOfHyenas() {
        return numOfHyenas;
    }

    //create a constructor that will increment numOfHyenas when a new hyena object is created


    public Hyena() {
        System.out.println("\n A new Hyena  was created.");
        numOfHyenas++;

    }
    //create a method that inputs hyena names from a file named: animalNames.txt

    public static void inputHyenaNames() {


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
                        myListOfHyenaNames.add(value.trim());
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
        for (String name : myListOfHyenaNames) {
            System.out.println(name);
        }
    }

    //pop one name off the list
    //
    static String removeHyenaName;
    public static String popHyenaName() {
        if (!myListOfHyenaNames.isEmpty()) {
            removeHyenaName = myListOfHyenaNames.remove(0);
        } else {
            System.out.println("ArrayList is empty. No elements to remove.");
            removeHyenaName = ""; // Assign an empty string or handle it as needed
        }
        return removeHyenaName;
    }
}
