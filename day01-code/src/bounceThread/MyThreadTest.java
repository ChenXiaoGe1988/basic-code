package bounceThread;

import java.util.concurrent.FutureTask;

public class MyThreadTest
{
    public static void main(String[] args) throws InterruptedException
    {
        long startTime=System.currentTimeMillis();
    //通过主线程启动自己的线程
    //通过继承Thread类
    MyThread1 thread1=new MyThread1();
    thread1.start();

    //通过实现runnable接口
    Thread thread2=new Thread(new MyThread2());
    thread2.start();

    //通过实现callable接口
    MyThread3 th=new MyThread3();
    FutureTask<Integer> result=new FutureTask<>(th);
    new Thread(result).start();
    //注意这里不是直接调用run方法，而是调用线程类Thread的start方法，在Thread方法内部，会调用本地系统方法，最终自动调运自己线程的run方法
    //让主线程睡眠
    Thread.sleep(1000L);
    System.out.println("主线程结束！用时:"+(System.currentTimeMillis()-startTime));
    }
}