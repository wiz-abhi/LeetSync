class Solution {

    class NodeInfo implements Comparable<NodeInfo> {
        int row;
        int col;
        int val;

        NodeInfo(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public int compareTo(NodeInfo other) {

            if (this.col != other.col) {
                return this.col - other.col;
            }
            if (this.row != other.row) {
                return this.row - other.row;
            }

            return this.val - other.val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<NodeInfo> nodes = new ArrayList<>();

        dfs(root, 0, 0, nodes);

        // Sort by col -> row -> value
        Collections.sort(nodes);

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> curr = null;
        int prevCol = Integer.MIN_VALUE;

        for (NodeInfo node : nodes) {

            if (node.col != prevCol) {
                curr = new ArrayList<>();
                ans.add(curr);
                prevCol = node.col;
            }

            curr.add(node.val);
        }

        return ans;
    }

    void dfs(TreeNode root, int row, int col, List<NodeInfo> nodes) {

        if (root == null) {
            return;
        }

        nodes.add(new NodeInfo(row, col, root.val));

        dfs(root.left, row + 1, col - 1, nodes);
        dfs(root.right, row + 1, col + 1, nodes);
    }
}