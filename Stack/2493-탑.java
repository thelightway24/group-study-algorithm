import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());


		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] height = new int[n];
		for (int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		Deque<Integer> stack = new ArrayDeque<>();
		for(int i = 0; i < n; i++) {
			while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				sb.append('0').append(' ');
			} else {
				sb.append(stack.peek() + 1).append(' ');
			}
			stack.push(i);
		}
		System.out.println(sb);
	}
}