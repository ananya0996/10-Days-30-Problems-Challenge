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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode mid = splitListAndGetMid(head);
        TreeNode root = new TreeNode(mid.val);
        if(head != mid) {
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(mid.next);
        }
        
        return root;
    }
    
    private ListNode splitListAndGetMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(prev != null) {
            prev.next = null;
        }
        
        return slow;
    }
}