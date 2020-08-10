package level2.feature_development;

import java.util.Arrays;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        System.out.println(Arrays.toString(solution.solution(progresses, speeds))); // {2, 1}
    }

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = new int[progresses.length];
            int max = 0;
            int count = 0;
            int index = 0;

            for (int i = 0; i < progresses.length; i++) {
                int r = (100 - progresses[i]) % speeds[i];
                int q = r > 0? (100 - progresses[i]) / speeds[i] + 1: (100 - progresses[i]) / speeds[i];

                if (i == 0) {
                    max = q;
                    count = 1;
                    continue;
                }

                if (max < q) {
                    max = q;
                    answer[index++] = count;
                    count = 1;
                } else {
                    count++;
                }
            }

            if (count > 0) {
                answer[index] = count;
            }

            return Arrays.copyOf(answer, index + 1);
        }
    }
}
