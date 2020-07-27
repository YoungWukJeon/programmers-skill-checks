package level1;

class Solution1 {
    public long solution(int a, int b) {
        int small = (a > b)? b: a;
        int big = (a > b)? a: b;
        int n = big - small + 1;
        long answer = (small + big) * (n / 2l);

        if (n % 2 == 1) {
            answer += (small + big) / 2;
        }

        return answer;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int a = 5;
        int b = 3;

        System.out.println(solution.solution(a, b));
    }
}
