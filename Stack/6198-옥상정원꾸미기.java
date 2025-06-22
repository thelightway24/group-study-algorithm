import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		solution();
	}

	// stack에 대해,,
	// 10
	// 10 3 		ans = 1
	// 10 7			ans = 2
	// 10 7 4		ans = 3
	// 12 			ans = 3
	// 12 2			ans = 4

	// 10 3 7 4 12 2

	// 10 7 4 같은경우에서 10과 7에 대해 동시에 카운트를 늘리는게 포인트다. 중첩합을 해야함

	// 10			k = 0, ans = 0
	// 10 3			k = 1, ans += k
	// 10 7			k = 1, ans += k
	// 10 7 4		k = 2, ans += k;
	// 12			k = 0, ans += k
	// 12 2			k = 1, ans += k
	//ans = 5

	// k = 스택에 새로 push될 값의 옥상을 볼 수 있는 건물 수

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			// 1 <= n <= 80,000, 1 <= h <= 1,000,000,000
			// 같은 건물에 대해 중복 카운팅이 됨
			int n = Integer.parseInt(br.readLine());
			int[] heights = new int[n];
			for (int i = 0; i < n; i++) {
				heights[i] = Integer.parseInt(br.readLine());
			}
			Deque<int[]> stack = new ArrayDeque<>();
			long ans = 0;

			for (int i = 0; i < n; i++) {
				if (stack.isEmpty()) {
					stack.push(new int[] {0, heights[i]});
					continue;
				}

				if (stack.peek()[1] > heights[i]) {
					stack.peek()[0]++;
					ans += stack.peek()[0];
					stack.push(new int[] {stack.peek()[0], heights[i]});
				} else {
					int temp = stack.peek()[0];
					int k = 0;

					while (!stack.isEmpty() && stack.peek()[1] <= heights[i]) {
						stack.pop();
						k++;
					}

					if (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
						stack.peek()[0] = temp - k + 1;
						ans += stack.peek()[0];
						stack.push(new int[] {stack.peek()[0], heights[i]});
					} else {
						stack.push(new int[] {0, heights[i]});
					}
				}
			}

			bw.write(ans + "");

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// k를 스택 사이즈로 대체해서 계산
	public static void solution2() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			// 1 <= n <= 80,000, 1 <= h <= 1,000,000,000
			// 같은 건물에 대해 중복 카운팅이 됨
			int n = Integer.parseInt(br.readLine());
			int[] heights = new int[n];
			for (int i = 0; i < n; i++) {
				heights[i] = Integer.parseInt(br.readLine());
			}
			Deque<Integer> stack = new ArrayDeque<>();
			long ans = 0;

			for (int i = 0; i < n; i++) {
				if (stack.isEmpty()) {
					stack.push(heights[i]);
					continue;
				}

				while (!stack.isEmpty() && stack.peek() <= heights[i]) {
					stack.pop();
				} // 결국 stack이 비워지거나, 새로운 수보다 큰 수가 스택의 top에 등장하게 됨

				// 두 케이스에 대해 대응하는 법이 같다.
				ans += stack.size();
				stack.push(heights[i]);
			}

			bw.write(ans + "");

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// size로 하면 되는데 결국 문제 이해안하고 디버깅으로 풀어버림. 결국 stack에는 다음 나오는 height[i] 보다 큰 건물들이 나열되어 있으면 된다. ([10, 8, 6, 4], heights[i] = 2)