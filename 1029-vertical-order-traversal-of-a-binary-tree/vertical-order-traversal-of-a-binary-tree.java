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

            // 1. Column: left -> right
            if (this.col != other.col) {
                return this.col - other.col;
            }

            // 2. Row: top -> bottom
            if (this.row != other.row) {
                return this.row - other.row;
            }

            // 3. Same row + column: smaller value first
            return this.val - other.val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<NodeInfo> nodes = new ArrayList<>();

        dfs(root, 0, 0, nodes);

        // Sort by col -> row -> value
        Collections.sort(nodes);

        List<List<Integer>> ans = new ArrayList<>();

        int prevCol = Integer.MIN_VALUE;

        for (NodeInfo node : nodes) {

            // New column
            if (node.col != prevCol) {
                ans.add(new ArrayList<>());
                prevCol = node.col;
            }

            ans.get(ans.size() - 1).add(node.val);
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