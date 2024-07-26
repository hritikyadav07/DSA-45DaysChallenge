// https://www.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1


import java.util.Stack;

class PostfixEvaluator {

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the character is a space, skip it
            if (c == ' ') {
                continue;
            }

            // If the character is a digit, push it onto the stack
            if (Character.isDigit(c)) {
                
                stack.push((int)(c - '0'));
            } else {
                // The character is an operator, pop two elements from the stack and apply the operator
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }

        // The final result will be at the top of the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        String expression = "2 3 1 * + 9 -";
        System.out.println("The result of the postfix expression is: " + evaluatePostfix(expression));
    }
}
