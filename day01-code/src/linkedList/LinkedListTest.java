package linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 链表的使用：
 * 1.创建了两个链表a和b,将它们合并在一起
 * 2.从第二个链表中每间隔一个元素删除一个元素
 * 最后测试removeAll方法
 * @author 18374087695
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List<String> a=new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b=new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        //将链表b中的元素合并到链表a

        ListIterator<String> aIter=a.listIterator();
        Iterator<String> bIter=b.iterator();
        /**
         * 迭代器位置示意图：
         * |ACE  |BDFG
         * A|CE  |BDFG
         * AB|CE B|DFG
         * ABC|E B|DFG
         * ABCD|E BD|FG
         * ABCDE| BD|FG
         * ABCDEF| BDF|G
         * ABCDEFG| BDFG|
         */

        while(bIter.hasNext())
            //如果迭代器对象还有多个供访问的元素， 这个方法就返回 true。
        {
            if(aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }
        System.out.println(a);

        //remove every second word from b

        bIter=b.iterator();
        while(bIter.hasNext())
        {
            bIter.next();
            if(bIter.hasNext())
            {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);

        //批量操作：从a中删除b中的所有元素
        a.removeAll(b);
        System.out.println(a);
    }
}
