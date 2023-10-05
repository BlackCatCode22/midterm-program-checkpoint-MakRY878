
//updated 9/28

public class Main {

    // Creating the genUniqueID method

    private static String genUniqueID(String theSpecies, int numOfSpecies){
        String prefix = "";
        int suffix = numOfSpecies + 1;
        if(theSpecies.contains("hyena")){
            prefix = "Hy";
        }
        return prefix + Integer.valueOf(suffix);


    }

    public static void main(String[] args) {

        //call the static method to create a list of names


        System.out.println("\n Welcome to the zoo.");
        //look at our animal names file
        //call inputHyenaNames()

        Hyena.inputHyenaNames();
        Bear.inputBearNames();
        Lion.inputLionNames();
        Tiger.inputTigerNames();

        Hyena.listOut();
        Bear.listOut();
        Lion.listOut();
        Tiger.listOut();


       int currentNumOfHyenas = Hyena.getNumOfHyenas();



        //pop a name from the hyena list
        String hyenaName = Hyena.popHyenaName();
        System.out.println("\n The popped hyena name is: " + hyenaName);
        
        String bearName = Bear.popBearName();
        System.out.println("\n The popped bear name is: " + bearName );

        String lionName = Lion.popLionName();
        System.out.println("\n The popped lion name is " + lionName);

        String tigerName = Tiger.popTigerName();
        System.out.println("\n The popped tiger name is " + tigerName);


    }
}