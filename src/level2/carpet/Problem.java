package level2.carpet;

import java.util.Arrays;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int brown = 10;
        int yellow = 2;
        System.out.println(Arrays.toString(solution.solution(brown, yellow)));
    }

    static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            int a = brown + yellow;

            for (int i = 1; i <= (int) Math.sqrt(a); i++) {
                if (a % i == 0 && (a / i + i) * 2 - 4 == brown) {
                    answer[0] = a / i;
                    answer[1] = i;
                    break;
                }
            }
            return answer;
        }
    }
}
