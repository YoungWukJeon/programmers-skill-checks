package level2.camouflage;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] clothes = {{"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}};

        System.out.println(solution.solution(clothes));
    }

    static class Solution {
        public int solution(String[][] clothes) {
            return Arrays.stream(clothes)
                    .map(c -> c[1])
                    .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                    .values()
                    .stream()
                    .mapToInt(Long::intValue)
                    .map(i -> i + 1)
                    .reduce(1, (a, b) -> a * b) - 1;
        }
    }
}
