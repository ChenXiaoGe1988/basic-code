package cn.itcast.day01.demo01;
import java.util.*;
/**
 *this program demonstrates array manipulation
 * @author Chen
 */

public class LotteryDrawing {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        System.out.println("你需要抽取多少个数值?");
        int k=in.nextInt();

        System.out.println("你需要抽取的最大数值？");
        int n=in.nextInt();

        //将数值 1 2 3 . . . n存入数组numbers中
        int[] numbers=new int[n];
        for(int i=0;i<numbers.length;i++)
            numbers[i]=i+1;

        //存取抽取出来的数值
        int[] result=new int[k];
        for (int i=0;i<result.length;i++)
        {
            //Math.random 方法将返回一个 0 到 1 之间（包含 0、不包含 1 )的随机浮点数。
            //用n乘以这个浮点数,就可以得到从 0 到 n-l 之间的一个随机数。
            int r=(int)(Math.random()*n);

            //将result的第i个元素设置为numbers[r]存放的数值
            result[i]=numbers[r];

            //用数组中的最后一个数值改写number[r]，并将n-1
            numbers[r]=numbers[n-1];
            n--;
        }

        //采用优化的快速排序算法对数组进行排序
        Arrays.sort(result);
        System.out.println("Bet the followong combination. Tt'll make you rich!");
        for(int r:result)
            System.out.println(r);
    }
}
