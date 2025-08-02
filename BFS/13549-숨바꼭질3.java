import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
							.mapToInt(Integer::parseInt)
							.toArray();
		int subin = input[0];
		int target = input[1];
		int[] result = new int[100_001];
		Arrays.fill(result, Integer.MAX_VALUE);
		Deque<Integer> q = new ArrayDeque<>();

		result[subin] = 0;
		q.add(subin);
		while(!q.isEmpty()){
			int cur = q.pollFirst();
			if(cur == target) break;

			int telpo = cur * 2;
			if(telpo < 100_001 && result[telpo] > result[cur]){
				result[telpo] = result[cur];
				q.addFirst(telpo);
			}

			//뒤로
			int pre = cur - 1;
			if(pre >= 0 && pre < 100_001 && result[pre] > result[cur] + 1){
				result[pre] = result[cur] + 1;
				q.addLast(pre);
			}

			//앞으로
			int next = cur - 1;
			if(next >= 0 && next < 100_001 && result[next] > result[cur] + 1){
				result[next] = result[cur] + 1;
				q.addLast(next);
			}
		}
		System.out.println(result[target]);

	}
}