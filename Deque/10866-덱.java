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
			Deque<Integer> deque = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				if (cmd.equals("push_front")) {
					deque.addFirst(Integer.parseInt(st.nextToken()));
				} else if (cmd.equals("push_back")) {
					deque.addLast(Integer.parseInt(st.nextToken()));
				} else if (cmd.equals("pop_front")) {
					if (deque.isEmpty()) {
						bw.write("-1");
					} else {
						bw.write(deque.removeFirst());
					}
					bw.newLine();
				} else if (cmd.equals("pop_back")) {
					if (deque.isEmpty()) {
						bw.write("-1");
					} else {
						bw.write(deque.removeLast());
					}
					bw.newLine();
				} else if (cmd.equals("size")) {
					bw.write(deque.size());
					bw.newLine();
				} else if (cmd.equals("empty")) {
					if (deque.isEmpty()) {
						bw.write("1");
					} else {
						bw.write("0");
					}
					bw.newLine();
				} else if (cmd.equals("front")) {
					if (deque.isEmpty()) {
						bw.write("-1");
					} else {
						bw.write(deque.peekFirst());
					}
					bw.newLine();
				} else if (cmd.equals("back")) {
					if (deque.isEmpty()) {
						bw.write("-1");
					} else {
						bw.write(deque.peekLast());
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