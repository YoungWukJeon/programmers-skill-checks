package level2.kakao_friends_coloring_book;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
//        int m = 3;
//        int n = 4;
//        int[][] picture = {{1, 2, 2, 1}, {2, 2, 2, 2}, {1, 2, 2, 1}};   // [5, 8]

        System.out.println(Arrays.toString(solution.solution(m, n, picture)));  // [4, 5]
    }

    static class Solution {
        public int[] solution(int m, int n, int[][] picture) {
            boolean[][] visited = new boolean[m][n];
            int maxArea = 0;
            int areaNum = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && picture[i][j] > 0) {
                        maxArea = Math.max(maxArea, bfs(m, n, picture[i][j], picture, new Point(j, i), visited));
                        areaNum++;
                    }
                }
            }
            return new int[]{areaNum, maxArea};
        }

        public int bfs(int m, int n, int color, int[][] picture, Point current, boolean[][] visited) {
            int[][] moveDir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            Queue<Point> queue = new LinkedList<>();

            queue.offer(current);
            int cnt = 1;
            visited[current.getY()][current.getX()] = true;

            while (!queue.isEmpty()) {
                Point point = queue.poll();
                int i = point.getY();
                int j = point.getX();

                for (int[] move : moveDir) {
                    int dx = j + move[0];
                    int dy = i + move[1];
                    if (dy >= 0 && dy < m && dx >= 0 && dx < n && !visited[dy][dx] && picture[dy][dx] == color) {
                        queue.offer(new Point(dx, dy));
                        visited[dy][dx] = true;
                        cnt += 1;
                    }
                }
            }
            return cnt;
        }
    }

    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
