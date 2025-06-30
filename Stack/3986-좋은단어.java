import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			int n = Integer.parseInt(br.readLine());
			int ans = 0;

			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				if ((s.length() % 2) == 0) {
					Deque<Character> stack = new ArrayDeque<>();

					for (int j = 0; j < s.length(); j++) {
						if (!stack.isEmpty() && stack.peek() == s.charAt(j)) {
							stack.pop();
						} else {
							stack.push(s.charAt(j));
						}
					}
					if (stack.isEmpty())
						ans++;
				}
			}
			bw.write(ans + "");

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}