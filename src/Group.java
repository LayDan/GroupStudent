import java.io.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Group implements IGroup, ICommissar {

    private Student[] listAboutGroup = new Student[10];

    @Override
    public void addStudent(Student student) {
        boolean add = false;
        for (int i = 0; i < listAboutGroup.length; i++) {
            if (listAboutGroup[i] == null) {
                listAboutGroup[i] = student;
                System.out.println(student.getFirstName() + " " + student.getSecondName() + " успешно добавлен в группу");
                add = true;
                sort(true);
                break;
            }
        }
        if (!add) {
            System.out.println("Мест нет");
        }
    }

    public void sortStudentByParametr(String secondName) {
        sort(true);
    }

    public void sortStudentByParametr(int a) {
        sort(false);
    }


    @Override
    public void deleteStudent(String firstName, String SecondName) {
        int cheek = 0;
        try {
            for (int i = 0; i < listAboutGroup.length; i++) {
                if (listAboutGroup[i].getSecondName().equals(SecondName) && listAboutGroup[i].getFirstName().equals(firstName)) {
                    System.out.println(listAboutGroup[i].getFirstName() + " " + listAboutGroup[i].getSecondName() + " покинул группу");
                    listAboutGroup[i] = null;
                    break;
                }
            }
        } catch (NullPointerException a) {
            cheek++;
        }
        if (cheek == 10) {
            System.out.println("Группа пуста");
        }
        sort(true);
    }

    @Override
    public void seekStudent(String secondNAme) {
        int cheek = 0;
        for (Student a : listAboutGroup) {

            try {
                if (secondNAme.equals(a.getSecondName())) {
                    cheek++;
                }
            } catch (NullPointerException ignored) {

            }
        }
        if (cheek >= 1) {
            System.out.println(cheek + " студент(а)(oв) с данной фамилией существует в группе");
        }

    }

    @Override
    public String toString() {
        sort(true);
        String out = "";
        for (int i = 0; i < listAboutGroup.length; i++) {
            try {
                out = out.concat(i + 1 + ")" + listAboutGroup[i].toString() + "\n");
            } catch (NullPointerException ignored) {

            }
        }
        return out;
    }

    private void sort(boolean a) {
        if (a) {
            for (int i = 0; i < listAboutGroup.length - 1; i++) {
                for (int j = 0; j < listAboutGroup.length - i - 1; j++) {
                    try {
                        if ((int) listAboutGroup[j].toString().charAt(0) >
                                (int) listAboutGroup[j + 1].toString().charAt(0)) {
                            Student temp = listAboutGroup[j];
                            listAboutGroup[j] = listAboutGroup[j + 1];
                            listAboutGroup[j + 1] = temp;
                        }
                    } catch (NullPointerException ignored) {

                    }
                }
            }
        } else {
            for (int i = 0; i < listAboutGroup.length - 1; i++) {
                for (int j = 0; j < listAboutGroup.length - i - 1; j++) {
                    try {
                        if (listAboutGroup[j].getAge() < listAboutGroup[j + 1].getAge()) {
                            System.out.println(listAboutGroup[j].getAge());
                            Student temp = listAboutGroup[j];
                            listAboutGroup[j] = listAboutGroup[j + 1];
                            listAboutGroup[j + 1] = temp;
                        }
                    } catch (NullPointerException ignored) {

                    }
                }
            }
        }
    }

    @Override
    public void writeFile() {
        try {
            file();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new FileForInfo().getFile()));
        StringBuilder sb = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = bufferedReader.readLine();
        }
        String everything = sb.toString();
        System.out.println(everything);
        bufferedReader.close();
    }

    private void file() throws IOException {
        FileWriter writer = new FileWriter(new FileForInfo().getFile());
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        if (listAboutGroup.length != 0) {
            int numer = 1;
            int nullPoint = 0;
            Date date = new Date();
            bufferedWriter.write("<Группа была записана: " + new SimpleDateFormat("dd MMMM yyyy ',' HH:mm'>'").format(date));

            bufferedWriter.newLine();
            bufferedWriter.write(numer + ")");
            try {
                for (Student a : listAboutGroup) {
                    if (a == null) {
                        nullPoint++;
                    }
                }
                for (int i = 0; i != listAboutGroup.length; i++) {
                    if (listAboutGroup[i] != null) {
                        bufferedWriter.write(listAboutGroup[i].toString());
                        numer++;
                        bufferedWriter.write(";");
                        bufferedWriter.newLine();
                        if (i != listAboutGroup.length - 1 - nullPoint) {
                            bufferedWriter.write(numer + ")");
                        }
                    }
                }
            } catch (NullPointerException ignored) {

            }
            bufferedWriter.flush();
            bufferedWriter.close();

        }
    }

    @Override
    public Student[] priziv() {
        int size = 0;
        Student[] buf = new Student[listAboutGroup.length];
        try {
            for (Student a : listAboutGroup) {
                if (a == null) {
                    break;
                }
                if (a.isMan()) {
                    for (int i = 0; i < buf.length; i++) {
                        if (buf[i] == null) {
                            buf[i] = a;
                            size++;
                            break;
                        }
                    }
                }
            }
        } catch (NullPointerException ignored) {

        }
        Student[] prizivniki = new Student[size];
        for (int i = 0; i < buf.length; i++) {
            if (buf[i] != null) {
                prizivniki[i] = buf[i];
            }
        }
        return prizivniki;
    }
}
