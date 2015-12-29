package leetcode;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (Character c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (!stack.empty()) {
					char top = stack.peek();
					if (c == ')' && top == '(')
						stack.pop();
					else if (c == ']' && top == '[')
						stack.pop();
					else if (c == '}' && top == '{')
						stack.pop();
					else
						return false;
				} else {
					return false;
				}
			}
		}
		if (stack.empty())
			return true;
		return false;
	}
}
