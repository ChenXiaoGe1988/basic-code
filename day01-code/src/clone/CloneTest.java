package clone;

public class CloneTest {
    public static void main(String[] args) {
        try
        {
            Employee original=new Employee("John Q.Public",5000);
            original.setHireDay(2020,2,18);
            Employee copy=original.clone();
            copy.raiseSalary(20);//工资上涨20%
            copy.setHireDay(2020,2,19);
            System.out.println("original="+original);
            System.out.println("copy="+copy);
        }
        catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
