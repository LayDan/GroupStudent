import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;


public class XmlFileIO {
    private String FirstName;
    private String SecondName;
    private int age;
    private boolean isMan;
    private double height;
    private double weight;
    private int leng = 0;

    public void toXml(Group group) throws ParserConfigurationException {
        Element student = null;
        Element name = null;
        Element secondname = null;
        Element age = null;
        Element height = null;
        Element weight = null;
        Element isMan = null;
        Document document;
        DocumentBuilderFactory bf = DocumentBuilderFactory.newDefaultInstance();

        DocumentBuilder db = bf.newDocumentBuilder();

        document = db.newDocument();

        Element rootElement = document.createElement("Group");
        for (int i = 0; i < group.getListAboutGroup().length; i++) {
            if (group.getListAboutGroup()[i] != null) {
                leng++;
            }
        }
        for (int i = 0; i < leng; i++) {
            student = document.createElement("Student");
            name = document.createElement("FirstName");
            secondname = document.createElement("SecondName");
            age = document.createElement("Age");
            height = document.createElement("Height");
            weight = document.createElement("Weight");
            isMan = document.createElement("Man");

            name.setTextContent(group.getListAboutGroup()[i].getFirstName());
            secondname.setTextContent(group.getListAboutGroup()[i].getSecondName());
            age.setTextContent(String.valueOf(group.getListAboutGroup()[i].getAge()));
            height.setTextContent(String.valueOf(group.getListAboutGroup()[i].getHeight()));
            weight.setTextContent(String.valueOf(group.getListAboutGroup()[i].getWeight()));
            isMan.setTextContent(String.valueOf(group.getListAboutGroup()[i].isMan()));

            student.appendChild(name);
            student.appendChild(secondname);
            student.appendChild(age);
            student.appendChild(height);
            student.appendChild(weight);
            student.appendChild(isMan);
            rootElement.appendChild(student);
        }

        document.appendChild(rootElement);
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            // send DOM to file
            tr.transform(new DOMSource(document),
                    new StreamResult(new FileOutputStream("XmlFile.xml")));

        } catch (
                TransformerException | IOException te) {
            System.out.println(te.getMessage());
        }
    }

    public Group fromXml() throws ParserConfigurationException, IOException, SAXException {
        Group group = new Group();
        // дерево DOM из файла
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse("XmlFile.xml");
        //корневой элемент
        Node root = document.getDocumentElement();
        //"массив" подкорневых элеметов
        NodeList students = root.getChildNodes();

        //Пробегаю по этому "массиву" и проверяю каждый его элемент
        for (int i = 0; i < students.getLength(); i++) {
            Node student = students.item(i);
            if (student.getNodeType() != Node.TEXT_NODE) {            //Проверка на то, действительно ли это студент
                NodeList studentProps = student.getChildNodes();
                for (int j = 0; j < studentProps.getLength(); j++) {       //массив свойств студента
                    Node studentProp = studentProps.item(j);
                    if (studentProp.getNodeName().equals("FirstName")) {
                        FirstName = studentProp.getChildNodes().item(0).getTextContent();  //ставим FirstName
                    }
                    if (studentProp.getNodeName().equals("SecondName")) {
                        SecondName = (studentProp.getChildNodes().item(0).getTextContent());        //ставим SecondName
                    }
                    if (studentProp.getNodeName().equals("Age")) {
                        age = (Integer.parseInt(studentProp.getChildNodes().item(0).getTextContent()));        //ставим Age
                    }
                    if (studentProp.getNodeName().equals("Height")) {
                        height = (Double.parseDouble(studentProp.getChildNodes().item(0).getTextContent()));        //ставим Height
                    }
                    if (studentProp.getNodeName().equals("Weight")) {
                        weight = (Double.parseDouble(studentProp.getChildNodes().item(0).getTextContent()));        //ставим Weight
                    }
                    if (studentProp.getNodeName().equals("Man")) {
                        isMan = (Boolean.parseBoolean(studentProp.getChildNodes().item(0).getTextContent()));        //ставим Man
                    }
                }
                if (FirstName != null) {
                    group.addStudent(new Student(age, height, weight, isMan, FirstName, SecondName));
                }
            }
        }
        return group;
    }
}