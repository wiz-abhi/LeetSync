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
    public int goodNodes(TreeNode root) {
        TreeNode temp = root;
        return solve(temp,root);

    }

    int solve(TreeNode t,TreeNode root){
        if(t == null) return 0;
        if(t.val>=root.val){
        return 1+solve(t.left,t) + solve(t.right,t);  
        }
        else 
        return solve(t.left,root) + solve(t.right,root);

    }
}