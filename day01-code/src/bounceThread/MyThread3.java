package bounceThread;

import java.util.concurrent.Callable;

/**
 * 通过实现Callable接口创建线程MyThread3
 */
public class MyThread3 implements Callable<Integer>
{
    @Override
    public Integer call() throws Exception
    {
        int sum=0;
        for(int i=0;i<30;i++)
        {
            System.out.println("thread#3==="+i);
            sum+=i;
        }
        return sum;
    }
}