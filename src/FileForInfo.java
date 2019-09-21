import java.io.File;

public class FileForInfo {
    private File file = new java.io.File(System.getProperty("user.home") + "/Desktop", "Info.txt");


    public File getFile() {
        return file;
    }
}
