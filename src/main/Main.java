package main;

import entities.Student;
import entities.group.Group;
import fileWork.JsonFileIO;
import org.xml.sax.SAXException;
//import javax.xml.bind.JAXBContext;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
//        Group group = new Group();
//        group.addStudent(new Student(17, 190, 86, true, "Киря", "Полянский"));
//        group.addStudent(new Student(18, 185, 89, true, "Валера", "Васильковский"));
//        group.addStudent(new Student(17, 180, 85, true, "Саня", "Коростелёв"));
//        group.writeFile();
//        group.priziv();
//        group.writeFile();
//        group.readFile();
//        new XmlFileIO().toXml(group);
//        group = new XmlFileIO().fromXml();
//        new JsonFileIO().toFile(group);
        Group group = new JsonFileIO().fromFile();
        System.out.println(group.toString());

    }
}
