package practice;

class A {

    public void sleep() {
        System.out.println("Class A sleep");
    }
}

interface B {
    default void sleep() {
        System.out.println("Interface B default sleep");
    }
}

class C extends A implements B {

    public void sleep() {
        B.super.sleep();
    }

}

public class DiamondProblem extends A implements B {

    public static void main(String[] args) {

        C c = new C();
        c.sleep();
    }

}
