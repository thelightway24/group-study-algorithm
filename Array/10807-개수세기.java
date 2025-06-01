import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		solution();
	}

	public static void solution() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			// 1 <= n <= 100 / -100 <= v <= 100
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(br.readLine());

			int[] nums = new int[201];

			for (int i = 0; i < n; i++) {
				nums[Integer.parseInt(st.nextToken()) + 100]++;
			}

			bw.write(String.valueOf(nums[v+100]));

			br.close();
			bw.flush();
			bw.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}


