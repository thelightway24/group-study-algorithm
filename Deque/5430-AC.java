import java.io.*;
import java.util.*;
public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] a) throws Exception {
		//테스트 케이스 T 개수 입력
		int t = Integer.parseInt(br.readLine());

		StringBuilder st = new StringBuilder();
		while(t-- > 0){
			st.append(solve()).append("\n");
		}
		System.out.println(st);
	}
	private static String solve() throws Exception{
		// 수행할 명령
		char[] commands = br.readLine().toCharArray();
		br.readLine();
		// 배열에 들어있는 수
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input.substring(1,input.length()-1), ",");

		Deque<Integer> deque = new ArrayDeque<>();
		while(st.hasMoreTokens()){
			deque.offerLast(Integer.parseInt(st.nextToken()));
		}
		boolean reverse = false;
		for(char c : commands){
			switch(c) {
				case 'R':
					reverse = !reverse;
					break;
				case 'D':
					if(deque.isEmpty()){
						return "error";
					}
					if(!reverse){
						deque.pollFirst();
					} else {
						deque.pollLast();
					}
					break;
			}
		}

		StringBuilder result = new StringBuilder();
		if(deque.isEmpty()){
			return "[]";
		}
		result.append("[");
		if(!reverse){
			deque.forEach(n -> result.append(n).append(","));
		} else {
			while(!deque.isEmpty()){
				result.append(deque.pollLast()).append(",");
			}
		}
		result.deleteCharAt(result.length()-1).append("]");
		return result.toString();
	}
}