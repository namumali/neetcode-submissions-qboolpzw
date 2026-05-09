/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return  null;
        ListNode prev = head, curr = head, res = head;
        while(head != null && head.next != null){
            res = curr.next;
            curr.next = res.next;
            res.next = prev;
            prev = res;
        }
        return res;
    }
}
