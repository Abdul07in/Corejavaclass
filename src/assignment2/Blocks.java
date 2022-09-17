package assignment2;

public class Blocks {
    int a, b = 20;

    {
        System.out.println("First Anonymous Block");
    }

    {
        System.out.println("Second Anonymous Block");
    }

    public Blocks(int a) {
        System.out.println("One Parameter Constructor");
        this.a = a;
    }

    public static void main(String[] args) {
        Blocks obj = new Blocks(10);
        System.out.println("a = " + obj.a);
        System.out.println("b = " + obj.b);

    }
}
