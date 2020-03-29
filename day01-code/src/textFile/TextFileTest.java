package textFile;

import inheritance.Employee;
import java.io.*;
import java.time.*;
import java.util.*;

/**
 * @author 18374087695
 * 需求：将一个Employee记录数组存储成一个文本文件,其中每条记录保存成单独一行
 * 实例字段彼此之间用分隔符“|”分离开
 */
public class TextFileTest {
    public static void main(String[] args) throws IOException {
        Employee[] staff=new Employee[3];

        staff[0]=new Employee("Chen",10000,1998,12,19);
        staff[1]=new Employee("Harry",8000,1989,10,1);
        staff[2]=new Employee("Tony",90000,1990,3,15);

        //以文本格式打印写入的数据
        try(PrintWriter out=new PrintWriter("D:/IdeaProjects/basic-code/day01-code/gutenberg/employee.txt","UTF-8"))
        {
            writeData(staff,out);
        }

        //retrieve all records into a new array
        try(Scanner in=new Scanner(new FileInputStream("D:/IdeaProjects/basic-code/day01-code/gutenberg/employee.txt"),"UTF-8"))
        {
            Employee[] newStaff=readData(in);

            //print the newly read employee records
            for(Employee e:newStaff)
                System.out.println(e);
        }
    }


    private static void writeData(Employee[] employees, PrintWriter out) throws IOException
    {
        //写入该数组的长度
        out.println(employees.length);
        //读出每条记录
        for(Employee e:employees)
            writeEmployee(out,e);
    }


    private static Employee[] readData(Scanner in)
    {
        //读入该数组的长度
        int n=in.nextInt();
        in.nextLine();//consume newLine
        //读入每条记录
        Employee[] employees=new Employee[n];
        for(int i=0;i<n;i++)
        {
            employees[i]=readEmployee(in);
        }
        return employees;
    }

    //写出记录
    public static void writeEmployee(PrintWriter out, Employee e)
    {
        out.println(e.getName()+"|"+e.getSalary()+"|"+e.getHireDay());
    }

    /**
     * 读入记录，每次读入一行，然后分离所有字段
     * 使用一个扫描器来读入每一行
     *然后用String.split方法将这一行断成一组标记
     */
    public static Employee readEmployee(Scanner in)
    {
        String line=in.nextLine();
        String[] tokens=line.split("\\|");
        String name=tokens[0];
        double salary=Double.parseDouble(tokens[1]);
        LocalDate hireData=LocalDate.parse(tokens[2]);
        int year=hireData.getYear();
        int month=hireData.getMonthValue();
        int day=hireData.getDayOfMonth();
        return new Employee(name,salary,year,month,day);
    }
}