import java.io.*;
import java.util.*;

public class Main{
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int currentValue = 1;
		Deque<Integer> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < n; i++){
			int expectValue = Integer.parseInt(br.readLine());
			while(currentValue <= expectValue) {
				stack.push(currentValue++);
				sb.append("+").append("\n");
			}
			if(stack.pop() != expectValue){
				System.out.println("NO");
				System.exit(0);
			} else {
				sb.append("-").append("\n");
			}
		}
		System.out.println(sb);
	}
}