import java.util.InputMismatchException;

//when we use static keyword we can access variables and methods of a class
//without creating their objects

import java.util.Scanner;

interface Company {
    void access();

    String companyName = "BlueYonder";

    default void advSal() {
        System.out.println("In java 8 onwards we can write the default method and it belongs to the obj");
    }

    static void cab() {
        System.out.println("In java 8 onwards we can wrtie the static method it does not belong to obj");
    }
}

abstract class Employee {
    int id;
    String name;
    int age;
    protected float salary;
    protected String designation;
    protected float pf;
    protected String company;

    void inputDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Id: ");
        int id = sc.nextInt();
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        this.id = id;
        this.name = name;
        this.age = age;
    }

    void displayDetails() {
        System.out.println("Company: " + this.company);
        System.out.println("ID : " + this.id);
        System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);
        System.out.println("Salary : " + this.salary);
        System.out.println("Designation : " + this.designation);
    }

    boolean salaryUpdated = false;

    abstract void raiseSalary();

    abstract void pf();
}

// final class cannot be inherited so
// no other class can inherit Developer, tester, clerk, Manager
final class Developer extends Employee implements Company {
    Developer() {
        salary = 50000f;
        designation = "Developer";
        company = Company.companyName;
    }

    int hikePercentage = 15;

    @Override
    void raiseSalary() {
        if (!this.salaryUpdated) {
            this.salary += (this.salary / 100f) * hikePercentage;
            this.salaryUpdated = true;
        } else {
            System.out.println("Salary already raised! Please dont ask");
        }
    }

    @Override
    void pf() {
        this.pf = (this.salary / 100f) * 12;
    }

    @Override
    public void access() {
        System.out.println("Developer has access to A block");
    }
}

final class Clerk extends Employee implements Company {
    Clerk() {
        salary = 25000f;
        designation = "Clerk";
        company = Company.companyName;
    }

    int hikePercentage = 5;

    @Override
    void raiseSalary() {
        if (!this.salaryUpdated) {
            this.salary += (this.salary / 100f) * hikePercentage;
            this.salaryUpdated = true;
        } else {
            System.out.println("Salary already raised! Please dont ask");
        }
    }

    @Override
    void pf() {
        this.pf = (this.salary / 100f) * 12;
    }

    @Override
    public void access() {
        System.out.println("Clerk has access to B block");
    }
}

final class Manager extends Employee implements Company {
    Manager() {
        salary = 90000f;
        designation = "Manager";
        company = Company.companyName;
    }

    int hikePercentage = 20;

    @Override
    void raiseSalary() {
        if (!this.salaryUpdated) {
            this.salary += (this.salary / 100f) * hikePercentage;
            this.salaryUpdated = true;
        } else {
            System.out.println("Salary already raised! Please dont ask");
        }
    }

    @Override
    void pf() {
        this.pf = (this.salary / 100f) * 12;
    }

    @Override
    public void access() {
        System.out.println("Manager has access to A,B block");
    }
}

final class Tester extends Employee implements Company {
    Tester() {
        salary = 40000f;
        designation = "Tester";
        company = Company.companyName;
    }

    int hikePercentage = 10;

    @Override
    void raiseSalary() {
        if (!this.salaryUpdated) {
            this.salary += (this.salary / 100f) * hikePercentage;
            this.salaryUpdated = true;
        } else {
            System.out.println("Salary already raised! Please dont ask");
        }
    }

    @Override
    void pf() {
        this.pf = (this.salary / 100f) * 12;
    }

    @Override
    public void access() {
        System.out.println("Tester has access to A block");
    }
}

class Display {
    void displayMainMenu() {
        System.out.println("1) Create");
        System.out.println("2) Display");
        System.out.println("3) Raise salary");
        System.out.println("4) Employee access");
        System.out.println("5) Exit");
    }

    void displaySecondMenu() {
        System.out.println("1) Developer");
        System.out.println("2) Clerk");
        System.out.println("3) Tester");
        System.out.println("4) Manager");
        System.out.println("5) Exit to main menu");
    }
}

