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
			String s = br.readLine();
			int ans = 0;
			Deque<Character> stack = new ArrayDeque<>();

			for (int i = 0; i < s.length(); i++) {

				if (s.charAt(i) == '(') {
					stack.push(s.charAt(i));
				} else if (s.charAt(i) == ')'){
					stack.pop();
					if (s.charAt(i - 1) == '(') { // 레이저가 자르면서 그동안의 중첩에 대해 더함
						ans += stack.size();
					} else { // 레이저가 아니라 막대기의 끝을 나타내는 ')' 라면, 그 막대기의 마지막 조각 추가.
						ans++;
					}
				}

			}
			bw.write(ans + "");

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
// Pair를 사용해보려다 오히려 더 꼬여버렸다.. 결국 ) 가 레이저를 나타내는지 막대의 끝을 나타내는 지 구분했으면 됐음.
// 4가지 케이스
// 1. '(' -> 막대기의 시작
// 2. '(' -> 레이저 시작
// 3. ')' -> 막대기의 끝
// 4. ')' -> 레이저 끝