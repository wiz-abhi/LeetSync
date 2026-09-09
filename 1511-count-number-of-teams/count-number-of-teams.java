class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int[][] dp = new int[n][2];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int leftSmall = count(i, rating, dp, 0);
            int leftLarge = count(i, rating, dp, 1);

            int rightSmall = 0;
            int rightLarge = 0;

            for (int j = i + 1; j < n; j++) {
                if (rating[j] < rating[i])
                    rightSmall++;
                else
                    rightLarge++;
            }

            ans += leftSmall * rightLarge;
            ans += leftLarge * rightSmall;
        }

        return ans;
    }

    int count(int i, int[] rating, int[][] dp, int type) {
        if (dp[i][type] != 0)
            return dp[i][type];

        int count = 0;

        for (int j = 0; j < i; j++) {
            if (type == 0 && rating[j] < rating[i])
                count++;
            else if (type == 1 && rating[j] > rating[i])
                count++;
        }

        return dp[i][type] = count;
    }
}