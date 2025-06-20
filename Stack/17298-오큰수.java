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
			// 1 <= n <= 1,000,000, 1 <= a <= 1,000,000
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			Deque<int[]> stack = new ArrayDeque<>();
			int[] ans = new int[n];

			for (int i = 0; i < n; i++) {
				while (!stack.isEmpty() && stack.peek()[1] < nums[i]){
					ans[stack.peek()[0]] = nums[i];
					stack.pop();
				}

				stack.push(new int[]{i, nums[i]});
			}

			for (int i = 0; i < n; i++) {
				if (ans[i] == 0) {
					bw.write("-1 ");
				} else {
					bw.write(ans[i] + " ");
				}
			}

			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}

// 스택 문제 풀 때 가장 큰 고난이
// 1. 스택에 정수(원시타입)만 담을 것인가, 여러 정보를 가진 객체를 담을 것인가(배열 등)
// 2. 객체를 담는다면 어떤 정보 (누적합, 인덱스, 상태값 등등)들을 담을 것인가 + 얼마나 담을 것인가.
// 3. 답변을 위한 객체를 만들 것인가, 객체를 생성하지 않고 pop/push 과정에서 연속적으로 출력할 것인가?
// 위의 것들을 정하는 것이 어려운 것 같다. 결국 최적화된 선택은 정해져있는데 문제를 읽고서 바로 알 수가 없었던 게 가장 큰 문제였던 것 같다.
// 그래서 앞으로는 일단 메모리 신경 안 쓰고 필요할 것 같은 요소들을 일단 모두 만들고 최적화해가는 방향으로 가야겠다.

// 위 문제는 결국 스택에 index를 담은 객체를 저장하면서, 답변을 위한 배열을 하나 더 선언하는 게 답이었던 것 같다.
// 만약 배열에 정수만 담고 반복문 안에서 출력을 하려 했으면 시간을 많이 빼앗겼을 것