public class Group {


    private Student[] listAboutGroup = new Student[10];

    void addStudent(Student student) {
        ///////////////////////////////////////////////////////////
        boolean add = false;
        for (int i = 0; i < listAboutGroup.length; i++) {
            if (listAboutGroup[i] == null) {
                listAboutGroup[i] = student;
                add = true;
                break;
            }
        }
        if (add) {
            System.out.println(student.infoAboutHuman() + " был добавлен в группу");
        } else {
            System.out.println("Группа заполненна, нельзя добавить студента");
        }
    }
    ////////////////////////////////////////////////////////////////////////////\
    //если создавать исключение, то оно будет выглядеть примерно так
//    try {
//        listAboutGroup[11] = student;
//    } catch (ArrayIndexOutOfBoundsException a) {
//        System.out.println("В группе могут находится только 10 студентов");
//    }


    void deleteStudent(int number) {
        if (number < 1 || number > 10) {
            System.out.println("В студенте 10 студентов, соответсвенно порядковому номеру, " + number + " не является этим номер");
        } else {
            number -= 1;
            if (listAboutGroup[number] != null) {
                System.out.println(listAboutGroup[number].infoAboutHuman() + " покинул группу");
                listAboutGroup[number] = null;
            } else {
                System.out.println("Выбраное место и так пустое");
            }
        }
    }

    void seekStudent(String secondNAme) {

        for (Student a : listAboutGroup) {
            try {
                if (secondNAme.equals(a.infoAboutHuman())) {
                    System.out.println("Студент с данной фамилией существует в группе");
                    break;
                }
            } catch (NullPointerException ignored) {

            }
        }

    }

    @Override
    public String toString() {

        for (int i = 0; i < listAboutGroup.length - 1; i++) {
            for (int j = 0; j < listAboutGroup.length - i - 1; j++) {
                try {
                    if ((int) listAboutGroup[j].infoAboutHuman().charAt(0) >
                            (int) listAboutGroup[j + 1].infoAboutHuman().charAt(0)) {
                        Student temp = listAboutGroup[j];
                        listAboutGroup[j] = listAboutGroup[j + 1];
                        listAboutGroup[j + 1] = temp;
                    }
                } catch (NullPointerException ignored) {

                }
            }
        }
        String out = "";
        for (int i = 0; i < listAboutGroup.length; i++) {
            try {
                out = out.concat(i + 1 + ")" + listAboutGroup[i].infoAboutHuman() + "\n");
            } catch (NullPointerException ignored) {

            }
        }
        return out;
    }
}
