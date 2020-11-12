package level1.doll_drawing_game_with_crane;

import java.util.Stack;
import java.util.stream.IntStream;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4}; // 4

        System.out.println(solution.solution(board, moves));
    }

    static class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;

            Stack<Integer> bucket = new Stack<>();

            for (int move : moves) {
                int topDollIndex = getTopDollIndex(board, move);

                if (topDollIndex > -1) {
                    answer += !addBucket(bucket, board[topDollIndex][move - 1])? 2: 0;
                    board[topDollIndex][move - 1] = 0;
                }
            }

            return answer;
        }

        private int getTopDollIndex(int[][] board, int move) {
            return IntStream.range(0, board.length)
                    .filter(i -> board[i][move - 1] > 0)
                    .findFirst()
                    .orElse(-1);
        }

        private boolean addBucket(Stack<Integer> bucket, int doll) {
            if (!bucket.isEmpty() && bucket.peek() == doll) {
                bucket.pop();
                return false;
            }

            bucket.push(doll);
            return true;
        }
    }
}
