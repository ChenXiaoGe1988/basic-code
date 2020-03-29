package timer;
/**
 *@version 1.01 2020-02-18
 *@author Chen
 * */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class TimerTest {
    //显示一个包含一条消息和OK按钮的对话框
    //这个对话框将位于其 parent 组件的中央
    //如果 parent 为 mill , 对话框将显示在屏幕的中央
    public static void main(String[] args) {

        ActionListener listener=new TimePrinter();
        //构造一个定时器， 每隔10000毫秒(10s)通告 listener—次
        Timer t=new Timer(10000,listener);
        //启动定时器
        t.start();
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}
class TimePrinter implements ActionListener{
    public void actionPerformed(ActionEvent event){
        System.out.println("At the tone, the time is"+new Date());
        Toolkit.getDefaultToolkit().beep();//发出一声铃响
    }
}
