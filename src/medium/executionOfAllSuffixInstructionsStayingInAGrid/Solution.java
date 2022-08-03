package medium.executionOfAllSuffixInstructionsStayingInAGrid;

public class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] answers = new int[s.length()];
        int baseX = startPos[1];
        int baseY = startPos[0];
        String instruction = s;

        for (int i = 0; i < s.length(); i++) {
            int answer = 0;
            String[] operations = instruction.split("");
            int x = baseX;
            int y = baseY;

            for (String operation : operations) {
                if (operation.equalsIgnoreCase("r")) {
                    x++;
                } else if (operation.equalsIgnoreCase("d")) {
                    y++;
                } else if (operation.equalsIgnoreCase("l")) {
                    x--;
                } else {
                    y--;
                }

                if (isOut(x, y, n)) {
                    break;
                } else {
                    answer++;
                }
            }

            answers[i] = answer;
            instruction = instruction.substring(1);
        }

        return answers;
    }


    public boolean isOut(int newX, int newY, int n) {
        if (newX >= n || newX < 0 || newY >= n || newY < 0) {
            return true;
        }

        return false;
    }
}
