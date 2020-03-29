package innerClass;

/**
 * @author 18374087695
 * 细节：虽然Java中一个接口可以继承多个接口，但是一个类是不能继承多个类的，
 * 要想完成该目标，可以使用内部类来扩充多重继承机制。
 */
class D{}//普通类
abstract class E{}//抽象类
class Z extends D{//外围类显式地完成一部分继承
    E make(){
        return new E(){};//内部类隐式地完成一部分继承
    }
}
public class MultiImplementation {
    static void takesD(D d){}
    static void takesE(E e){}

    public static void main(String[] args) {
        Z z=new Z();
        takesD(z);
        takesE(z.make());
    }
}
