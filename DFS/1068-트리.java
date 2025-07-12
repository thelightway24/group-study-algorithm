import java.io.*;
import java.util.*;

public class Main {
	static int ans;
	static List<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			// 1 <= n <= 50
			int n = Integer.parseInt(br.readLine());
			graph = new ArrayList[n]; // 그래프 선언
			for (int i = 0; i < n; i++) { // 각 노드마다 이어진 간선 노드들 기록해둘 arrayList 생성
				graph[i] = new ArrayList<>();
			}

			// 이건 단방향이라서 이전과 같은 구조를 가질 필요가 없다.
			// 몰랐는데 트리 구조와 같은 단방향이면 방문 배열이 필요없다.
			StringTokenizer st = new StringTokenizer(br.readLine());
			int root = -1;
			for (int i = 0; i < n; i++) {
				int parent = Integer.parseInt(st.nextToken());
				if (parent == -1) {
					root = i;
				} else {
					graph[parent].add(i);
				}
			}

			int deletedNode = Integer.parseInt(br.readLine());
			if (deletedNode == root) {
				bw.write("0");
				bw.flush();
				return;
			}

			ans = 0;
			dfs(root, deletedNode); // 무조건 root부터 탐색 시작.

			bw.write(ans + "");

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void dfs(int start, int deletedNode) {
		boolean isLeaf = true;
		for (int next : graph[start]) {
			if (next == deletedNode) continue;
			isLeaf = false;
			dfs(next, deletedNode);
		}
		if (isLeaf) {
			ans++;
		}
	}
}