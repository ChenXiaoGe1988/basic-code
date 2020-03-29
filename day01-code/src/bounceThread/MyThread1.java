package bounceThread;

/**
 * 通过继承Thread接口创建线程MyThread1
 */
public class MyThread1 extends Thread
{
    @Override
    public void run() {
        for(int i=0;i<30;i++)
        {
            System.out.println("Thread#1==="+i);
            try {
                Thread.sleep(100L);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}