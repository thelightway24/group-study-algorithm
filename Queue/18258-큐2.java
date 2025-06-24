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
			// 1 <= n <= 2,000,000
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> queue = new ArrayDeque<>();

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				if (cmd.equals("push")) {
					queue.push(Integer.parseInt(st.nextToken()));
				} else if (cmd.equals("pop")) {
					if (queue.isEmpty()) {
						bw.write("-1");
					} else {
						bw.write(queue.pollLast() + " ");
					}
					bw.newLine();
				} else if (cmd.equals("size")) {
					bw.write(queue.size() + " ");
					bw.newLine();
				} else if (cmd.equals("empty")) {
					if (queue.isEmpty()) {
						bw.write("1");
					} else {
						bw.write("0");
					}
					bw.newLine();
				} else if (cmd.equals("front")) {
					if (queue.isEmpty()) {
						bw.write("-1");
					} else {
						bw.write(queue.peekLast() + " ");
					}
					bw.newLine();
				} else if (cmd.equals("back")) {
					if (queue.isEmpty()) {
						bw.write("-1");
					} else {
						bw.write(queue.peekFirst() + " ");
					}
					bw.newLine();
				}
			}

			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}