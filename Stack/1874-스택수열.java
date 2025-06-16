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
			// 1 <= n <= 100,000
			int n = Integer.parseInt(br.readLine());
			int[] target = new int[n];
			for (int i = 0; i < n; i++) {
				target[i] = Integer.parseInt(br.readLine());
			}

			ArrayList<Character> ans = new ArrayList<>();
			Deque<Integer> stack = new ArrayDeque<>();
			int idx = 1;

			for (int i = 0; i < n; i++) { // n번 반복(target의 길이와 일치. No면 빨리 끝남)

				while (true) { // 다음 target[i]와 일치할때까지 pop/push를 반복

					if (!stack.isEmpty() && stack.peek() == target[i]) { // 스택 확인해서 일치하면 pop
						stack.pop();
						ans.add('-');
						break;
					}

					stack.push(idx); // 스택 다음 요소가 target이 아니면 push
					ans.add('+');

					if (target[i] < idx) { // 현재 목표 숫자가 stack의 가장위에 있지 않지만 stack에 들어는 있을 때 실패
						bw.write("NO\n");
						bw.flush();
						return;
					}
					idx++;
				}
			}

			for (char c : ans) {
				bw.write(c);
				bw.newLine();
			}

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// 12345678
// [스택] / 나열
// [4321] /
// [21] / [4, 3]
// [6521] / [4, 3]
// [521] / [4, 3, 6]
// [87521] / [4, 3, 6]
// [] / [4, 3, 6, 8, 7, 5, 2, 1]

// 12345
// [1]
// [] / [1]
// [2] / [1]
// [] / [1, 2]
// [543] / [1, 2]
// [43] / [1, 2, 5]
// NO