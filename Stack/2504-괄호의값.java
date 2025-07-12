import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		Stack<Object> stack = new Stack<>();
		boolean isValid = true;

		for (char ch : line.toCharArray()) {
			if (ch == '(' || ch == '[') {
				stack.push(ch);
			} else {
				int temp = 0;

				while (!stack.isEmpty() && stack.peek() instanceof Integer) {
					temp += (int)stack.pop();
				}

				if (stack.isEmpty()) {
					isValid = false;
					break;
				}

				char open = (char)stack.pop();
				if ((ch == ')' && open == '(')) {
					stack.push(temp == 0 ? 2 : 2 * temp);
				} else if ((ch == ']' && open == '[')) {
					stack.push(temp == 0 ? 3 : 3 * temp);
				} else {
					isValid = false;
					break;
				}
			}
		}

		int result = 0;
		for (Object obj : stack) {
			if (obj instanceof Character) {
				isValid = false;
				break;
			} else {
				result += (int)obj;
			}
		}

		System.out.println(isValid ? result : 0);
	}
}
