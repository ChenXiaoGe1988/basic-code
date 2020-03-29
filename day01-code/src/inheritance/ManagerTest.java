package inheritance;

/**
 * This program demonstrates inheritance
 */
public class ManagerTest {
    public static void main(String[] args) {
        //construct a Manager object
        Manager boss=new Manager("Chen",80000,1998,12,19);
        boss.setBonus(5000);

        Employee[] staff=new Employee[3];

        staff[0]=boss;
        staff[1]=new Employee("Harry",50000,1989,10,1);
        staff[2]=new Employee("Tommy",40000,1990,10,15);

        //print out information about all Employee objects
        for (Employee e:staff)
            System.out.println("name="+e.getName()+",salary="+e.getSalary());
    }
}
