package medium.decodeString;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder sb = new StringBuilder();

                while (!stack.isEmpty() && Character.isAlphabetic(stack.peek())) {
                    sb.append(stack.pop());
                }

                stack.pop(); // removing [
                StringBuilder numBuilder = new StringBuilder();

                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    numBuilder.append(stack.pop());
                }

                String topush = "";
                int times = Integer.parseInt(numBuilder.reverse().toString());
                String temp = sb.reverse().toString();

                for (int i = 0; i < times; i++) {
                    topush += temp;
                }

                for (char x : topush.toCharArray()) {
                    stack.push(x);
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder answer = new StringBuilder();

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        return answer.reverse().toString();
    }
}
