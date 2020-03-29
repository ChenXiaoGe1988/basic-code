package cn.itcast.day01.demo01;

/**
 * this program demonstrates parameter passing in Java
 * @version 1.00 2020-02-21
 * @author Chen
 */
public class ParamTest {
    public static void main(String[] args) {

        /**
         * Test 1:Method can't modify numeric parameters
         */
        System.out.println("Testing tripleValue:");
        double percent=10;
        System.out.println("Before: percent="+percent);
        tripleValue(percent);
        System.out.println("After: percent="+percent);

        /**
         * Test 2:Method can change the state of object parameters
         */
        System.out.println("\nTesting tripleSalary:");
        Employee2 harry=new Employee2("Harry",50000);
        System.out.println("Before: salary="+harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary="+harry.getSalary());

        /**
         * Test 3:Method can't attach new objects to object parameters
         */
        System.out.println("\nTesting swap:");
        Employee2 a=new Employee2("Alice",70000);
        Employee2 b=new Employee2("Bob",60000);
        System.out.println("Before: a="+a.getName());
        System.out.println("Before: b="+b.getName());
        swap(a,b);
        System.out.println("After: a="+a.getName());
        System.out.println("After: b="+b.getName());

    }

    public static void tripleValue(double x)
    {
        x=3*x;
        System.out.println("End of method: x="+x);
    }

    public static void tripleSalary(Employee2 x){
        x.raiseSalary(200);
        System.out.println("End of Method: salary="+x.getSalary());
    }

    public static void swap(Employee2 x,Employee2 y)
    {
        Employee2 temp=x;
        x=y;
        y=temp;
        System.out.println("End of methid: x="+x.getName());
        System.out.println("End of methid: y="+y.getName());
    }
}
class Employee2{
    private  String name;
    private double salary;
    public Employee2(String n,double s){
        name=n;
        salary=s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
    public void raiseSalary(double byPercent){
        double raise=salary*byPercent /100;
        salary+=raise;
    }
}