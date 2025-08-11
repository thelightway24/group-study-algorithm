import java.io.*;
import java.util.*;
public class Main {
	public static void main (String[] a) throws Exception {
		Deque<Integer> queue = new ArrayDeque<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int n = Integer.parseInt(br.readLine());
			for(int i=1; i<=n; i++){
				queue.offer(i);
			}
		}

		while(queue.size() != 1){
			queue.poll();
			queue.offer(queue.poll());
		}
		System.out.println(queue.poll());

	}
}