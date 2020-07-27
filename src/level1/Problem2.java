package level1;

class Solution2 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];

        for (int i = 0; i < n; ++i) {
            String map = "";
            String row1 = leftPad(Integer.toBinaryString(arr1[i]), n);
            String row2 = leftPad(Integer.toBinaryString(arr2[i]), n);

            for (int j = 0; j < n; ++j) {
                if (row1.charAt(j) == '1' || row2.charAt(j) == '1') {
                    map += "#";
                } else {
                    map += " ";
                }
            }
            result[i] = map;
        }

        return result;
    }

    public String leftPad(String str, int length) {
        if (str.length() < length) {
            int size = str.length();
            for (int i = 0; i < length - size; ++i) {
                str = "0" + str;
            }
        }
        return str;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
//		String[] expected = {"#####","# # #", "### #", "# ##", "#####"};

        Solution2 solution = new Solution2();
        String[] result = solution.solution(n, arr1, arr2);

        for (String str: result) {
            System.out.println(str);
        }
    }
}