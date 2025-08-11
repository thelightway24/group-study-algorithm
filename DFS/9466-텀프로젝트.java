import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] visit;
	static boolean[] fin;
	static int[] selectMap;
	static int count;

	public static void main (String[] a) throws Exception {
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		while(testCase-->0){
			result.append(solve());
			result.append("\n");
		}
		System.out.println(result);
	}
	static int solve() throws Exception {
		int peopleCnt = Integer.parseInt(br.readLine());
		StringTokenizer selectToken = new StringTokenizer(br.readLine());

		selectMap = new int[peopleCnt+1];
		visit = new boolean[peopleCnt+1];
		fin = new boolean[peopleCnt+1];
		count = 0;

		for(int i=1; i<peopleCnt+1; i++){
			selectMap[i] = Integer.parseInt(selectToken.nextToken());
		}

		for (int i = 1; i <= peopleCnt; i++) {
			if (!visit[i]) {
				dfs(i);
			}
		}
		return peopleCnt - count;


	}
	static void dfs(int start){
		visit[start] = true;
		int next = selectMap[start];
		if(!visit[next]){
			dfs(next);
		}
		else {
			if(!fin[next]){
				count++;
				for(int i=next; i != start; i= selectMap[i]){
					count++;
				}
			}
		}
		fin[start] = true;
	}
}