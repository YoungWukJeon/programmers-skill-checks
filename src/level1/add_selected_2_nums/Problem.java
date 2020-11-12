package level1.add_selected_2_nums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] numbers = {2, 1, 3, 4, 1};    // 2,3,4,5,6,7

        System.out.println(Arrays.toString(solution.solution(numbers)));
    }

    static class Solution {
        public int[] solution(int[] numbers) {
            List<Integer> sums = IntStream.range(0, numbers.length)
                    .flatMap(i -> IntStream.range(0, numbers.length)
                            .filter(j -> i != j)
                            .map(j -> numbers[i] + numbers[j]))
                    .boxed()
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());

            int[] answer = new int[sums.size()];

            IntStream.range(0, sums.size())
                    .forEach(i -> answer[i] = sums.get(i));

            return answer;
        }
    }
}
