package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Array10808알파벳개수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int code;
		int[] alphabetCount = new int[26];

		while (97 <= (code = br.read()) && code <= 122) {
			alphabetCount[code - 97] += 1;
		}

		br.close();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 26; i++) {
			sb.append(alphabetCount[i]);
			sb.append(" ");
		}

		System.out.println(sb);
	}
}


