import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
import java.time.LocalDate;

public class Main {

    // Creating the genUniqueID method


    public static String genUniqueID(String theSpecies, int numOfSpecies) {
        String prefix = "";
        int suffix = numOfSpecies + 1;
        if (theSpecies.contains("hyena")) {
            prefix = "Hy";
        } else if (theSpecies.contains("lion")) {
            prefix = "Li";

        } else if (theSpecies.contains("bear")) {
            prefix = "Be";

        } else if (theSpecies.contains("tiger")) {
            prefix = "Ti";

        } else {
            prefix = "XX";
        }

        return prefix + suffix;


    }



    // Call the genUniqueID method and store the result in a variable
    // genUniqueID(theSpecies, numOfSpecies);

    // Print the generated unique ID




    public static void main(String[] args) {

        System.out.println("\n Welcome to the zoo.");
        //look at our animal names file
        //call the static method to create a list of names

        Hyena.inputHyenaNames();
        Bear.inputBearNames();
        Lion.inputLionNames();
        Tiger.inputTigerNames();

        Hyena.listOut();
        Bear.listOut();
        Lion.listOut();
        Tiger.listOut();

        //open a csv file using the split() method on a string object

        String path = "C:/Users/Makal/OneDrive/Documents/zooProgramFile/arrivingAnimals.txt";
        String myFileLine= "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int myCounter = 1;
            while ((myFileLine = reader.readLine()) != null){
                //the input data from arriving animals should look like this
                // 4 year old female hyena, born in spring, tan color, 70 pounds, from Friguia Park, Tunisia
                //create a string array named myArrayOfAnimalData

                String[] myArrayOfAnimalData = myFileLine.split(",");

                String[] myArrayOfGenderSpecies = myArrayOfAnimalData[0].split(" ");

                //output the age, gender and species

               /* System.out.println("\n age in years: " + myArrayOfGenderSpecies[0]);
                System.out.println("\n text for age(should be 'year') " + myArrayOfGenderSpecies[1]);
                System.out.println("\n text for age (should be 'old') " + myArrayOfGenderSpecies[2]);
                System.out.println("\n gender is " + myArrayOfGenderSpecies[3]);
                System.out.println("\n species is " + myArrayOfGenderSpecies[4]);*/
                System.out.println("\n" +myArrayOfGenderSpecies[4]+" "+ myArrayOfGenderSpecies[0]+" "+ myArrayOfGenderSpecies[1]+" "+ myArrayOfGenderSpecies[2]+" "+myArrayOfGenderSpecies[3]);

                //code up the birthDate() method

                //get todays date
                Calendar calendar = Calendar.getInstance();
                Date today = calendar.getTime();

                LocalDate currentDate = LocalDate.now();
                int year = currentDate.getYear();

                //print the year
                System.out.println("\nCurrent Year: " + year);

                int animalsYearOfBirthDate = year - Integer.parseInt(myArrayOfGenderSpecies[0]);

                //split the next group of words by a space
                String[] myArrayOfBirthSeason = myArrayOfAnimalData[1].split(" ");

                String birthSeason = myArrayOfBirthSeason[3];
                System.out.println("\n birth season = " + birthSeason + "\n\n");


            //chat gpt recommendation:
                int currentYear = LocalDate.now().getYear();
                int age=0;
                int yearOfBirth = currentYear - age;
                String myAnimalBD = "";

                if (birthSeason.contains("spring")) {
                    myAnimalBD = "Mar 31, " + yearOfBirth;
                } else if (birthSeason.contains("summer")) {
                    myAnimalBD = "Jun 30, " + yearOfBirth;
                } else if (birthSeason.contains("fall")) {
                    myAnimalBD = "Sep 30, " + yearOfBirth;
                } else if (birthSeason.contains("winter")) {
                    myAnimalBD = "Dec 31, " + yearOfBirth;
                } else {
                    myAnimalBD = "Unknown";
                }




                System.out.println("\n\n Animal birth date is: " + myAnimalBD + "\n\n");


                //subtract 4 years
                calendar.add(Calendar.YEAR, - Integer.parseInt(myArrayOfGenderSpecies[0]));
                //get the new date after subtraction
                Date yearsAgo = calendar.getTime();

                //print the original and new dates

                System.out.println("Today's Date: " + today);
                System.out.println("Date: " + myArrayOfGenderSpecies[0] + " years ago " + yearsAgo);

                System.out.println("\n Species is " + myArrayOfGenderSpecies[4]);
                System.out.println("\n Animal Number " + myCounter + " *******");
                System.out.println("\n myArrayOFAnimalData[0] is..." + myArrayOfAnimalData[0]);
                System.out.println("\n myArrayOFAnimalData[1] is..." + myArrayOfAnimalData[1]);
                System.out.println("\n myArrayOFAnimalData[2] is..." + myArrayOfAnimalData[2]);
                System.out.println("\n myArrayOFAnimalData[3] is..." + myArrayOfAnimalData[3]);
                System.out.println("\n myArrayOFAnimalData[4] is..." + myArrayOfAnimalData[4]);
                System.out.println("\n myArrayOFAnimalData[5] is..." + myArrayOfAnimalData[5]);

                //increment the animal counter
                myCounter++;





            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

  }
}