package level2.repeat_binary_conversion;

import java.util.Arrays;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "110010101001";

        System.out.println(Arrays.toString(solution.solution(s)));  // [3, 8]
    }

    static class Solution {
        public int[] solution(String s) {
            var zeroCount = 0;
            var binaryChangeCount = 0;

            while (!"1".equals(s)) {
                var temp = s.replaceAll("0", "");
                zeroCount += s.length() - temp.length();
                s = toBinary(temp.length(), "");
                binaryChangeCount++;
            }

            return new int[] {binaryChangeCount, zeroCount};
        }

        public String toBinary(int n, String bin) {
            if (n == 0) {
                return bin;
            }
            return toBinary(n / 2, "" + n % 2) + bin;
        }
    }
}
