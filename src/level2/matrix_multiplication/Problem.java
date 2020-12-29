package level2.matrix_multiplication;

import java.util.Arrays;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};

        System.out.println(Arrays.deepToString(solution.solution(arr1, arr2)));
    }

    static class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int n = arr1.length;
            int m = arr2[0].length;
            int[][] answer = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < arr1[0].length; k++) {
                        answer[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }
            return answer;
        }
    }
}
