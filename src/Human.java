class Human {
    private int age;
    private double height;
    private double weight;

    Human(int age, double height, double weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    String infoAboutHuman() {
        return "age = " + age + "\n height = " + height + "\n weight = " + weight;
    }
}
