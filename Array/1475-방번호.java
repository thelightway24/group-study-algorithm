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

			// 0 < n <= 1,000,000
			String n = br.readLine();
			int[] arr = new int[10];
			int max = 0;

			for (int i = 0; i < n.length(); i++) {
				int num = n.charAt(i) - '0';
				if (num == 9) {
					num = 6;
				}
				arr[num]++;
			}
			arr[6] = arr[6]/2 + arr[6]%2;

			for (int i = 0; i < arr.length; i++) {
				max = Math.max(max, arr[i]);
			}

			bw.write(String.valueOf(max));

			br.close();
			bw.flush();
			bw.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}


