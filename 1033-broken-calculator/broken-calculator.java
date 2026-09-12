class Solution {
    public int brokenCalc(int start, int target) {
        return solve(start, target);
    }

    int solve(int start, int target) {

        if (target <= start) {
            return start - target;
        }

        if (target % 2 == 0) {
            return 1 + solve(start, target / 2);
        } else {
            return 1 + solve(start, target + 1);
        }
    }
}