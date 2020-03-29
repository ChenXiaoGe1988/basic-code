package bounceThread;

/**
 * 通过实现Runnable接口创建线程MyThread2
 */
public class MyThread2 implements Runnable
{
    @Override
    public void run() {
        for(int i=0;i<30;i++)
        {
            System.out.println("thread#2==="+i);
            try{
                Thread.sleep(100L);

            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}