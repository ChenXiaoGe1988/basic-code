package cn.itcast.day01.demo01;
import java.time.*;
/**
 * 显示当前月的日历，且当期的日用一个*号标记。
 */
public class CalendarTest {
    public static void main(String[] args) {
        //构造日历对象
        LocalDate date=LocalDate.now();
        //获得当前的月和日
        int month=date.getMonthValue();
        int today=date.getDayOfMonth();

        //将date设置为这个月的第一天，并得到这一天为星期几
        //生成当前日期的前一天
        date=date.minusDays(today-1);
        DayOfWeek weekday=date.getDayOfWeek();
        //变量 weekday 设置为 DayOfWeek 类型的对象。我们调用这个对象的 getValue 方法来得
        //到星期几的一个数值。这会得到一个整数，这里遵循国际惯例，即周末是一周的末尾， 星期
        //一就返冋 1， 星期二返回 2, 依此类推。星期日则返回 7。
        int value=weekday.getValue();//1=Monday,...7=Sunday
        //打印表头
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        //打印第一行的缩进
        for(int i=1;i<value;i++)
            System.out.print("    ");
        while(date.getMonthValue()==month)
        {
            System.out.printf("%3d",date.getDayOfMonth());
            if (date.getDayOfMonth()==today)
                System.out.print("*");
            else
                System.out.print(" ");
            //生成当前日期之后1天的日期
            date=date.plusDays(1);
            if(date.getDayOfWeek().getValue()==1)
                System.out.println();
        }
        if (date.getDayOfWeek().getValue()!=1)
            System.out.println();
    }
}
