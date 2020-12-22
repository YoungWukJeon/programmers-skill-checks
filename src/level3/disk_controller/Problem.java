package level3.disk_controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
//        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}, {30, 3}};

        System.out.println(solution.solution(jobs));
    }

    static class Solution {
        public int solution(int[][] jobs) {
            final var completeJobs = new ArrayList<Job>();
            final var diskController = new PriorityQueue<Job>(Comparator.comparing(Job::getTime));
            final var sortedJobs = IntStream.range(0, jobs.length)
                    .mapToObj(i -> new Job(i, jobs[i][0], jobs[i][1], -1))
                    .sorted()
                    .collect(Collectors.toList());

            diskController.offer(sortedJobs.get(0));

            var index = 1;
            var currentTime = sortedJobs.get(0).getArrivalTime();

            while (!diskController.isEmpty()) {
                final var job = diskController.poll();
                currentTime += job.getTime();
                completeJobs.add(new Job(job.getNo(), job.getArrivalTime(), job.getTime(), currentTime - job.getArrivalTime()));

                while (index < sortedJobs.size()) {
                    if (sortedJobs.get(index).getArrivalTime() > currentTime) {
                        break;
                    }
                    diskController.offer(sortedJobs.get(index));
                    index++;
                }

                if (diskController.isEmpty() && index < sortedJobs.size()) {
                    currentTime = sortedJobs.get(index).getArrivalTime();
                    diskController.offer(sortedJobs.get(index));
                    index++;
                }
            }

            return (int) completeJobs.stream()
                    .mapToInt(Job::getCompleteTime)
                    .average()
                    .orElse(0D);
        }
    }

    static class Job implements Comparable<Job> {
        private final int no;
        private final int arrivalTime;
        private final int time;
        private final int completeTime;

        public Job(int no, int arrivalTime, int time, int completeTime) {
            this.no = no;
            this.arrivalTime = arrivalTime;
            this.time = time;
            this.completeTime = completeTime;
        }

        public int getNo() {
            return no;
        }

        public int getArrivalTime() {
            return arrivalTime;
        }

        public int getTime() {
            return time;
        }

        public int getCompleteTime() {
            return completeTime;
        }

        @Override
        public int compareTo(Job job) {
            if (this.arrivalTime == job.getArrivalTime()) {
                return this.time - job.getTime();
            }
            return this.arrivalTime - job.getArrivalTime();
        }
    }
}