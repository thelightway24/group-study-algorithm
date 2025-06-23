import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] a) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		LinkedList<Integer> deque = new LinkedList<>();
		for(int i=1; i<=n; i++){
			deque.offerLast(i);
		}

		int m = Integer.parseInt(st.nextToken());
		StringTokenizer findValues = new StringTokenizer(br.readLine());

		int result = 0;
		while (m-- > 0){
			int target = Integer.parseInt(findValues.nextToken());
			while(deque.peekFirst() != target){
				if(deque.indexOf(target)> deque.size()/2){
					result++;
					deque.offerFirst(deque.pollLast());
				} else {
					result++;
					deque.offerLast(deque.pollFirst());
				}
			}
			deque.pollFirst();
		}
		System.out.println(result);
	}
}