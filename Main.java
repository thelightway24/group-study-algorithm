import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstNums = br.readLine();
		String secondNums = br.readLine();

		int[] nums = new int[26];
		int[] nums2 = new int[26];

		for (int i = 0; i < firstNums.length(); i++) {
			nums[firstNums.charAt(i) - 'a']++;
		}

		for (int i = 0; i < secondNums.length(); i++) {
			nums2[secondNums.charAt(i) - 'a']++;
		}
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			count += (Math.abs(nums[i] - nums2[i]));
		}
		System.out.println(count);
	}
}


