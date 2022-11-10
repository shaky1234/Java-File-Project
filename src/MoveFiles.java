import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MoveFiles extends BaseApp{
    @Override
    public void RunApp() {
        String FileName = "";
        Boolean FileExist = false;
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)); //Create Input Stream
        System.out.println("Welcome to the Move Files App");
        /*
        * Ask the user what file they want to move.
        * Will loop through until a valid file or the user type's exit
        * */
        do {
            System.out.println("Type out the file you want to move");
            try {
                FileName = reader.readLine(); //Listens for user input
            } catch (IOException e) {

            }
            if(FileName.toLowerCase() == "exit"){
                break;
            }
            FileExist = CheckFile(FileName);
            if(FileExist){
                System.out.printf("%s is a valid file.%n",FileName);
                MoveFile(FileName);
            } else {
                System.out.printf("%s is not a valid file.%n", FileName);
            }

        } while(!FileExist);
    }

    /*
    * Move File function
    * */
    private void MoveFile(String f){
        Path from = Paths.get(f); //From file
        String ToFolder = ""; //Place holder
        System.out.println("Where do you want to move the file?");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)); //Create Input Stream
        try {
            ToFolder = reader.readLine(); //Listens for user input
        } catch (IOException e) {

        }
        //Check if to folder is a directory
        if(CheckDirectory(ToFolder)){
            Path toFolderPath = Paths.get(ToFolder+"\\"+from.getFileName()); //Setup to file
            try{
                System.out.println("Would you like to 1:move or 2:copy the file?"); //Setup option to either move or copy
                String CopyOption = reader.readLine(); //Listens for user input
                switch (CopyOption){
                    case "1":
                        Files.move(from,toFolderPath, StandardCopyOption.REPLACE_EXISTING); //Move File
                        break;
                    case "2":
                        Files.copy(from,toFolderPath, StandardCopyOption.REPLACE_EXISTING); //Copy File
                        break;
                }

            }catch (Exception e){

            }
        }
    }
}
