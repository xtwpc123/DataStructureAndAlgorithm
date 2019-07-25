package queue;

import com.sun.deploy.util.StringUtils;
import sun.awt.geom.AreaOp;

import java.util.Scanner;

/**
 * @program: DataStructureandAlgorithm
 * @description: 基于链表实现的队列
 * @author: Mr.Wang
 * @create: 2019-03-05-16:50
 **/
public class QueueBaseOnLinkedList {

    /**
     * 队列的队首和队尾
     */
    private Node head = null;
    private Node tail = null;

    /**
     * 入队
     *
     * @param value 入队的元素
     */
    public void enQueue(String value) {
        if (tail == null) {
            Node newNode = new Node(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(value,null);
            tail = tail.next;
        }
    }

    /**
     * 出队
     *
     * @return 出对的元素
     */
    public String dequeue() {
        if (head == null) {
            return null;
        }
        String value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
//        System.out.println();
    }

    /**
     * 链表类
     */
    private static class Node{
        private String data;
        private Node next;

        Node(String data, Node next){
            this.data = data;
            this.next = next;
        }
        Node(){}

        public String getData(){
            return data;
        }

        public Node getNext(){
            return next;
        }
    }

    public static void main(String[] args) {
        QueueBaseOnLinkedList queueBaseOnLinkedList = new QueueBaseOnLinkedList();
//        Scanner sc = new Scanner(System.in);
//        while (true){
//            queueBaseOnLinkedList.enQueue(String.valueOf(sc.nextInt()));
//            queueBaseOnLinkedList.printAll();

//        }
        queueBaseOnLinkedList.enQueue("张三");
        queueBaseOnLinkedList.enQueue("李四");
        queueBaseOnLinkedList.enQueue("王五");
        for (int i = 0; i < 3; i++) {
            System.out.println(queueBaseOnLinkedList.dequeue());
        }
    }
}

