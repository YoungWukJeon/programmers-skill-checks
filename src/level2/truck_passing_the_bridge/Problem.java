package level2.truck_passing_the_bridge;

import java.util.Deque;
import java.util.LinkedList;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int bridgeLength = 2;
        int weight = 10;
        int[] truckWeights = {7, 4, 6, 5};

        System.out.println(solution.solution(bridgeLength, weight, truckWeights)); // 8
    }

    static class Truck {
        int remainingDistance;
        int weight;

        public Truck(int remainingDistance, int weight) {
            this.remainingDistance = remainingDistance;
            this.weight = weight;
        }
    }

    static class Solution {
        public int solution(int bridgeLength, int weight, int[] truckWeights) {
            int time = 0;
            int truckIndex = 0;
            int currentWeight = 0;

            Deque<Truck> trucksOnBridge = new LinkedList<> ();

            while (truckIndex < truckWeights.length) {
                time++;
                if (!trucksOnBridge.isEmpty()) {
                    Truck arrivedTruck = moveTrucks(trucksOnBridge);
                    if (arrivedTruck != null) {
                        currentWeight -= arrivedTruck.weight;
                    }
                }

                if (currentWeight + truckWeights[truckIndex] <= weight) {
                    trucksOnBridge.offer(new Truck(bridgeLength - 1, truckWeights[truckIndex]));
                    currentWeight += truckWeights[truckIndex++];
                }
            }

            if (!trucksOnBridge.isEmpty()) {
                time += trucksOnBridge.getLast().remainingDistance + 1;
            }

            return time;
        }

        public Truck moveTrucks(Deque<Truck> trucksOnBridge) {
            for (Truck truck : trucksOnBridge) {
                truck.remainingDistance--;
            }
            if (!trucksOnBridge.isEmpty() && trucksOnBridge.peek().remainingDistance < 0) {
                return trucksOnBridge.poll();
            }
            return null;
        }
    }
}
