import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] select; // 각 학생이 선택한 학생
	static boolean[] visited; // DFS 방문 여부
	static boolean[] finished; // 해당 노드 DFS가 끝났는지
	static int teamCount; // 팀에 속한 학생 수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());
			select = new int[n + 1];
			visited = new boolean[n + 1];
			finished = new boolean[n + 1];
			teamCount = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				select[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					dfs(i);
				}
			}

			sb.append(n - teamCount).append('\n');
		}
		System.out.print(sb);
	}

	static void dfs(int node) {
		visited[node] = true;
		int next = select[node];

		if (!visited[next]) {
			dfs(next);
		} else if (!finished[next]) {
			teamCount += countCycle(next);
		}

		finished[node] = true;
	}

	static int countCycle(int start) {
		int count = 1;
		for (int i = select[start]; i != start; i = select[i]) {
			count++;
		}
		return count;
	}
}