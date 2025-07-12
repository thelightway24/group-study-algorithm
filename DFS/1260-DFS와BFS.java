import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[] visit;
	static int[][] graph;

	public static void bfs(int v) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visit[v] = true;

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			bw.write(cur + " ");

			for (int i = 1; i < graph[cur].length; i++) {
				if (graph[cur][i] == 1 && !visit[i]) {
					queue.add(i);
					visit[i] = true;
				}
			}
		}
	}

	public static void main(String a[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer conditionToken = new StringTokenizer(br.readLine());

		// 정점 개수 N
		int N = Integer.parseInt(conditionToken.nextToken());

		// 간선 개수 M
		int M = Integer.parseInt(conditionToken.nextToken());

		// 시작할 정점 번호 V
		int V = Integer.parseInt(conditionToken.nextToken());
		visit = new boolean[N + 1];
		graph = new int[N + 1][N + 1];

		// 입력
		while (M-- > 0) {
			StringTokenizer numToken = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(numToken.nextToken());
			int value = Integer.parseInt(numToken.nextToken());
			graph[key][value] = graph[value][key] = 1;
		}
		dfs(V);

		bw.write("\n");
		visit = new boolean[N + 1];
		bfs(V);
		bw.flush();
	}

	public static void dfs(int v) throws IOException {
		visit[v] = true;
		bw.write(v + " ");

		for (int i = 1; i < graph.length; i++) {
			if (graph[v][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}
}