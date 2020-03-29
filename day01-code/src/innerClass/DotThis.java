package innerClass;

/**
 * @author 18374087695
 * .this用于在内部类中生成对其外部类对象的引用
 */
public class DotThis {
    void f()
    {
        System.out.println("DotThis.f()");
    }

    public class Inner {//内部类
        public DotThis outer(){//返回外部类对象的引用
            return DotThis.this;//若直接返回this,那指的便是内部类自身
        }
    }
    public Inner inner(){return new Inner();}

    public static void main(String[] args) {
        DotThis dt=new DotThis();
        DotThis.Inner dti=dt.inner();
        dti.outer().f();//输出DotThis.f()
    }
}
