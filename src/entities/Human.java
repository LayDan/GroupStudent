package entities;

public class Human {
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

    public double getHeight() {
        return height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "age: " + age + "; height: " + height + "; weight: " + weight;
    }
}
