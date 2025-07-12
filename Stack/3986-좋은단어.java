import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int maxNum = Integer.parseInt(br.readLine());
		int goodWordCount = 0;

		for (int i = 0; i < maxNum; i++) {
			String word = br.readLine();
			Stack<Character> stack = new Stack<>();

			for (char c : word.toCharArray()) {
				if (!stack.isEmpty() && stack.peek() == c) {
					stack.pop();
				} else {
					stack.push(c);
				}
			}

			if (stack.isEmpty()) {
				goodWordCount++;
			}
		}

		System.out.println(goodWordCount);
	}
}

