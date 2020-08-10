package level2.stock_price;

import java.util.*;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] prices = {1, 2, 3, 2, 3};
//        int[] prices = {1, 2, 3, 2, 3, 3, 1}; // 6, 5, 1, 3, 2, 1, 0

        System.out.println(Arrays.toString(solution.solution(prices)));
    }

    static class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            for (int i = 0; i < prices.length - 1; i++) {
                int count = 0;
                for (int j = i + 1; j < prices.length; j++) {
                    count++;
                    if (prices[i] > prices[j]) {
                        break;
                    }
                }
                answer[i] = count;
            }
            return answer;
        }
    }
}