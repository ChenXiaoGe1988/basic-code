package cn.itcast.day01.demo01;
import java.util.*;
/**
 * 用来计算抽奖中奖的概率
 */

public class LotteryOdds {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("How much numbers do you need to draw?");
        int k=in.nextInt();

        System.out.println("What is the highest number you can draw?");
        int n=in.nextInt();

        /**
         *compute binomial coefficient n*(n-1)*(n-2)...*(n-K+1)(1*2*3*...*k)
         */

        int lotteryOdds=1;
        for(int i=1;i<=k;i++)
            lotteryOdds=lotteryOdds*(n-i+1)/i;
        System.out.println("You odds are 1 in "+lotteryOdds+".Good luck!");

    }
}
