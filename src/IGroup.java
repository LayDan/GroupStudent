import java.io.FileNotFoundException;
import java.io.IOException;

public interface IGroup {
    void addStudent(Student student);

    void deleteStudent(String firstName, String SecondName);

    void seekStudent(String secondNAme);

    void writeFile();

    void readFile() throws IOException;
}
