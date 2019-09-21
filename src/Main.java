import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
//        Group group = new Group();
//        group.addStudent(new Student(17, 190, 86, true, "Киря", "Полянский"));
//        group.addStudent(new Student(18, 185, 89, true, "Валера", "Васильковский"));
//        group.addStudent(new Student(17, 180, 85, true, "Саня", "Коростелёв"));
//        group.priziv();
//        group.writeFile();
//        group.readFile();
//        new XmlFileIO().toXml(group);
        Group group = new XmlFileIO().fromXml();
        System.out.println(group.toString());

    }
}
