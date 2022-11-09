import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class ListFiles extends BaseApp{
    public void RunApp(){
        String FolderName = ""; //Folder name placeholder
        Set<String> FileSet = null; //File set placeholder
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)); //Create Input Stream
        System.out.println("Welcome to the List Files App");
        System.out.println("Type out the directory you want the app to list");

        try {
            FolderName = reader.readLine(); //Listens for user input
        } catch (IOException e){
            FolderName = "C:/"; //Assuming the user is on a window's machine
        }
        if (FolderName.length() == 0) {
            FolderName = "C:/"; //Assuming the user is on a window's machine
        }
        Path p = Paths.get(FolderName);

        //Checks if path is a directory
        if (Files.isDirectory(p)){
            System.out.printf("%s is a valid folder.%n",FolderName);
            try{
                FileSet = ListFiles(p); // Grab set of files from the directory
                //Loops through set for printing in the console
                for(String f : FileSet){
                    System.out.println(f);
                }
            } catch (IOException e){

            }
        } else {
            System.out.printf("%s is not a valid folder.%n",FolderName);
        }
    }

    /* This method list available files in the folder
    * Returns Set<String>
    * */
    public Set<String> ListFiles(Path p) throws IOException {
        try (Stream<Path> stream = Files.list(p)) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        }
    }
}
