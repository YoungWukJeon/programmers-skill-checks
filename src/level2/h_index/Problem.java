package level2.h_index;

import java.util.Arrays;
import java.util.Comparator;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] citations = {3, 0, 6, 1, 5};

        System.out.println(solution.solution(citations));
    }

    public static class Solution {
        public int solution(int[] citations) {
            int answer = 0;

            Integer[] convertedCitations = Arrays.stream(citations)
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .toArray(Integer[]::new);

            for (int i = 0; i < convertedCitations.length; i++) {
                answer = Math.max(answer, Math.min(convertedCitations[i], i + 1));
            }

            return answer;
        }
    }
}
