class Solution {

    String res = "";
    char[] arr = {'a', 'b', 'c'};

    public String getHappyString(int n, int k) {
        backtrack(n, new int[]{k}, new StringBuilder());
        return res;
    }

    void backtrack(int n, int[] k, StringBuilder sb) {

        if (k[0] == 0) return;

        if (sb.length() == n) {
            k[0]--;

            if (k[0] == 0) {
                res = sb.toString();
            }

            return;
        }

        for (char c : arr) {

            if (sb.length() > 0 &&
                sb.charAt(sb.length() - 1) == c) {
                continue;
            }

            sb.append(c);

            backtrack(n, k, sb);

            sb.deleteCharAt(sb.length() - 1);

            if (k[0] == 0) return;
        }
    }
}