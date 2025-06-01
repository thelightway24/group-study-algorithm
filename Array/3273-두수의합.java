package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Array3273두수의합 {

	public static void main(String[] args) throws Exception {
		// 수열의 크기 n은 9 이하임
		// 이때 두 수의 합이 x인 경우의 수를 구하는 문제
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		visitArray(br);
	}

	private static void twoPointer(BufferedReader br) throws IOException {
		int max = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		int target = Integer.parseInt(br.readLine());
		br.close();

		int[] nums = new int[max];
		for (int i = 0; i < max; i++) {
			nums[i] = Integer.parseInt(arr[i]);
		}

		Arrays.sort(nums);

		int leftIndex = 0;
		int rightIndex = max - 1;
		int answer = 0;

		while (leftIndex < rightIndex) {
			int sum = nums[leftIndex] + nums[rightIndex];
			if (sum > target) {
				rightIndex--;
			} else if (sum < target) {
				leftIndex++;
			} else {
				answer++;
				leftIndex++;
				rightIndex--;
			}
		}

		System.out.println(answer);
	}

	private static void visitArray(BufferedReader br) throws IOException {
		int max = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		int targetNumber = Integer.parseInt(br.readLine());
		br.close();

		int[] nums = new int[max];
		for (int i = 0; i < max; i++) {
			nums[i] = Integer.parseInt(arr[i]);
		}

		boolean[] visited = new boolean[1000001];
		int count = 0;
		int needNumber = 0;
		for (int i = 0; i < max; i++) {
			needNumber = targetNumber - nums[i];
			if (needNumber >= 1 && needNumber < 1000000 && visited[needNumber]) {
				count++;
			}
			visited[nums[i]] = true;
		}
		System.out.println(count);
	}
}