package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Array1919애너그램만들기 {

	// public static void main(String[] args) throws Exception {
	//
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	String firstNums = br.readLine();
	// 	String secondNums = br.readLine();
	//
	// 	int[] nums = new int[26]; //97 122
	// 	for(int i = 0; i < firstNums.length(); i++) {
	// 		nums[firstNums.charAt(i)-97]++;
	// 	}
	//
	// 	for(int i = 0; i < secondNums.length(); i++) {
	// 		nums[secondNums.charAt(i)-97]--;
	// 	}
	// 	int count = 0;
	// 	for (int i = 0; i < nums.length; i++) {
	// 		if(0 != nums[i]) {
	// 			if(0 > nums[i]) {
	// 				count += nums[i]*-1;
	// 			} else {
	// 				count += nums[i];
	// 			}
	// 		}
	// 	}
	// 	System.out.println(count);
	// }

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstNums = br.readLine();
		String secondNums = br.readLine();

		int[] nums = new int[26]; //97 122
		for(int i = 0; i < firstNums.length(); i++) {
			nums[firstNums.charAt(i)-97]++;
		}

		for(int i = 0; i < secondNums.length(); i++) {
			nums[secondNums.charAt(i)-97]--;
		}
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			count += Math.abs(nums[i]);
		}
		System.out.println(count);
	}
}