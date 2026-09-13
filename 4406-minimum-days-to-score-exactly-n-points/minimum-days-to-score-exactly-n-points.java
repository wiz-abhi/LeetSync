class Solution {
    int[] memo;

    public int minDays(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        memo[0] = -1;

        return dp(n);
    }

    int dp(int n) {
        if (n == 0)
            return -1;

        if (memo[n] != -1)
            return memo[n];

        int ans = Integer.MAX_VALUE;

        for (int k = 1; k * (k + 1) / 2 <= n; k++) {
            int points = k * (k + 1) / 2;

            ans = Math.min(ans, dp(n - points) + k + 1);
        }

        return memo[n] = ans;
    }
}