package DataStructure;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public ListNode(int [] nums) {
        this.val = nums[0];
        ListNode now=this;
        for(int i=1;i<nums.length; i++){
            ListNode node=new ListNode(nums[i]);
            now.next=node;
            now=now.next;
        }
    }
}
