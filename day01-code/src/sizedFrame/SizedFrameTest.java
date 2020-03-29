package sizedFrame;

import javax.swing.*;
import java.awt.*;

public class SizedFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->
                {
                    JFrame frame=new SizedFrame();
                    frame.setTitle("SizedFrame");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);

                }
        );
    }
}
class SizedFrame extends JFrame
{
    public SizedFrame()
    {
        //get screen dimensions
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenHeight=screenSize.height;
        int screenWidth=screenSize.width;

        setSize(screenWidth/2,screenHeight/2);
        setLocationByPlatform(true);

        //set frame icon
        Image img=new ImageIcon("logo.gif").getImage();
        setIconImage(img);
    }
}