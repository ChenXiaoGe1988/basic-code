package interfaces;

/**
 * @author 18374087695
 * 接口和内部类有趣的关系：放到接口中的任何类都是public且static(即接口中的任何类都是嵌套类)
 * 我们甚至可以在接口的内部类中去实现其外围接口
 */
public interface ClassInInterface {
    void howday();
    class Test implements ClassInInterface
    {
        @Override
        public void howday() {
            System.out.println("Howdy!!!");
        }

        public static void main(String[] args) {
            new Test().howday();
        }
    }
}
