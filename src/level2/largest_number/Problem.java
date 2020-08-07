package level2.largest_number;

import java.util.Arrays;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] numbers = {6, 10, 2};
        int[] numbers = {3, 30, 34, 5, 9};
//        int[] numbers = {31, 32, 33, 34, 35, 3, 30};
//        int[] numbers = {1, 2, 3, 4, 5, 0, 6, 19};
//        int[] numbers = {0, 0, 0, 0};
        System.out.println(solution.solution(numbers));
        System.out.println("10".compareTo("50"));
        System.out.println("10".compareTo("14"));
        System.out.println("\uD83D\uDE00".compareTo("a"));
        System.out.println("\uD83D\uDE00");
        System.out.println(Boolean.compare(true, false));
    }

    static class Solution {
        public String solution(int[] numbers) {
            String[] strNumbers = Arrays.stream(numbers)
                    .boxed()
                    .map(String::valueOf)
                    .toArray(String[]::new);
            Arrays.sort(strNumbers, (num1, num2) -> (num2 + num1).compareTo(num1 + num2));

            StringBuilder stringBuilder = new StringBuilder();
            for (String number : strNumbers) {
                stringBuilder.append(number);
            }
            return stringBuilder.toString().charAt(0) == '0'? "0": stringBuilder.toString();
        }
    }
}