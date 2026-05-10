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
    public void reorderList(ListNode head) {
        //Find Mid
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the 2nd half
        ListNode reverseNode = reverse(slow.next);
        slow.next = null;

        //Reorder
        slow = head;
        fast = reverseNode;
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    public ListNode reverse(ListNode head){
        
        ListNode prev = head, res = head, tail = head;
        while(tail != null && tail.next != null){
            res = tail.next;
            tail.next = res.next;
            res.next = prev;
            prev = res;
        }
        return res;
    }
}
