package bounceThread;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 无论何时点击Start按钮，球会移入一个新线程
 */
public class BounceThread {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new BounceFrame();
            frame.setTitle("BounceThread");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

    }
}
class BounceFrame extends JFrame
{
    private BallComponent comp;
    public static final int STEPS=1000;
    public static final int DELAY=5;

    public BounceFrame()
    {
        comp=new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel=new JPanel();
        addButton(buttonPanel,"Start",event->addBall());
        addButton(buttonPanel,"Close",event->System.exit(0));
        add(buttonPanel,BorderLayout.SOUTH);
        pack();
    }
    public void addButton(Container c, String title, ActionListener listener)
    {
        JButton button=new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addBall()
    {
        Ball ball=new Ball();
        comp.add(ball);
        /**
         * 由于Runnable是一个函数式接口，可以用lambda表达式建立一个实例
         * 要想将弹跳球代码放在一个独立的线程中，只需要实现一个类BallRunnable
         * 然后，将动画代码放在run方法中即可
         */
        Runnable r=()->{
            try
            {
                for(int i=1;i<=STEPS;i++)
                {
                    ball.move(comp.getBounds());
                    comp.repaint();
                    //需要捕获sleep方法可能抛出的异常InterruptedException
                    Thread.sleep(DELAY);
                }
            }
            catch(InterruptedException e)
            {
            }
        };
        /**
         * Thread(Runnable target)
         * 构造一个新线程，用于调用给定目标的run()方法
         */
        Thread t=new Thread(r);
        //启动线程(将引发调用run()方法，这个方法将立即返回，并且新线程将并发运行
        t.start();
    }
}