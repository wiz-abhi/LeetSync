class Solution {
    Integer[][] dp;

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new Integer[n][n];

        return dp(piles, 0, n - 1) > 0;
    }

    int dp(int[] piles, int i, int j) {

        if (i == j) {
            return piles[i];
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int takeFirst = piles[i] - dp(piles, i + 1, j);
        int takeLast = piles[j] - dp(piles, i, j - 1);

        return dp[i][j] = Math.max(takeFirst, takeLast);
    }
}