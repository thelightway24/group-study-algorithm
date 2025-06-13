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
			// 0 <= n <= 100,000, 1 <= m <= 500,000
			LinkedList<Character> list = new LinkedList<>();
			char[] cArr = br.readLine().toCharArray();
			for (char c : cArr) {
				list.add(c);
			}
			int m = Integer.parseInt(br.readLine());

			ListIterator<Character> iterator = list.listIterator(); // 커서 역할
			while (iterator.hasNext()) { // 커서를 리스트 마지막에 둠
				iterator.next();
			}

			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				if (cmd.equals("P")) {
					char a = st.nextToken().charAt(0);
					iterator.add(a);
				} else if (cmd.equals("L")) {
					if (iterator.hasPrevious()) iterator.previous();
				} else if (cmd.equals("D")) {
					if (iterator.hasNext()) iterator.next();
				} else if (cmd.equals("B")) {
					if (iterator.hasPrevious()) {
						iterator.previous();
						iterator.remove();
					}
				}
			}

			for (Character c : list) {
				bw.write(String.valueOf(c));
			}

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// 원래 아는데로만 하려고 온몸 비틀기로 커서를 포인터로 구현해 풀려고 했지만 결국 링크드 리스트에 요소 추가/삭제하는데 O(n)의 시간이 들어 포기.
// iterator 공부를 하고 왔다.

// start: dmih/ pointer = 4
// B   : dmi/   pointer = 3
// B   : dm/    pointer = 2
// P x : dmx/   pointer = 3
// L   : dm/x   pointer = 2
// B   : d/x    pointer = 1
// B   : /x     pointer = 0
// B   : /x     pointer = 0
// P y : y/x    pointer = 1
// D   : yx/    pointer = 2
// D   : yx/    pointer = 2
// P z : yxz/   pointer = 3

//
// 	public static void solution() {
// 		try (
// 			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
// 		) {
// 			// 0 <= n <= 100,000, 1 <= m <= 500,000
// 			LinkedList<Character> list = new LinkedList<>();
// 			char[] cArr = br.readLine().toCharArray();
// 			int n = cArr.length;
// 			for (char c : cArr) {
// 				list.add(c);
// 			}
// 			int m = Integer.parseInt(br.readLine());
//
// 			int pointer = n;
//
// 			for (int i = 0; i < m; i++) {
// 				StringTokenizer st = new StringTokenizer(br.readLine());
// 				String cmd = st.nextToken();
// 				if (cmd.equals("P")) {
// 					char a = st.nextToken().charAt(0);
// 					if (pointer == list.size()) {
// 						list.addLast(a);
// 					} else {
// 						list.add(pointer, a); // O(n)으로 시간 초과 발생
// 					}
// 					pointer++;
// 				} else if (cmd.equals("L")) {
// 					if (pointer > 0) pointer--;
// 				} else if (cmd.equals("D")) {
// 					if (pointer < list.size()) pointer++;
// 				} else if (cmd.equals("B")) {
// 					if (pointer > 0) {
// 						list.remove(pointer - 1); // O(n)으로 시간 초과 발생
// 						pointer--;
// 					}
// 				}
// 			}
//
// 			for (Character c : list) {
// 				bw.write(String.valueOf(c));
// 			}
//
// 			bw.flush();
// 		} catch (IOException e) {
// 			e.printStackTrace();
// 		}
// 	}
// }