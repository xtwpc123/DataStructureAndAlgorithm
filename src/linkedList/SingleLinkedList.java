package linkedList;

/**
 * @program: DataStructureandAlgorithm
 * @description: 单向链表的具体实现
 * @author: Mr.Wang
 * @create: 2019-01-24-19:28
 **/
public class SingleLinkedList {

    /**
     * 链表节点的个数
     */
    private int size;

    /**
     * 头节点
     */
    private Node head;

    /**
     * 链表的每个节点类
     */
    private class Node{

        // 每个节点的数据
        private Object data;

        // 每个节点指向下一个节点的连接
        private Node next;

        public Node(Object data){
            this.data = data;
        }
    }
}
