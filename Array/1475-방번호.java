package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Array1475방번호 {

	static int[] count = new int[10];
	static int specialCount = 0;

	public static void main(String[] args) throws Exception {
		String input = init();

		countNumber(input);

		int answer = calculate();

		System.out.println(answer);
	}

	private static String init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}

	private static void countNumber(String input) {
		for (int i = 0; i < input.length(); i++) {
			int number = input.charAt(i) - '0';
			if (number == 6 || number == 9) {
				specialCount++;
			} else {
				count[number]++;
			}
		}
	}

	private static int calculate() {
		return Math.max((specialCount + 1) / 2, Arrays.stream(count).max().getAsInt());
	}
}