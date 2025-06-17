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
			// 0 < n < 500,000, 0 < k < 100,000,000
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] nums = new int[n];
			Deque<int[]> stack = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < n; i++) {
				while (!stack.isEmpty() && stack.peek()[1] < nums[i]) {
					stack.pop();
				}

				if (stack.isEmpty()) {
					bw.write("0 ");
				} else {
					bw.write(stack.peek()[0] + " ");
				}
				stack.push(new int[] {i + 1, nums[i]});
			}

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// 69574
// 45796
// ans = 00224

//int flag 로 flag++, flag--로 컨트롤 하려 했으나 인덱스를 추적하는데 실패했다. 결국 push/pop 횟수밖에 카운팅하지 못함.
// stack에서 nums[i]만 다루지 않고, 배열로 인덱스까지 저장/작업 int[] {i, nums[i]} 해서 성공
