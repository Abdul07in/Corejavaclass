package assignment2;

public class Vehicle {
    public Vehicle() {
        System.out.println("Zero Parameters");
    }

    public Vehicle(int a) {
        System.out.println("One Parameters");
    }

    public Vehicle(String a, int b) {
        System.out.println("Two Parameters");
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Vehicle vehicle2 = new Vehicle(14);
        Vehicle vehicle3 = new Vehicle("Hello", 7);
    }

}
