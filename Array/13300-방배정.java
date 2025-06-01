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
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] arr = new int[12];
			for (int i = 0; i < n; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st2.nextToken());
				int y = Integer.parseInt(st2.nextToken());
				int index = s * 6 + (y - 1);
				arr[index]++;
			}
			int count = 0;

			for (int i = 0; i < 12; i++) {
				if (arr[i] == 0) continue;
				count += arr[i]/k;
				if (arr[i]%k != 0) count++;
			}
			bw.write(String.valueOf(count));

			br.close();
			bw.flush();
			bw.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}


