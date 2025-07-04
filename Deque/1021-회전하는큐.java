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
			// 1 <= m <= n <= 50
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			StringTokenizer st2 = new StringTokenizer(br.readLine());

			Deque<Integer> deque = new ArrayDeque<>();
			for (int i = 1; i <= n; i++) {
				deque.addLast(i);
			}

			int ans = 0;

			for (int i = 0; i < m; i++) {
				int target = Integer.parseInt(st2.nextToken());
				if (deque.peekFirst() != target) {
					List<Integer> tmp = new ArrayList<>(deque);
					if (tmp.indexOf(target) > tmp.size() / 2) {
						while (deque.peekFirst() != target) {
							deque.addFirst(deque.removeLast());
							ans++;
						}
					} else {
						while (deque.peekFirst() != target) {
							deque.addLast(deque.removeFirst());
							ans++;
						}
					}
				}
				deque.removeFirst();
			}
			bw.write(ans+ "");

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// 계속 값이 빠지는 순환큐에서 목표 숫자가 앞에 가까운지 뒤에 가까운지 판단하는 방법이 가장 중요한 문제.
// LinkedList가 Deque의 구현체이기 때문에 LinkedList로 풀면 불필요하게 최대 m번 ArrayList를 선언할 필요가 없었다..