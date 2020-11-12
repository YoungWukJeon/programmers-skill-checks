package level1.unfinished_player;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(solution.solution(participant, completion));  // leo
    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            Map<String, Long> players = Arrays.stream(participant)
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

            Arrays.stream(completion)
                    .forEach(s -> players.compute(s, (k, v) -> v - 1));

            return players.entrySet()
                    .stream()
                    .filter(e -> e.getValue() > 0)
                    .findFirst()
                    .get()
                    .getKey();
        }
    }
}
