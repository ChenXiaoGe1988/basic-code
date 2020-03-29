package bounce;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * 在矩形的边缘来回移动和弹回的球
 */
public class Ball {
    //球的横尺寸
    private static final int XSIZE=15;
    //球的纵尺寸
    private static final int YSIZE=15;
    //球位置的横坐标 (0,0)表示框架左上角位置
    private double x=0;
    //球位置的纵坐标
    private double y=0;
    private double dx=1;
    private double dy=1;

    /**
     * 将球移动到下一个位置，如果碰到边界，则反转方向
     */
    public void move(Rectangle2D bounds) {
        x += dx;
        y += dy;
        if (x < bounds.getMinX()) {
            x = bounds.getMinX();
            dx = -dx;
        }
        if (x + XSIZE >= bounds.getMaxX()) {
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }
        if (y < bounds.getMinY()) {
            y = bounds.getMinY();
            dy = -dy;
        }
        if (y + YSIZE >= bounds.getMaxY()) {
            y = bounds.getMaxY() - YSIZE;
            dy = -dy;
        }
    }
        /**
         * 获取当前位置的球的形状
         * Ellipse2D是描述椭圆的类
         * Rectangle2D是描述矩形的类
         * Line2D是描述直线的类
         */
        public Ellipse2D getShape()
        {
            //对于椭圆，左上角的x和y坐标、宽和高都表示外接矩形
            //利用给定的左上角、宽和高的外接矩形，构造一个椭圆或者圆(x=y)
            return new Ellipse2D.Double(x,y,XSIZE,YSIZE);
        }
    }

