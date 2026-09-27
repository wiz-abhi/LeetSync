class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int index = 0;

        TreeMap<Integer, Integer> mp = new TreeMap<>();

        for (int x : nums) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        while (index < nums.length) {
            for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
                if (entry.getValue() > 0) {
                    ans[index++] = entry.getKey();
                    entry.setValue(entry.getValue() - 1);
                }
            }
        }

        return ans;
    }
}