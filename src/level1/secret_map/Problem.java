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
            String format = "%0" + n + "s";
            for (int i = 0; i < n; i++) {
                String tempStr1 = String.format("%5s", binaryString(arr1[i], ""));
                String tempStr2 = String.format(format, binaryString(arr2[i], ""));

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

        public String orOperation(String str1, String str2) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < str1.length(); i++) {
                int c1 = str1.charAt(i);
                int c2 = str2.charAt(i);

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
