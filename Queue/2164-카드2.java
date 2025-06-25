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
			// 1 <= n <= 500,000
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> deque = new ArrayDeque<>();
			for (int i = 1; i <= n; i++) {
				deque.addLast(i);
			}
			while (deque.size() > 1) {
				deque.removeFirst();
				deque.addLast(deque.removeFirst());
			}

			bw.write(deque.peekFirst() + "");

			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}