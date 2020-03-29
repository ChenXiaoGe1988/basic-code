package cn.itcast.day01.demo01;
import java.time.LocalDate;

/**
 * This program tests the Employee1 class
 * @author 18374087695
 */
public class EmployeeTest {
    public static void main(String[] args) {
        //fill the staff array with three Employee objects
        Employee1[] staff=new Employee1[3];
        staff[0]=new Employee1("Carl",75000,1987,12,15);
        staff[1]=new Employee1("Jia",85000,1999,7,27);
        staff[2]=new Employee1("Chen",95000,1998,12,19);

        //薪水提高5%
        for(Employee1 e:staff)
            e.raiseSalary(5);

        //print out information about all Employee objects
        for(Employee1 e:staff)
            System.out.println("姓名="+e.getName()+"，工资="+e.getSalary()+"，日期="+e.getHireDay());
    }
}
class Employee1{
    private String name;
    private double salary;
    private LocalDate hireDay;
    public Employee1(String name,double salary,int year,int month,int day){
        this.name=name;
        this.salary=salary;
        hireDay=LocalDate.of(year,month,day);
    }
    /*
    以下三个方法是典型的访问器方法，也称域访问器(只返回实例域值)
     */
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }
    //raiseSalary方法将每个雇员的薪水提高百分之多少
    //关键字this表示隐式参数
    public void raiseSalary(double byPercent){
        double raise=this.salary*byPercent/100;
        this.salary+=raise;
    }
}
