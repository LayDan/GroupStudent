class Student extends Human {

    private String firstName;
    private String secondName;

    Student(int age, double height, double weight,boolean isMan, String firstName, String secondName) {
        super(age, height, weight,isMan);
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName + " " +super.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}
