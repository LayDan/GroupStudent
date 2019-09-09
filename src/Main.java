import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Group group = new Group();
        group.addStudent(new Student(18,183,45,true,"Alexander", "Markovich"));
        group.addStudent(new Student(18,183,45,false,"Alex", "Markovich"));
        group.addStudent(new Student(18,183,45,true,"Stepan", "Markovich"));
//        group.addStudent(new Student(18,183,45,false,"Alex", "Markovich"));
//        group.addStudent(new Student(18,183,45,false,"Alex", "Markovich"));
        group.addStudent(new Student(18,183,45,true,"Kolder", "Markovich"));
        group.addStudent(new Student(18,183,45,true,"Karl", "Markovich"));
        group.addStudent(new Student(18,183,45,false,"Alex", "Markovich"));
        group.addStudent(new Student(18,183,45,false,"Alex", "Markovich"));
        group.addStudent(new Student(19,183,45,false,"Alex", "Markovich"));
        group.seekStudent("Markovich");
        group.writeFile();
        group.readFile();
    }
}
