package level2.bracket_conversion;

import java.util.Stack;

public class Problem {
    public Problem() {
        Solution solution = new Solution();

        String p = "()))((()";
        // result -> "()(())()"

        System.out.println(solution.solution(p));
    }

    public static void main(String[] args) {
        new Problem();
    }

    class Solution {
        public String solution(String p) {
            return rec(p);
        }

        public String split(String p) {
            String balancedStr = "";
            int bracketCount = 0;
            int bracketFlag = 0;
            for (char c : p.toCharArray()) {
                if (bracketFlag == 0) {
                    if (c == ')') {
                        bracketFlag = -1;
                    } else {
                        bracketFlag = 1;
                    }
                    bracketCount++;
                } else if (bracketFlag == 1) {
                    if (c == ')') {
                        bracketCount--;
                    } else {
                        bracketCount++;
                    }
                } else {
                    if (c == '(') {
                        bracketCount--;
                    } else {
                        bracketCount++;
                    }
                }

                balancedStr += c;

                if (bracketCount == 0) {
                    break;
                }
            }
            return balancedStr;
        }

        public boolean isCorrect(String v) {
            Stack<Character> openBracket = new Stack<> ();

            for (char c : v.toCharArray()) {
                if (openBracket.isEmpty() && c == ')') {
                    return false;
                } else if (c == ')') {
                    openBracket.pop();
                } else {
                    openBracket.push('(');
                }
            }
            return openBracket.isEmpty();
        }

        public String rec(String p) {
            if ("".equals(p)) {
                return "";
            }

            String u = split(p);
            String v = p.substring(u.length());

            if (isCorrect(u)) {
                return u + rec(v);
            }

            String temp = u.substring(1, u.length() - 1);
            String reversedTemp = "";

            for (char c : temp.toCharArray()) {
                if (c == ')') {
                    reversedTemp += "(";
                } else {
                    reversedTemp += ")";
                }
            }
            return  "(" + rec(v) + ")" + reversedTemp;
        }
    }
}
