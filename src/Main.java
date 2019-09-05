public class Main {
    public static void main(String[] args) {
        Group group = new Group();
        group.addStudent(new Student(18, 180, 80, "Alex", "Brawn"));
        group.addStudent(new Student(18, 180, 80, "Alex", "Cloud"));
        group.addStudent(new Student(18, 180, 80, "Alex", "Green"));
        group.addStudent(new Student(18, 180, 80, "Alex", "Ambious"));
        group.addStudent(new Student(18, 180, 80, "Alex", "Ciclum"));
        group.addStudent(new Student(18, 180, 80, "Alex", "Dermir"));
        group.addStudent(new Student(18, 180, 80, "Alex", "Logos"));
        group.deleteStudent(1);
        System.out.println(group.toString());
        group.seekStudent("Dermir");
    }
}
