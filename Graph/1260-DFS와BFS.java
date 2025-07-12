import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static boolean[] visited;
	private static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		visited = new boolean[N + 1];
		dfs(V);
		System.out.println();

		visited = new boolean[N + 1];
		bfs(V);
		System.out.println();
	}

	private static void dfs(int node) {
		visited[node] = true;
		System.out.print(node + " ");
		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			for (int next : graph[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
	}
}
