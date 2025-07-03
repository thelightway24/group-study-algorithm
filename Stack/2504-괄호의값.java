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
			// ans = 최대 3의 15승 = 14백만~
			String s = br.readLine();
			if ((s.length() % 2 != 0)) {
				bw.write("0");
				bw.flush();
				return;
			}
			Deque<Character> stack = new ArrayDeque<>();
			int ans = 0;
			int tmp = 1;

			// (()[[]])([])
			// ans 0 0 4 4 4 22 22 22   22 22 28 28
			// tmp 2 4 2 6 18 6 2 1     2 6 2 1

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);

				if (c == '(' || c == '[') {
					stack.push(c);
					tmp *= (c == '(' ? 2 : 3);
				} else if (stack.isEmpty()) {
					bw.write("0");
					bw.flush();
					return;
				} else if ((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[')) {
					ans += (s.charAt(i - 1) == (c == ')' ? '(' : '[')) ? tmp : 0;
					tmp /= (c == ')' ? 2 : 3);
					stack.pop();
				} else {
					bw.write("0");
					bw.flush();
					return;
				}
			}

			if (!stack.isEmpty()) {
				bw.write("0");
			} else {
				bw.write(ans + "");
			}

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 1. ( -> 뒤에 ) 를 제외한 값이 들어와 *2가 됨
	// 2. ( -> 바로 뒤에 )가 와 2가됨
	// 3. ) -> 앞에 ( 를 제외한 값이 들어와 *2가 됨
	// 4. ) -> 바로 앞에 (가 와 2가됨
	// 5. [ -> 뒤에 ] 를 제외한 값이 들어와 *3가 됨
	// 6. [ -> 바로 뒤에 ]가 와 3이됨
	// 7. ] -> 앞에 [ 를 제외한 값이 들어와 *3가 됨
	// 8. ] -> 바로 앞에 [가 와 3이됨
	// -> 잘못된 접근법

	// (()[[]])([])
	// 곱셈의 경우 괄호가 닫힐때 적용해야함. 그러면 (2 * (2 + 3*3)) + (2*3) 의 순서를 어떻게 답안으로 뽑을까.
	// 리스트 등으로 무식하게 하면할 수 있지만 그게 답은 아닐 것이다.
	// ans 변수 하나만으로 저거 계산할 수 있나? 순서를 보면
	// ans = 3*3
	// ans = 3*3 +2
	// ans = (3*3 +2) * 2
	// ans = ((3*3 +2) * 2) + (2*3)
	// 스택은 결국 재귀인데 + (2*3)이 tmp 없이 가능한가?

	// () 와 []를 그대로 스택에서 pop하지말고 계산하면 되나?
	// 한번에 깔끔하게 할 수는 없을 듯

	// 결국 누적합이라고 한다. 숫자는 2와 3으로만 시작.
	// 문제 풀기 시작하면서 제일 힘든 문제 중 하나인듯

	// 핵심은 2 * (2 + (3*3))을  (2*2) + (2*3*3)으로 생각할 수 있는지 사고력
	// + 스택이란 재귀(중첩)적 자료구조를 쓰면서 그 중첩 처리를 어떻게 만들지 생각하는 것이다.
	// 근데 이건 모든 케이스를 밑의 solution2처럼 나열해놓고 디버깅을 하면서 답을 추출하고 추후에 정리하는게 맞는 방법같다. 한번에 도출해낼 수가 없었음.

	public static void solution2() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			// ans = 최대 3의 15승 = 14백만~
			String s = br.readLine();
			if ((s.length() % 2 != 0)) {
				bw.write("0");
				bw.flush();
				return;
			}
			Deque<Character> stack = new ArrayDeque<>();
			int ans = 0;
			int tmp = 1;

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(') {
					stack.push(c);
					tmp *= 2;
				} else if (c == '[') {
					stack.push(c);
					tmp *= 3;
				} else if (stack.isEmpty()) {
					bw.write("0");
					bw.flush();
					return;
				} else if (c == ')') {
					if (s.charAt(i - 1) == '(') {
						ans += tmp;
						tmp /= 2;
						stack.pop();
					} else if (stack.peek() == '(') {
						stack.pop();
						tmp /= 2;
					} else {
						bw.write("0");
						bw.flush();
						return;
					}

				} else if (c == ']') {
					if (s.charAt(i - 1) == '[') {
						ans += tmp;
						tmp /= 3;
						stack.pop();
					} else if (stack.peek() == '[') {
						stack.pop();
						tmp /= 3;
					} else {
						bw.write("0");
						bw.flush();
						return;
					}
				}
			}

			if (!stack.isEmpty()) {
				bw.write("0");
			} else {
				bw.write(ans + "");
			}

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
