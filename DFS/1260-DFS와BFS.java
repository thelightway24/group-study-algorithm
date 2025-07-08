import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int value;
        List<Integer> neighbors = new ArrayList<>();

        public Node(int value) {
            this.value = value;
        }

        public void addNeighbor(int value) {
            this.neighbors.add(value);
            Collections.sort(this.neighbors); // 정답에 맞도록 neighbor 삽입 시마다 오름차순으로 정렬 (시간 복잡도 올라갈 듯)
        }

        public List<Integer> getNeighbors() {
            return this.neighbors;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int edge = Integer.parseInt(input[1]);
        int start = Integer.parseInt(input[2]);

//        int[] dfsRes = new int[n];
//        int[] bfsRes = new int[n];
        StringBuilder dfsRes = new StringBuilder();
        StringBuilder bfsRes = new StringBuilder();


        int i;
//        List<Node> graph = new ArrayList<>(n);
        Node[] graph = new Node[n+1]; // 노드 번호 1부터 시작하므로, 0번째는 비워두고 노드 수 +1

        // 그래프 순회를 위한 방문배열 선언
        boolean[] visited = new boolean[n+1];
        boolean[] visited2 = new boolean[n+1];

        // 노드 수 만큼 먼저 노드 생성
        for(i=0;i<n;++i) {
            graph[i+1] = new Node(i+1); // 0번재 비워두고 1번째부터 Node 정보 추가
        }

        // 간선 정보 추가 (양방향 고려!!)
        for(i =0; i<edge; ++i) {
            String[] edgeInfo = br.readLine().split(" ");
            int src = Integer.parseInt(edgeInfo[0]);
            int dest = Integer.parseInt(edgeInfo[1]);
            graph[src].addNeighbor(dest);
            graph[dest].addNeighbor(src);
        }
        dfs(start, visited, graph, dfsRes);
        bfs(start, visited2, graph, bfsRes);
        System.out.println(dfsRes);
        System.out.println(bfsRes);
    }

    private static void dfs(int src, boolean[] visited, Node[] graph, StringBuilder sb) {
        Node cur = graph[src];
        visited[src] = true;
//        System.out.println(src);
        sb.append(src);
        List<Integer> neighbors = cur.getNeighbors();
        for(int neighbor: neighbors) {
            if(!visited[neighbor]) {
                sb.append(' ');
                dfs(neighbor, visited, graph, sb);
            }
        }
    }

    private static void bfs(int src, boolean[] visited, Node[] graph, StringBuilder sb) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[src] = true;
        queue.addFirst((src));

        boolean firstFlag = true;

        while(!queue.isEmpty()) {
            int visitingNode = queue.pollLast();
            if(firstFlag) {
                sb.append(visitingNode);
                firstFlag = false;
            } else {
                sb.append(' ').append(visitingNode);
            }

            for(int neighbor: graph[visitingNode].getNeighbors()) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.addFirst(neighbor);
                }
            }
        }
    }
}




