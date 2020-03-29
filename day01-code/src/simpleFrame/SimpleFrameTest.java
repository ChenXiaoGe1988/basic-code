package simpleFrame;
/**
 * javax表示扩展包
 */

import javax.swing.*;

import java.awt.*;

public class SimpleFrameTest {
    public static void main(String[] args) {
        /**
         * 所有的 Swing 组件必须由事件分派线程(event dispatch thread)进行配置
         * 线程将鼠标点击和按键控制转移到用户接口组件
         */
        EventQueue.invokeLater(()->
        {
            SimpleFrame frame=new SimpleFrame();
            //定义一个用户关闭这个框架时的响应动作。
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //调用框架的setVisible方法来显示框架
            frame.setVisible(true);
        });

    }
}
class SimpleFrame extends JFrame
{
    //框架大小设置为300x200像素
    private  static  final int DEFAULT_WIDTH=300;
    private  static  final int DEFAULT_HEIGHT=200;

    public SimpleFrame()
    {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}