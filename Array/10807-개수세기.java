package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Array10807개수세기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int targetNum = Integer.parseInt(br.readLine());

		int[] nums = new int[max];

		for (int i = 0; i < max; i++) {
			nums[i] = Integer.parseInt(input[i]);
		}

		int count = 0;
		for (int i = 0; i < max; i++) {
			if (nums[i] == targetNum) {
				count++;
			}
		}
		System.out.println(count);
	}

}