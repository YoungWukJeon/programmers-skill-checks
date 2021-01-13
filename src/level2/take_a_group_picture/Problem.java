package level2.take_a_group_picture;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};

        System.out.println(solution.solution(n, data)); // 3648
    }

    static class Solution {
        public int solution(int n, String[] data) { char[] characters = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

            List<char[]> lines = new LinkedList<>();
            for (char character : characters) {
                char[] temp = {character, '\0', '\0', '\0', '\0', '\0', '\0', '\0'};
                perm(characters, 1, temp, lines);
            }

            for (String condition : data) {
                char source = condition.charAt(0);
                char target = condition.charAt(2);
                char cond = condition.charAt(3);
                int gap = Integer.parseInt(condition.substring(4, 5));
                Iterator<char[]> iter = lines.iterator();
                while (iter.hasNext()) {
                    char[] character = iter.next();
                    int sourceIndex = indexOf(character, source);
                    int targetIndex = indexOf(character, target);
                    int distance = Math.abs(sourceIndex - targetIndex) - 1;
                    if (!((cond == '=' && gap == distance) ||
                            (cond == '>' && gap < distance) ||
                            (cond == '<' && gap > distance))) {
                        iter.remove();
                    }
                }
            }
            return lines.size();
        }

        public int indexOf(char[] characters, char c) {
            for (int i = 0; i < characters.length; i++) {
                if (characters[i] == c) {
                    return i;
                }
            }
            return -1;
        }

        public void perm(char[] characters, int count, char[] current, List<char[]> lines) {
            if (count == characters.length) {
                lines.add(current.clone());
                return;
            }

            for (char character : characters) {
                if (!contains(current, character)) {
                    current[count] = character;
                    perm(characters, count + 1, current, lines);
                    current[count] = '\0';
                }
            }
        }

        public boolean contains(char[] current, char c) {
            for (char ch : current) {
                if (ch == c) {
                    return true;
                }
            }
            return false;
        }
    }
}
