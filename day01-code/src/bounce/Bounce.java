package bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 展示一个动画球
 * @author 18374087695
 */
public class Bounce {
    public static void main(String[] args) {
        //所有的Swing组件必须由事件分派线程进行配置
        //线程将鼠标点击和按键控制转移到用户接口组件
        EventQueue.invokeLater(()->
        {
            JFrame frame=new BounceFrame();
            //关闭这个框架时的响应动作：简单退出
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //显示框架
            frame.setVisible(true);
        });

    }
}

/**
 * 使用组件构造框架，以显示弹起和开始以及关闭按钮
 */
class BounceFrame extends JFrame
{
    private BallComponent comp;
    //定义球弹跳的次数1000次
    public static final int STEPS=1000;
    public static final int DELAY=3;

    public BounceFrame()
    {
        //框架标题
        setTitle("Bounce");
        comp=new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel=new JPanel();
        addButton(buttonPanel,"Start",event->addBall());
        addButton(buttonPanel,"Close",event->System.exit(0));
        add(buttonPanel,BorderLayout.SOUTH);
        /**
         * 在框架中填入一个或者多个组件时
         * 如果只想知道他们的首选大小，可以调用pack方法，而不是setSize方法
         */
        pack();
    }

    /**
     * 将按钮添加到容器中
     * @param c 容器
     * @param title 按钮标题
     * @param listener 按钮的动作监听器
     */
    public  void addButton(Container c, String title, ActionListener listener)
    {
        JButton button=new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    /**
     * 添加一个弹跳球到面板，使它弹跳1000次
     */
    public void addBall()
    {
        try
        {
            Ball ball=new Ball();
            comp.add(ball);
            for(int i=1;i<=STEPS;i++)
            {
                ball.move(comp.getBounds());
                comp.paint(comp.getGraphics());
                Thread.sleep(DELAY);
            }
        }
        catch(InterruptedException e)
        {

        }
    }
}