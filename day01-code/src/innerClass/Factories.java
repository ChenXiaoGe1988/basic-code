package innerClass;

/**
 * @author 18374087695
 * 匿名内部类+工厂模式
 * 总结：为什么需要内部类？
 * 内部类可以独立地继承自一个接口或者类而无需关注其外围类的实现，使得扩展类或者接口更加灵活。控制的粒度更细。
 */
//Service接口
    interface Service{
        void method1();
        void method2();
}
//ServiceFactory接口
interface ServiceFactory
{
    Service getService();
}
//Service接口的实现
class Implementation1 implements Service
{
    private Implementation1(){}//构造方法私有
    public void method1()
    {
        System.out.println("Implementation1 method1");
    }
    public void method2()
    {
        System.out.println("Implementation1 method2");
    }
    public static ServiceFactory factory=
            new ServiceFactory() {
        public Service getService(){
            return new Implementation1();
        }
    };
}

class Implementation2 implements Service
{
    private Implementation2(){}//构造方法私有
    public void method1()
    {
        System.out.println("Implementation2 method1");
    }
    public void method2()
    {
        System.out.println("Implementation2 method2");
    }
    public static ServiceFactory factory=
            new ServiceFactory() {
                public Service getService(){
                    return new Implementation2();
                }
            };
}
//客户端代码
public class Factories
{
    public static void serviceConsumer(ServiceFactory fact)
    {
        Service s=fact.getService();
        s.method1();
        s.method2();
    }
    public static void main(String[] args) {
        serviceConsumer(Implementation1.factory);
        serviceConsumer(Implementation2.factory);
    }
}