class Solution {
    public int countArrangement(int n) {
        Set<Integer> st = new HashSet<>();
        return bt(1, n, st);
    }

    int bt(int pos, int n, Set<Integer> st) {

        if (st.size() == n) {
            return 1;
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {

            if (st.contains(i))
                continue;
                
            if (i % pos != 0 && pos % i != 0)
                continue;

            st.add(i);

            count += bt(pos + 1, n, st);

            st.remove(i);
        }

        return count;
    }
}