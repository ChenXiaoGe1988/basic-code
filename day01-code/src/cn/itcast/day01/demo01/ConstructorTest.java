package cn.itcast.day01.demo01;

import java.util.*;

public class ConstructorTest {
    public static void main(String[] args) {
        //fill the staff array with three Employee3 objects
        Employee3[] staff=new Employee3[3];

        staff[0]=new Employee3("Harry",40000);
        staff[1]=new Employee3(60000);
        staff[2]=new Employee3();
        //print out information about all Employee3 objects
        for (Employee3 e:staff)
            System.out.println("name="+e.getName()+",id="+e.getId()+",salary="+e.getSalary());
    }
}
class Employee3
{
    private static int nextId;
    private int id;
    private String name="";//instance field initialization
    private double salary;
    //static initialization block
    static
    {
        Random generator=new Random();
        //set nextId to a random number between 0 and 999
        nextId=generator.nextInt(10000);
    }
    {
        id=nextId;
        nextId++;
    }
    public Employee3(String n,double s)
    {
        name=n;
        salary=s;
    }
    public Employee3(double s)
    {
        this("Employee3 #"+nextId,s);
    }
    public Employee3()
    {
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
}