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
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length-1);
    }

    public ListNode partition(ListNode[] lists, int s, int e){
        if(s == e) return lists[s];
        if(s < e){
            int q = (s+e)/2;
            ListNode l1 = partition(lists, s, q);
            ListNode l2 = partition(lists, q+1, e);
            return merge(l1, l2);
        }else{
            return null;
        }
    }

    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
