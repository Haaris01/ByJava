package demoProject;

abstract class Bank{
    abstract void loan();

}

class SBI extends Bank{

    @Override
    void loan() {
        System.out.println("I provide sbi loans");
    }
}
public class Demo10 {
    public static void main(String[] args){
        SBI sbi = new SBI();
        sbi.loan();
    }
}
