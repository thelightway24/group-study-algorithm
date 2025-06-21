import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		while(n-- > 0){
			StringTokenizer command = new StringTokenizer(br.readLine());
			if(command.countTokens() == 2) {
				command.nextToken();
				stack.push(Integer.parseInt(command.nextToken()));
			} else {
				String s = command.nextToken();
				if("top".equals(s)){
					if(stack.isEmpty()){
						sb.append("-1");
					} else {
						sb.append(stack.peek());
					}
				} else if("size".equals(s)){
					sb.append(stack.size());
				} else if("pop".equals(s)){
					if(stack.isEmpty()){
						sb.append("-1");
					} else {
						sb.append(stack.pop());
					}
				} else if("empty".equals(s)){
					if(stack.isEmpty()){
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}