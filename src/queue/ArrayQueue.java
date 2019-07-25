package queue;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * @program: DataStructureandAlgorithm
 * @description: 用数组实现的队列
 * @author: Mr.Wang
 * @create: 2019-02-21-22:04
 **/
public class ArrayQueue {
    /**
     *  数组:items,数组大小: n
     */
    private String[] items;
    private int n;

    /**
     * head表示队头下标，tail表示队尾下标
     */
    private int head = 0;
    private int tail = 0;

    /**
     * 申请一个大小为capacity的数组
     *
     * @param capacity 数组大小
     */
    public ArrayQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

//    /**
//     * 入队
//     * @param item 入队的元素
//     * @return
//     */
//    public boolean enQueue(String item){
//        // 如果tail == n 表示队列已经满了
//        if (tail == n){
//            return false;
//        }
//        items[tail] = item;
//        ++tail;
//        return true;
//    }
    // 在出队时可以不搬移数据，如果没有空闲时间，在入队时再集中触发一次数据的搬移操作
    /**
     *  入队操作，将item放入队尾
     *
     * @param item 入队的元素
     * @return
     */
    public boolean enQueue(String item) {
        //tail == n 表示队列末尾没有空间了
        if (tail == n) {
            // tail == n && head == 0,表示整个队列都占满了
            if (head == 0) {
                return false;
            }
            // 数据搬移
            for (int i = head; i <tail; ++i) {
                items[i-head] = items[i];
            }
            // 搬移完之后重新更新head和tail
            tail -= head;
            head = 0;
        }

        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public String deQueue(){
        // 如果head == tail 表示队列为空
        if (head == tail){
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }
}
