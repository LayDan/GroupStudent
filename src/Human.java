class Human {
    private int age;
    private double height;
    private double weight;
    private boolean isMan;

    Human(int age, double height, double weight, boolean isMan) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.isMan = isMan;
    }

    public boolean isMan() {
        return isMan;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "age: " + age + "; height: " + height + "; weight: " + weight;
    }
}
