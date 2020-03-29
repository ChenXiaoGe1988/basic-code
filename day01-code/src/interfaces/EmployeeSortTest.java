package interfaces;
import java.util.*;
public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff=new Employee[3];

        staff[0]=new Employee("harry",45000);
        staff[1]=new Employee("tony",85000);
        staff[2]=new Employee("Chen",65000);

        Arrays.sort(staff);
        // print out information about all Employee objects
        for(Employee e:staff)
            System.out.println("姓名="+e.getName()+",工资="+e.getSalary());
    }
}
