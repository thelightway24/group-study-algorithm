import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] number = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> stack = new ArrayDeque<>();

		for(int i=0; i<n; i++){
			number[i] = Integer.parseInt(st.nextToken());
		}

		int[] answer = new int[n];
		for(int i=n-1; i>=0; i--){
			while(!stack.isEmpty() &&  number[i] >= stack.peek()){
				stack.pop();
			}

			if(stack.isEmpty()){
				answer[i] = -1;
			} else {
				answer[i] = stack.peek();
			}
			stack.push(number[i]);
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++){
			sb.append(answer[i]).append(' ');
		}

		System.out.println(sb);
	}
}
