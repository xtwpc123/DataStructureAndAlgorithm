package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @program: DataStructureandAlgorithm
 * @description: 基于链表实现的栈
 * @author: Mr.Wang
 * @create: 2019-02-21-21:03
 **/
public class StackBasedLinkedList {
    private Node top = null;

    public void push(int value){
        Node newNode = new Node(value, null);
        // 判断是否栈空
        if (top == null){
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 我用-1表示栈中没有数据。
     */
    public int pop(){
        if (top == null){
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    public void printAll(){
        Node p = top;
        while(p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public class Node{
        private int data;
        private Node next;

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }
    }

    public static void main(String[] args) {
        StackBasedLinkedList stackBasedLinkedList = new StackBasedLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true){
            stackBasedLinkedList.push(sc.nextInt());
            stackBasedLinkedList.pop();
            stackBasedLinkedList.printAll();
        }
    }
}

