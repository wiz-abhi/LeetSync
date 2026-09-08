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
    Map<Integer,List<int[]> > map=new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root,0,0);
        List<List<Integer>> res=new ArrayList<>();
        for(List<int []> list:map.values()){
            list.sort(
                (a,b)->{
                if(a[0]!=b[0]) return a[0]-b[0];
                return a[1]-b[1];
            }
            );
            List<Integer> temp=new ArrayList<>();
            for(int[] x:list){
                temp.add(x[1]);
            }
            res.add(temp);
        }
        return res;
    }
     void dfs(TreeNode root,int row,int col){
        if(root==null) return;
        map.putIfAbsent(col,new ArrayList<>());
        map.get(col).add(new int[]{row,root.val});
        dfs(root.left,row+1,col-1);
        dfs(root.right,row+1,col+1);
    }
}