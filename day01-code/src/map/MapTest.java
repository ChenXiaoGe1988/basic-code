package map;

import java.util.*;
public class MapTest {
    public static void main(String[] args) {
        Map<String,Employee> staff=new HashMap<>();
        staff.put("144-25-5654",new Employee("Amy Lee"));
        staff.put("567-24-2456",new Employee("Harry Hacker"));
        staff.put("157-62-7935",new Employee("Gary Cooper"));
        staff.put("456-62-5527",new Employee("Francesca Cruz"));

        //打印所有的条目
        System.out.println(staff);
        //删除一个条目
        staff.remove("567-24-2456");
        //替代一个条目
        staff.put("456-62-5527",new Employee("Francesca Miller"));
        //获取key对应的值
        System.out.println(staff.get("157-62-7935"));
        //迭代处理
        staff.forEach((k,v)->
        System.out.println("key="+k+",value="+v));
    }
}
class Employee
{
    private String name;
    public Employee(String name)
    {
        this.name=name;
    }

    @Override
    public String toString() {
        return "Employee[name=" + name +"]";
    }
}
