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
			// 1 <= n <= 10,000
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> stack = new ArrayDeque<>();

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				if (cmd.equals("push")) {
					stack.push(Integer.parseInt(st.nextToken()));
				} else if (cmd.equals("pop")) {
					if (stack.isEmpty()) {
						bw.write("-1\n");
					} else {
						bw.write(stack.pop() + "\n");
					}
				} else if (cmd.equals("size")) {
					bw.write(stack.size() + "\n");
				} else if (cmd.equals("empty")){
					bw.write(stack.isEmpty() ? "1\n" : "0\n");
				} else if (cmd.equals("top")){
					if (stack.isEmpty()) {
						bw.write("-1\n");
					}else {
						bw.write(stack.peek() + "\n");
					}
				}
			}

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}