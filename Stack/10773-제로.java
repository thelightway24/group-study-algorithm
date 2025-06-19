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
			// 1 <= k <= 100,000
			int k = Integer.parseInt(br.readLine());
			Deque<Integer> stack = new ArrayDeque<>();
			int num;
			int sum = 0;

			for (int i = 0; i < k; i++) {
				num = Integer.parseInt(br.readLine());
				if (num == 0){
					sum -= stack.pop();
				} else {
					stack.push(num);
					sum += stack.peek();
				}
			}
			bw.write(sum + "");

			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}