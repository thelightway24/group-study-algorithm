import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx={-1,1};
    static int n;
    static int k;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        n = Integer.parseInt(rc[0]);
        k = Integer.parseInt(rc[1]);
        int ans = bfs(n);
        System.out.println(ans);
    }

    private static int bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] time = new int [100001]; // 각 위치에 도달하는데 필요한 최소 시간 저장 배열
        for (int i = 0; i < 100001; i++) {
            time[i] = -1;
        }
        time[start] = 0;
        q.addLast(start);

        while(!q.isEmpty()) {
            int cur = q.removeFirst();
            if(cur == k) {
                return time[cur];
            }

            int pos = 2*cur;
            // 순간이동은 0초만에 가능하기 때문에 순간이동 먼저처리
            if(isInside(pos) && time[pos] == -1) {
                time[pos] = time[cur];
                q.addFirst(pos); // 순간이동은 먼저처리해야하기 때문에 큐의 전단에 추가
            }
            for (int i = 0; i < 2; i++) {
                int walk = cur+dx[i];
                if(isInside(walk) && time[walk] == -1) {
                    time[walk] = time[cur] + 1;
                    q.addLast(walk);
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    private static boolean isInside(int pos) {
        return pos>=0 && pos<=100000;
    }
}
