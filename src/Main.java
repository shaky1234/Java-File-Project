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
        try {
            Opt = reader.readLine(); //Listens for user input
        } catch (IOException e){
            Opt = "1";
        }

        switch (Opt){
            default:
                System.out.println("You picked Option 1");
                ba = new  ListFiles(); //Create new ListFiles Application
                ba.RunApp(); //Run App
                break;
        }
    }
}