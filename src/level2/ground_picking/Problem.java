package level2.ground_picking;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        System.out.println(solution.solution(land));    // 16
    }

    static class Solution {
        int solution(int[][] land) {
            int answer = 0;

            for (int i = land.length - 2; i >= 0; i--) {
                findMax(land, i);
            }

            for (int i = 0; i < land[0].length; i++) {
                answer = Math.max(answer, land[0][i]);
            }

            return answer;
        }

        void findMax(int[][] arr, int i) {
            if (i == -1) {
                return;
            }

            for (int j = 0; j < arr[i].length; j++) {
                int max = 0;
                for (int k = 0; k < arr[i].length; k++) {
                    if (k == j) {
                        continue;
                    }
                    max = Math.max(max, arr[i + 1][k]);
                }
                arr[i][j] += max;
            }
        }
    }
}
