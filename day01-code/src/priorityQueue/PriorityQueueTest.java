package priorityQueue;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * 任务调度
 * 需求：
 * 1.每一个任务都有一个优先级，任务以随机顺序添加到队列中
 * 2.每当启动一个新的任务时，都将优先级最高的任务(即优先级数最小的元素如：（1815-12-10）)从队列中删除
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq=new PriorityQueue<>();
        pq.add(LocalDate.of(1906,12,9));
        pq.add(LocalDate.of(1815,12,10));
        pq.add(LocalDate.of(1903,12,3));
        pq.add(LocalDate.of(1910,6,22));

        System.out.println("Iterating over elements...");
        for (LocalDate date:pq)
            System.out.println(date);
        System.out.println("Removing elements...");
        while(!pq.isEmpty())
            System.out.println(pq.remove());
    }
}
