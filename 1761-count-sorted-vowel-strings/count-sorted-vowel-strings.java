class Solution {
    public int countVowelStrings(int n) {
        char[] arr = {'a', 'e', 'i', 'o', 'u'};
        return dp(0, n, arr, new StringBuilder());
    }

    int dp(int idx, int n, char[] arr, StringBuilder sb) {
        if (sb.length() == n) return 1;

        int count = 0;

        for (int i = idx; i < 5; i++) {
            sb.append(arr[i]);

            count += dp(i, n, arr, sb);

            sb.deleteCharAt(sb.length() - 1);
        }

        return count;
    }
}