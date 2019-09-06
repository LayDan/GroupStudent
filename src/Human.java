class Human {
    private int age;
    private double height;
    private double weight;

    Human(int age, double height, double weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "age: " + age + "; height: " + height + "; weight: " + weight;
    }

}
