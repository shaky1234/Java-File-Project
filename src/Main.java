import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    * This is a simple application that is a launching point to other simple file application
    * */
    public static void main(String[] args) {
        String Opt = "1"; //Set Option placeholder
        BaseApp ba = null; //Create Baseapp placeholder
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)); //Create Input Stream

        System.out.println("Welcome to My File Project");
        System.out.println("Please Select one of the following options");
        System.out.println("1: List files in a Directory");
        System.out.println("2: Move Files from one Directory to Another.");
        try {
            Opt = reader.readLine(); //Listens for user input
        } catch (IOException e){
            Opt = "1";
        }

        switch (Opt){
            case "2":
                System.out.println("You picked Option 2");
                ba = new MoveFiles();
                ba.RunApp();
                break;
            default:
                System.out.println("You picked Option 1");
                ba = new  ListFiles(); //Create new ListFiles Application
                ba.RunApp(); //Run App
                break;
        }
    }
}