import java.io.*;
import java.util.*;
public class Main {
	public static void main (String[] a) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> numbers = new ArrayDeque<>();
		StringBuilder result = new StringBuilder();

		while(n-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			queueFunction: {
				switch (st.nextToken()) {
					case "push":
						numbers.offer(Integer.parseInt(st.nextToken()));
						break queueFunction;
					case "pop":
						if (numbers.isEmpty()) {
							result.append("-1");
						} else {
							result.append(numbers.poll());
						}
						break;
					case "size":
						result.append(numbers.size());
						break;
					case "empty":
						if (numbers.isEmpty()) {
							result.append("1");
						} else {
							result.append("0");
						}
						break;
					case "front":
						if (numbers.isEmpty()) {
							result.append("-1");
						} else {
							result.append(numbers.peekFirst());
						}
						break;
					case "back":
						if (numbers.isEmpty()) {
							result.append("-1");
						} else {
							result.append(numbers.peekLast());
						}
						break;
				}
				result.append('\n');
			}
		}
		System.out.println(result);
	}
}