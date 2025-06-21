import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] heights = new int[n];

		for(int i = 0; i < n; i++){
			heights[i] = Integer.parseInt(br.readLine());
		}

		long sum = 0;
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			int h = heights[i];
			while (!stack.isEmpty() && stack.peek() <= h) {
				stack.pop();
			}
			sum += stack.size();
			stack.push(h);
		}
		System.out.println(sum);
	}
}

public class 초기풀이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] height = new int[n];
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(br.readLine());
			queue.add(i);
		}

		long sum = 0L;
		while(!queue.isEmpty()) {
			int index = queue.poll();
			int s = height[index];
			for(int i = index + 1; i < n; i++) {
				if(height[i] < s) {
					sum++;
				} else {
					break;
				}
			}
		}
		System.out.println(sum);
	}
}