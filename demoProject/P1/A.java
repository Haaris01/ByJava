package demoProject.P1;

public class A {
    public int a = 5;
    // access everywhere in the project with creation of object if not extended
    private int b = 6;
    // only same class scope
    protected int c = 7;
    // scope in the same package and subclassses of other project
    int d = 8;
    //scope only in the same package

    void display(){
        System.out.println(a); 
        System.out.println(b); 
        System.out.println(c);
        System.out.println(d);
    }

    // public static void main(String[] args) {
    //     A a = new A();
    //     System.out.println(a);
    // }
}

class B extends A{
    void display() {
        System.out.println(a);
        //System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}

class C{
    A a = new A();
    void display(){
        System.out.println(a.a);
        //System.out.println(a.b);
        System.out.println(a.c);
        System.out.println(a.d);
    }
}