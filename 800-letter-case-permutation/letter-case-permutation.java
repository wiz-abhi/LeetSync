class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        solve(0, s, res, new StringBuilder());
        return res;
    }

    void solve(int idx, String s, List<String> res, StringBuilder sb) {
        if (idx == s.length()) {
            res.add(sb.toString());
            return;
        }

        char ch = s.charAt(idx);

        if (Character.isDigit(ch)) {
            StringBuilder next = new StringBuilder(sb);
            next.append(ch);
            solve(idx + 1, s, res, next);
        } else {
            StringBuilder upper = new StringBuilder(sb);
            upper.append(Character.toUpperCase(ch));
            solve(idx + 1, s, res, upper);

            StringBuilder lower = new StringBuilder(sb);
            lower.append(Character.toLowerCase(ch));
            solve(idx + 1, s, res, lower);
        }
    }
}