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
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 1 <= k <= n <= 5000
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 1; i <= n; i++) {
				list.add(i);
			}

			int pointer;
			bw.write("<");
			for (int i = 0; i < n; i++) {
				pointer = k;
				while (pointer != 1){
					list.addLast(list.removeFirst());
					pointer--;
				}
				bw.write(String.valueOf(list.removeFirst()));
				if (i != n-1) bw.write(", ");
			}

			bw.write(">");

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// 원래는 아래처럼, 다음 순서인 요소를 리스트에서 삭제해버리고, 포인터로 리스트 끝에 닿았을 때 처음으로 돌릴려고 함
// 그러나 인덱스 관리 + 리스트 길이 관리가 너무 안돼서, 리스트 자체를 돌려버렸다.
// 결국 리스트 가만히 두고 인덱스로만 돌리면 다음 어떻게 더 효율적으로 할 수 있을 것 같음.


// int pointer = k;
// bw.write("<");
// for (int i = 1; i <= n; i++) {
// 	if (pointer > n) {
// 		while (pointer <= n) {
// 			pointer -= n;
// 		}
// 	}
// 	bw.write(list.remove(pointer - i + 1));
// 	if (i != n)
// 		bw.write(", ");
// 	pointer += k;
// }
