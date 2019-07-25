package linkedList;

/**
 * @program: DataStructureandAlgorithm
 * @description: 输入一个链表，输出该链表中倒数第k个结点
 * @author: Mr.Wang
 * @create: 2019-02-12-16:17
 **/
public class FindkthToTail {
    public static ListNode findKthToTail(ListNode head, int k) {
//        ListNode pre = null, p = null;
//        //两个指针都指向头结点
//        p = head;
//        pre = head;
//        //记录k值
//        int a = k;
//        //记录节点的个数
//        int count = 0;
//        //p指针先跑，并且记录节点数，当p指针跑了k-1个节点后，pre指针开始跑，
//        //当p指针跑到最后时，pre所指指针就是倒数第k个节点
//        while (p != null) {
//            p = p.getNext();
//            count++;
//            if (k < 1) {
//                pre = pre.getNext();
//            }
//            k--;
//        }
//        //如果节点个数小于所求的倒数第k个节点，则返回空
//        if (count < a) {
//            return null;
//        }
//        return pre;

        if(head == null || k <= 0){
            return null;
        }
        //直接遍历
        ListNode p = head;
        ListNode q = head;
        for(int i = 0; i < k-1; i++){
            if(q == null){
                return null;
            }
            q = q.next;
        }
        if(q == null){
            return null;
        }
        while(q.next != null){
            p = p.next;
            q = q.next;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        ListNode p = findKthToTail(head,5);
        System.out.println(p.getVal());

    }
}

/**
 * 链表类
 */
class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
