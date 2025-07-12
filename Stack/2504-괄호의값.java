import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();

		Deque<Integer> st = new ArrayDeque<>();
		for (char c : input) {
			if (c == '(') {
				st.push(-1);
			}
			else if (c == '[') {
				st.push(-2);
			}

			else {
				int marker = (c == ')') ? -1 : -2;
				int factor = (c == ')') ? 2 : 3;

				int innerSum = 0;
				while (!st.isEmpty() && st.peek() > 0) {
					innerSum += st.pop();
				}

				if (st.isEmpty() || st.peek() != marker) {
					System.out.println(0);
					return;
				}
				st.pop();

				int base = (innerSum == 0 ? 1 : innerSum) * factor;
				st.push(base);
			}
		}

		int answer = 0;
		while (!st.isEmpty()) {
			if (st.peek() <= 0) {
				System.out.println(0);
				return;
			}
			answer += st.pop();
		}

		System.out.println(answer);
	}
}
