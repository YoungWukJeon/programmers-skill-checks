package level2.find_largest_square;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        System.out.println(solution.solution(board));
    }

    static class Solution {
        public int solution(int[][] board) {
            for (int i = 1; i < board.length; i++) {
                for (int j = 1; j < board[i].length; j++) {
                    if (board[i][j] > 0) {
                        board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                    }
                }
            }
            int answer = 0;
            for (int[] ints : board) {
                int max = ints[0];
                for (int j = 1; j < ints.length; j++) {
                    if (max < ints[j]) {
                        max = ints[j];
                    }
                }
                if (answer < max) {
                    answer = max;
                }
            }
            return answer * answer;
        }
    }
}
