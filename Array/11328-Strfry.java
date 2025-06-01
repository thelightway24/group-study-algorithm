package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Array11328Strfry {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < testCaseNum; i++) {
			String[] targetNums = br.readLine().trim().split(" ");
			String first = targetNums[0];
			String second = targetNums[1];

			if (first.length() != second.length()) {
				sb.append("Impossible\n");
				continue;
			}

			int[] count = new int[26];
			for (int j = 0; j < first.length(); j++) {
				count[first.charAt(j) - 'a']++;
				count[second.charAt(j) - 'a']--;
			}

			boolean isSame = true;
			for (int c : count) {
				if (c != 0) {
					isSame = false;
					break;
				}
			}

			if (isSame) {
				sb.append("Possible\n");
			} else {
				sb.append("Impossible\n");
			}
		}
		System.out.println(sb);
	}
}