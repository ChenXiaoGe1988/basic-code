package bounce;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *画出球的组件BallComponent
 * 这里扩展的是JPanel，也可以扩展JComponent
 * JPanel不同之处在于：面板不透明(意味着需要在面板边界内绘制所有的像素)
 * 实现办法：在每个面板子类的paintComponent方法中调用super.paintComponent来用背景绘制面板
 */
public class BallComponent extends JPanel {
    //定义组件的首选宽度和高度(即组件有多大)
    private static final int DEFAULT_WIDTH=450;
    private static final int DEFAULT_HEIGHT=350;

    private java.util.List<Ball> balls=new ArrayList<>();

    /**
     * 将ball添加到组件中
     * @param b the ball add
     */
    public void add(Ball b)
    {
        balls.add(b);
    }

    /**
     * @param g 一个Graphics类型的参数，保存着用于绘制图形和文本的设置
     * 在JAVA中，所有的绘制都必须使用Graphics对象(度量单位是像素，坐标(0,0)指出所绘制组件表面的左上角)
     */
    public void paintComponent(Graphics g)
    {
        //用背景色绘制面板
        super.paintComponent(g);
        /**
         * Graphics2D类是Graphics的子类
         * paintComponent方法自动地获得Graphics2D类对象，我们只需要进行一次类型转换就行了
         */
        Graphics2D g2=(Graphics2D)g;
        for (Ball b:balls)
        {
            g2.fill(b.getShape());
        }
    }

    /**
     * 最后，组件要告诉用户它有多大，覆盖getPreferredSize方法
     * @return 返回一个有首选宽度和高度的Dimension类对象
     */
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}
