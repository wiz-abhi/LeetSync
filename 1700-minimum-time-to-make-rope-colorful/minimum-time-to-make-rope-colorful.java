class Solution {
    public int minCost(String colors, int[] time) {
        int score = 0;
        int min = time[0];

        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i - 1) == colors.charAt(i)) {

                if (min < time[i]) {
                    score += min;
                    min = time[i];
                } else {
                    score += time[i];
                }

            } else {
                min = time[i];
            }
        }

        return score;
    }
}