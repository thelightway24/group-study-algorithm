import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited; // 방문 배열
	static List<Integer>[] graph; // 그래프 (=인접 리스트)
	static StringBuilder sb = new StringBuilder(); // 매번 매개변수로 bw를 넘겨주는게 비효율적이라 sb 선언.

	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 1 <= n <= 1,000, 1 <= m <= 10,000
			int n = Integer.parseInt(st.nextToken()); //정점 개수
			int m = Integer.parseInt(st.nextToken()); //간선 개수
			int v = Integer.parseInt(st.nextToken()); //검색을 시작할 정점의 값

			graph = new ArrayList[n + 1]; // 그래프 = 인접 리스트 = 각 정점이 어떤 정점과 연결되어있는지 기록함
			// ex) graph[3] = [1, 4, 5];  // 정점 3은 정점 1, 4, 5와 연결되어 있음

			// 각 정점마다 리스트(자신과 간선으로 이어져있는 정점을 보여줄)를 생성해줌
			for (int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}

			// 입력값으로 들어온 간선들을 graph 에 저장
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}

			// 방문할 수 있는 정점이 여러개일 경우 정점 번호가 작은 것을 먼저 방문하기 정렬을 해놓는다.
			for (int i = 1; i <= n; i++) {
				Collections.sort(graph[i]);
			}
			/*
			 * ex) graph[3] = [5, 4, 1]; 같이 정점 3에서 갈 수 있는 정점이 3가지이고 모두 갈 수 있을 경우,
			 *     작은 수부터 가야 하기 때문에(문제조건) 미리 정렬을 해놓는 것.
			 */

			// 이제 기초 세팅이 되었고, 각각 dfs와 bfs로 로직을 돌리고 출력하면 된다.

			//DFS
			visited = new boolean[n + 1];
			dfs(v);
			sb.append('\n');

			//BFS
			visited = new boolean[n + 1];
			bfs(v);

			bw.write(sb.toString());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void dfs(int current) {
		visited[current] = true; // 방문 배열에 방문 체크
		sb.append(current).append(' '); // 출력

		for (int next : graph[current]) { // 정점에 연결된 모든 정점들을 작은 번호 순으로 반복문을 돌림.
			if (!visited[next]) { // 만약 방문안한 정점이 있으면 재귀처리
				dfs(next);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>(); // 큐 선언
		visited[start] = true; // 첫 정점 방문처리
		q.offer(start); // offer() 는 add()와 같은 기능을 하는 유사한 메서드

		while (!q.isEmpty()) {
			int current = q.poll(); // 큐에 가장 뒤에 있는 정점 출력
			sb.append(current).append(' ');

			for (int next : graph[current]) { // 출력한 정점과 연결된 정점을 작은 순부터 반복문 처리
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next); // dfs와 달리 재귀를 타지 않고, 큐에 쌓아놓게 됨. 따라서 current 정점의 모든 연결 정점들을 큐에 저장해놓고, 저장된 정점들을 하나씩 빼게 됨.
				}
			}
		}
	}

}