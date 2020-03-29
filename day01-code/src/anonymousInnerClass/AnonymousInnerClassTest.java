package anonymousInnerClass;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        TackingClock clock=new TackingClock();
        clock.start(1000,true);

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}
/**
 *  A clock that prints the time in regular intervals
 */
class TackingClock
{
    /**
     * Starts the clock
     * @param interval the interval between messages(in milliseconds)
     * @param beep true if the clock should beep
     */
    public void start(int interval,boolean beep)
    {
        ActionListener listener=new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone,the time is"+new Date());
                if(beep) Toolkit.getDefaultToolkit().beep();

            }
        };
        Timer t=new Timer(interval,listener);
        t.start();
    }
}
