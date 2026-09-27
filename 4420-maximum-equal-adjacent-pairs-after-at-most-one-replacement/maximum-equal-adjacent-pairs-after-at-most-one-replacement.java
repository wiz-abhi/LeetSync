class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {

        int base = 0;
        int best = 0;

        Map<String, Integer> freq = new HashMap<>();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                base++;
            } else {
                int a = Math.min(nums[i], nums[i - 1]);
                int b = Math.max(nums[i], nums[i - 1]);

                String key = a + "#" + b;
                int cnt = freq.getOrDefault(key, 0) + 1;

                freq.put(key, cnt);
                best = Math.max(best, cnt);
            }
        }

        return base + best;
    }
}