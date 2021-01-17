package level2.skill_tree;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String skill = "CBD";
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution.solution(skill, skillTrees));   // 2
    }

    static class Solution {
        public int solution(String skill, String[] skillTrees) {
            int answer = 0;

            for (final var tree : skillTrees) {
                var currentSkillIndex = 0;
                var flag = true;
                for (final var c : tree.toCharArray()) {
                    if (skill.contains("" + c) && c != skill.charAt(currentSkillIndex++)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
