import java.io.*;
import java.util.*;

public class Main {

    static boolean[] vst = new boolean[1001];
    static int[][] arr = new int[1001][1001];
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int v;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        v = Integer.parseInt(input[2]);

        for (int i = 0; i < m; ++i) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            arr[a][b] = arr[b][a] = 1;
        }
        dfs(v);
        System.out.println(sb);
        sb.setLength(0);
        vst = new boolean[1001];
        bfs(v);
    }

    public static void dfs(int start) {
        if (vst[start]) return;

        vst[start] = true;
        sb.append(start).append(" ");
        for (int i = 1; i <= n; ++i) {
            if (arr[start][i] == 1 && !vst[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        q.add(start);
        vst[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int i = 1; i <= n; ++i)  {
                if (arr[cur][i] == 1 && !vst[i]) {
                    vst[i] = true;
                    q.add(i);
                }
            }
        }
        System.out.println(sb);
    }
}
