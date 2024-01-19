package demoProject.P2;
import demoProject.P1.A;

class C {
    A a = new A();
    void disp() {
        System.out.println(a.a);
        // System.out.println(b);
        //System.out.println(a.c);
        //System.out.println(a.d);
    }
}

class D extends A{
    void disp() {
        A a = new A();
        System.out.println(a.a);
        // System.out.println(b);
        // System.out.println(a.c);
        //System.out.println(d);
    }
}

class E{
    public static void main(String[] args) {
        C c = new C();
        c.disp();
    }
}

