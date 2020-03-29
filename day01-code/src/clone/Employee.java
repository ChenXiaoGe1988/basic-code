package clone;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable
{
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name ,double salary)
    {
        this.name=name;
        this.salary=salary;
        hireDay=new Date();
    }
    //声明异常CloneNotSupportedException
    //虽然Employee和Date类实现了这个Cloneable接口，不会抛出异常
    //但是编译器不知道，所以声明
    public Employee clone() throws CloneNotSupportedException
    {
        //call Object.clone()
        Employee cloned = (Employee) super.clone();

        // clone mutable fields
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }
    public void setHireDay(int year,int month,int day)
    {
        Date newHireDay=new GregorianCalendar(year,month-1,day).getTime();
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent)
    {
        double raise=salary*byPercent/100;
        salary+=raise;
    }
    public String toString()
    {
        return "Employee[姓名="+name+",工资="+salary+",日期="+hireDay+"]";
    }
}
