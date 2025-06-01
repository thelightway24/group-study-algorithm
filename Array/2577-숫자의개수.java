package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Array2577숫자의개수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		br.close();

		int result = a * b * c;
		int[] count = new int[10];
		int remainder;

		while (result > 0) {
			remainder = result % 10;
			count[remainder]++;
			result /= 10;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count.length; i++) {
			sb.append(count[i]).append("\n");
			;
		}
		System.out.println(sb);
	}
}


