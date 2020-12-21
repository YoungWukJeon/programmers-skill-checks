package level2.printer;

import java.util.*;
import java.util.stream.Collectors;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        System.out.println(solution.solution(priorities, location));
    }

    static class Solution {
        public int solution(int[] priorities, int location) {
            final var works = new LinkedList<Work>();
            final var maxIndexes = new ArrayList<Integer>();
            final var priorityCount = new int[10];

            for (int i = 0; i < priorities.length; i++) {
                works.offer(new Work(i, priorities[i]));
                priorityCount[priorities[i]]++;
                maxIndexes.add(priorities[i]);
            }

            final var sortedMaxIndexes = maxIndexes.stream()
                    .distinct()
                    .sorted((a, b) -> b - a)
                    .collect(Collectors.toList());
            var index = 0;

            while (!works.isEmpty()) {
                final var work = works.poll();
                final var max = sortedMaxIndexes.get(index);
                if (work.getPriority() == max) {
                    if (work.getNo() == location) {
                        break;
                    }
                    priorityCount[max]--;
                    if (priorityCount[max] == 0) {
                        index++;
                    }
                    continue;
                }
                works.offer(work);
            }

            return priorities.length - works.size();
        }
    }

    static class Work {
        private final int no;
        private final int priority;

        public Work(int no, int priority) {
            this.no = no;
            this.priority = priority;
        }

        public int getNo() {
            return no;
        }

        public int getPriority() {
            return priority;
        }
    }
}
