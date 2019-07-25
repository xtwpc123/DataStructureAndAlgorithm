package linkedList;

/**
 * @program: DataStructureandAlgorithm
 * @description: 单链表反转
 * @author: Mr.Wang
 * @create: 2019-02-12-14:27
 **/
public class ReverseSingleLinkedList {

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的链表
        Node h = head;
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
        // 调用反转方法
        head = Reverse1(head);
//            head = reverse2(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }

        /**
         * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
         */
        public static Node reverse2 (Node head){
            if (head == null) {
                return null;
            }
            // 上一结点
            Node pre = head;
            // 当前结点
            Node cur = head.getNext();
            // 临时结点，用于保存当前结点的指针域（即下一结点）
            Node tmp;
            // 当前结点为null，说明位于尾结点
            while (cur != null) {
                tmp = cur.getNext();
                // 反转指针域的指向
                cur.setNext(pre);

                // 指针往下移动
                pre = cur;
                cur = tmp;
            }
            // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
            head.setNext(null);
            return pre;
        }

        /**
         * 递归，在反转当前节点之前先反转后续节点
         */
        private static Node Reverse1(Node head) {
            // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
            if (head == null || head.getNext() == null) {
                // 若为空链或者当前结点在尾结点，则直接还回
                return head;
            } else {
                // 先反转后续节点head.getNext()
                Node reHead = Reverse1(head.getNext());
                // 将当前结点的指针域指向前一结点
                head.getNext().setNext(head);
                // 前一结点的指针域令为null;
                head.setNext(null);
                // 反转后新链表的头结点
                return reHead;
            }
        }
    }

    class Node {
        /**
         * 数据域
         */
        private int Data;
        /**
         * 指针域
         */
        private Node Next;

        public Node(int Data) {
            // super();
            this.Data = Data;
        }

        public int getData() {
            return Data;
        }

        public void setData(int Data) {
            this.Data = Data;
        }

        public Node getNext() {
            return Next;
        }

        public void setNext(Node Next) {
            this.Next = Next;
        }
    }

