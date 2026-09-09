class Solution {

    boolean[] vis = new boolean[10];
    String res = "";

    public String smallestNumber(String pattern) {
        backtrack(0, pattern, new StringBuilder());
        return res;
    }

    boolean backtrack(int idx, String pattern, StringBuilder sb) {

        if (sb.length() == pattern.length() + 1) {
            res = sb.toString();
            return true;
        }

        for (int i = 1; i <= 9; i++) {

            if (vis[i]) continue;

            if (idx > 0) {
                int prev = sb.charAt(sb.length() - 1) - '0';

                if (pattern.charAt(idx - 1) == 'I' && i <= prev)
                    continue;

                if (pattern.charAt(idx - 1) == 'D' && i >= prev)
                    continue;
            }

            vis[i] = true;
            sb.append(i);

            if (backtrack(idx + 1, pattern, sb))
                return true;

            sb.deleteCharAt(sb.length() - 1);
            vis[i] = false;
        }

        return false;
    }
}