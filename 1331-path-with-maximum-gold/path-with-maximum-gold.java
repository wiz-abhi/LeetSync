class Solution {
    public int getMaximumGold(int[][] grid) {
        int max = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] != 0) {
                    max = Math.max(max, dfs(grid, r, c));
                }
            }
        }

        return max;
    }

    int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            grid[r][c] == 0) {
            return 0;
        }

        int temp = grid[r][c];
        grid[r][c] = 0;

        int maxGold = 0;

        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = r + drow[i];
            int ncol = c + dcol[i];

            maxGold = Math.max(maxGold, dfs(grid, nrow, ncol));
        }
        grid[r][c] = temp;
        return temp + maxGold;
    }
}