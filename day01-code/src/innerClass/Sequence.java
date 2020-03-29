package innerClass;

import java.util.Objects;

//接口
interface Selector
{
    boolean end();
    Object current();
    void next();
}

/**
 * 利用内部类实现的迭代器模式
 */
//外部类（集合类）+内部类（迭代器类）
public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    //迭代器类:实现了 Selector接口的内部类
    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length)
                ++i;
        }
    }

    //该方法表明：内部了也可以向上转型，这样在外部就隐藏了实现细节。
    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }

}