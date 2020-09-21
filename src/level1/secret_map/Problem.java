package level1.secret_map;

import java.util.Arrays;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        System.out.println(Arrays.toString(solution.solution(n, arr1, arr2)));
    }

    static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            for (int i = 0; i < n; i++) {
                String tempStr1 = format(n, binaryString(arr1[i], ""));
                String tempStr2 = format(n, binaryString(arr2[i], ""));
                answer[i] = orOperation(tempStr1, tempStr2);
            }
            return answer;
        }

        public String binaryString(int n, String str) {
            if (n == 0) {
                return str;
            }
            return binaryString(n / 2, (n % 2) + str);
        }

        public String format(int n, String str) {
            StringBuilder result = new StringBuilder();

            result.append("0".repeat(Math.max(0, n - str.length())));

            for (int i = 0; i < str.length(); i++) {
                result.append(str.charAt(i));
            }
            return result.toString();
        }

        public String orOperation(String str1, String str2) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < str1.length(); i++) {
                int c1 = Integer.parseInt(str1.substring(i, i + 1));
                int c2 = Integer.parseInt(str2.substring(i, i + 1));
                if ((c1 | c2) == 0) {
                    result.append(" ");
                } else {
                    result.append("#");
                }
            }
            return result.toString();
        }
    }
}
