package level2.ordinary_rectangle;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int w = 8;
        int h = 12;

        System.out.println(solution.solution(w, h));
    }

    static class Solution {
        public long solution(int w, int h) {
            return (long) w * h - (w + h - getGCD(w, h));
        }

        long getGCD(int a, int b) {
            if (b == 0) {
                return a;
            }
            return getGCD(b, a % b);
        }
    }
}
