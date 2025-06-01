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

			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			int c = Integer.parseInt(br.readLine());
			String num = String.valueOf(a*b*c);
			int[] arr = new int[10];
			for (int i = 0; i < num.length(); i++) {
				arr[num.charAt(i) - '0']++;
			}

			for (int i : arr) {
				bw.write(String.valueOf(i));
				bw.newLine();
			}

			br.close();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


