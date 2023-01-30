import DataStructure.ListNode;


//class ListNode {
//    int val;
//     ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

/**
 * 1669. 合并两个链表
 * 假头还是非常好用的东西，
 * 1ms 100%
 */
public class class1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int index = -1  ;
        ListNode head1=null,tail1=null;
        //加一个假头，以便切割
        ListNode fakeHead = new ListNode(0,list1);
        ListNode node1 = fakeHead;
        while(node1!=null){
            if(a-1==index){
                head1 = node1;
            }
            if(b==index){
                tail1 = node1.next;
                break;
            }
            node1 = node1.next;
        }
        //第一条链表接上第二条的头
        head1.next=list2;
        //找到list2的尾巴
        while(head1.next!=null){
            head1 = head1.next;
        }
        head1.next = tail1;
        return fakeHead.next;
    }
}
