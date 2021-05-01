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
    
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        inOrderTraversal(root);
        
        int swap = first.val;
        first.val = second.val;
        second.val = swap;
    }
    
    private void inOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        
        inOrderTraversal(root.left);
        
        if(first == null && prev != null && prev.val >= root.val) {
            first = prev;
        }
        
        if(first != null && prev != null && prev.val > root.val) {
            second = root;
        }
        
        prev = root;
        
        inOrderTraversal(root.right);
    }
    
}