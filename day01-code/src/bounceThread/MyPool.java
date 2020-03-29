package bounceThread;

import java.util.concurrent.*;

/**
 * 定义单例线程池
 */
public class MyPool {
    private static MyPool myPool = null;
    //单例线程池有两种具体的线程池
    private ThreadPoolExecutor threadPool = null;
    private ScheduledThreadPoolExecutor scheduledPool = null;

    public ThreadPoolExecutor getThreadPool() {
        return threadPool;
    }

    public ScheduledThreadPoolExecutor getScheduledThreadPool() {
        return scheduledPool;
    }

    //设置线程池的各个参数大小
    private int corePoolSize = 10;//池中所保存的线程数，包括空闲线程
    private int maximunPoolSize = 20;//池中允许的最大线程数
    private long keepAliveTime = 3;//当线程数大于核心时，此为终止前多余的空闲进程等待新任务的最长时间
    private int scheduledPoolSize = 10;

    private static synchronized void create() {
        if (myPool == null)
            myPool = new MyPool();
    }

    private static MyPool getInstance() {
        if (myPool == null)
            create();
        return myPool;
    }

    public MyPool() {
        //实例化线程池，这里使用的LinkedBlockingQueue作为workQueue(任务队列),使用
        this.threadPool = new ThreadPoolExecutor(corePoolSize, maximunPoolSize,
                keepAliveTime, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadPoolExecutor.CallerRunsPolicy());//不在新线程中执行任务，而是由调用者所在的线程来执行
        //实例化计划任务池
        this.scheduledPool = new ScheduledThreadPoolExecutor(scheduledPoolSize);
    }

    public void testThreadPool() {
        ThreadPoolExecutor pool1 = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        pool1.execute(() -> System.out.println("快捷线程池中的线程！"));

        ThreadPoolExecutor pool2 = MyPool.getInstance().getThreadPool();
        pool2.execute(() -> {
            System.out.println("pool2普通线程池中的线程！");
            try {
                Thread.sleep(30 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("pool2 poolSize:" + pool2.getPoolSize());
        System.out.println("pool2 corePoolSize:" + pool2.getCorePoolSize());
        System.out.println("pool2 largestPoolSize:" + pool2.getLargestPoolSize());
        System.out.println("pool2 MaximumPoolSize:" + pool2.getMaximumPoolSize());

        ScheduledThreadPoolExecutor pool3 = MyPool.getInstance().getScheduledThreadPool();
        pool3.scheduleAtFixedRate(() -> System.out.println("计划任务线程池中的线程！"), 0, 5000, TimeUnit.MILLISECONDS);
    }
}