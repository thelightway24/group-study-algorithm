import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() throws Exception {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			// 1 <= n <= 1,000,000 / 1 ≤ x ≤ 2,000,000
			int n = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] nums = new int[n];
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				set.add(nums[i]);
			}
			int x = Integer.parseInt(br.readLine());

			int result = 0;
			for (int i = 0; i < n; i++) {
				if (set.contains(x-nums[i])) {
					result++;
				}
			}

			// for (int i = 0; i < n; i++) {
			// 	for (int j = i + 1; j < n; j++) {
			// 		if (nums[i] + nums[j] == x) {
			// 			result++;
			// 		}
			// 	}
			// }

			bw.write(String.valueOf(result/2));

			br.close();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


