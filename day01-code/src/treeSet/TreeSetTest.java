package treeSet;
import  java.util.*;

/**
 * 该程序创建了两个Item对象的树集。
 * 第一个按照部件编号排序，这是Item对象的默认顺序
 * 第二个通过使用一个定制的比较器来按照描述信息排序
 */
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> parts=new TreeSet<>();
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Widget",4562));
        parts.add(new Item("Modem",9912));
        System.out.println(parts);

        NavigableSet<Item> sortByDescription=new TreeSet<>(Comparator.comparing(Item::getDescription));
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);

    }
}
