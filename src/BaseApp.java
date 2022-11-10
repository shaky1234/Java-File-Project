import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

interface iBaseApp{
    public void RunApp();
}
//Base Class for my file applications
 abstract class BaseApp implements iBaseApp {
    public abstract void RunApp();

    /*
   *Check if File exist
   * */
    public boolean CheckFile(String f){
        Path p = Paths.get(f);
        return Files.isRegularFile(p);
    }

    /*
    * Check if Directory exist
    * */
    public boolean CheckDirectory(String f){
        Path p = Paths.get(f);
        return Files.isDirectory(p);
    }

}
