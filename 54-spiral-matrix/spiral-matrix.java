import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> ans = new ArrayList<>();

        while (top <= bottom && left <= right) {

            // Left -> Right
            for (int col = left; col <= right; col++) {
                ans.add(matrix[top][col]);
            }
            top++;

            // Top -> Bottom
            for (int row = top; row <= bottom; row++) {
                ans.add(matrix[row][right]);
            }
            right--;

            // Right -> Left
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    ans.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // Bottom -> Top
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    ans.add(matrix[row][left]);
                }
                left++;
            }
        }

        return ans;
    }
}