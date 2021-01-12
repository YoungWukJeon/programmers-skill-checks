package level2.more_spicy;

import java.util.PriorityQueue;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;

        System.out.println(solution.solution(scoville, k));
    }

    static class Solution {
        public int solution(int[] scoville, int k) {
            int answer = 0;

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int food : scoville) {
                queue.offer(food);
            }

            while (!queue.isEmpty()) {
                int food = queue.poll();
                if (food < k) {
                    if (queue.isEmpty()) {
                        return -1;
                    }
                    queue.offer(food + queue.poll() * 2);
                    answer += 1;
                }
            }

            return answer;
        }
    }
}
