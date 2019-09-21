import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
    private String age;
    private String height;
    private String weight;
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
}