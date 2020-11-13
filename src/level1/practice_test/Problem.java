package level1.practice_test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] answers = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(solution.solution(answers)));
    }

    static class Solution {
        public int[] solution(int[] answers) {
            int[][] pattern = {
                    {1, 2, 3, 4, 5},
                    {2, 1, 2, 3, 2, 4, 2, 5},
                    {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

            final var answerCounts = Arrays.stream(pattern)
                    .map(arr ->
                        IntStream.range(0, answers.length)
                                .filter(i -> answers[i] == arr[i % arr.length])
                                .count())
                    .map(Long::intValue)
                    .collect(Collectors.toList());

            final var maxAnswerCount = answerCounts.stream()
                    .max(Comparator.comparingInt(a -> a))
                    .get();

            return IntStream.range(0, answerCounts.size())
                    .filter(i -> answerCounts.get(i).intValue() == maxAnswerCount.intValue())
                    .map(i -> i + 1)
                    .toArray();
        }
    }
}