public class Demo4 {
    public static void main(String args[]) {
        Developer d = new Developer();
        Tester t = new Tester();
        Manager m = new Manager();
        Clerk c = new Clerk();
        Display disp = new Display();
        int ch1 = 0;

        try {
            do {
                Scanner sc = new Scanner(System.in);

                disp.displayMainMenu();

                System.out.print("Enter your choice : ");
                ch1 = sc.nextInt();

                if (ch1 == 1) { // create
                    int ch2 = 0;

                    disp.displaySecondMenu();

                    System.out.print("Enter your choice : ");
                    ch2 = sc.nextInt();

                    if (ch2 == 1) { // developer
                        d.inputDetails();
                    }
                    if (ch2 == 2) { // Clerk
                        c.inputDetails();
                    }
                    if (ch2 == 3) { // Tester
                        t.inputDetails();
                    }
                    if (ch2 == 4) { // Manager
                        m.inputDetails();
                    }
                    if (ch2 == 5) { // exit to main menu
                        continue;
                    }
                }
                if (ch1 == 2) { // display
                    int ch2 = 0;

                    disp.displaySecondMenu();

                    System.out.print("Enter your choice : ");
                    ch2 = sc.nextInt();

                    if (ch2 == 1) { // developer
                        if (d.id != 0)
                            d.displayDetails();
                        else
                            System.out.println("Developer Not yet registered");
                    }
                    if (ch2 == 2) { // Clerk
                        if (c.id != 0)
                            c.displayDetails();
                        else
                            System.out.println("Clerk Not yet registered");
                    }
                    if (ch2 == 3) { // Tester
                        if (t.id != 0)
                            t.displayDetails();
                        else
                            System.out.println("Tester Not yet registered");
                    }
                    if (ch2 == 4) { // Manager
                        if (m.id != 0)
                            m.displayDetails();
                        else
                            System.out.println("Manager Not yet registered");
                    }
                    if (ch2 == 5) { // exit to main menu
                        continue;
                    }
                }
                if (ch1 == 3) { // raise salary
                    int ch2 = 0;

                    disp.displaySecondMenu();

                    System.out.print("Enter your choice : ");
                    ch2 = sc.nextInt();

                    if (ch2 == 1) { // developer
                        if (d.salary != 0) {
                            d.raiseSalary();
                        } else
                            System.out.println("Developer Not yet registered");
                    }
                    if (ch2 == 2) { // Clerk
                        if (c.salary != 0) {
                            c.raiseSalary();
                        } else
                            System.out.println("Clerk Not yet registered");
                    }
                    if (ch2 == 3) { // Tester
                        if (t.salary != 0) {
                            t.raiseSalary();
                        } else
                            System.out.println("Tester Not yet registered");
                    }
                    if (ch2 == 4) { // Manager
                        if (m.salary != 0) {
                            m.raiseSalary();
                        } else
                            System.out.println("Manager Not yet registered");
                    }
                    if (ch2 == 5) { // exit to main menu
                        continue;
                    }
                }
                if (ch1 == 4) { // Employee access
                    int ch2 = 0;

                    disp.displaySecondMenu();

                    System.out.print("Enter your choice : ");
                    ch2 = sc.nextInt();

                    if (ch2 == 1) { // developer
                        if (d.id != 0) {
                            d.access();
                        } else
                            System.out.println("Developer Not yet registered");
                    }
                    if (ch2 == 2) { // Clerk
                        if (c.id != 0) {
                            c.access();
                        } else
                            System.out.println("Clerk Not yet registered");
                    }
                    if (ch2 == 3) { // Tester
                        if (t.id != 0) {
                            t.access();
                        } else
                            System.out.println("Tester Not yet registered");
                    }
                    if (ch2 == 4) { // Manager
                        if (m.id != 0) {
                            m.access();
                        } else
                            System.out.println("Manager Not yet registered");
                    }
                    if (ch2 == 5) { // exit to main menu
                        continue;
                    }
                }
                if (ch1 == 5) { // exit
                    System.exit(0);
                }
            } while (ch1 != 5);
        } catch (InputMismatchException im) {
            System.out.println("Please input information in correct format");
        } finally {
            System.out.println("All ok");
        }
    }
}
