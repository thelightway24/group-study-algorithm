import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;   // 인접 리스트
    static boolean[] visited;       // 방문 여부 기록용
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 정점 수
        int M = Integer.parseInt(st.nextToken());   // 간선 수
        int V = Integer.parseInt(st.nextToken());   // 시작 정점

        /* ==== 그래프 초기화 ==== */
        graph = new ArrayList[N + 1];               // 1 번 정점부터 사용
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        /* ==== 간선 입력 ==== */
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);                        // 무방향 그래프
        }

        /* ==== 정점 번호 오름차순 방문을 위해 정렬 ==== */
        for (int i = 1; i <= N; i++) Collections.sort(graph[i]);

        /* ==== DFS ==== */
        visited = new boolean[N + 1];
        dfs(V);
        sb.append('\n');

        /* ==== BFS ==== */
        visited = new boolean[N + 1];
        bfs(V);

        /* ==== 결과 출력 ==== */
        System.out.print(sb.toString());
    }

    /* 깊이 우선 탐색(재귀 이용) */
    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(' ');

        for (int next : graph[v]) {
            if (!visited[next]) dfs(next);
        }
    }

    /* 너비 우선 탐색(큐 이용) */
    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int v = q.poll();
            sb.append(v).append(' ');

            for (int next : graph[v]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
