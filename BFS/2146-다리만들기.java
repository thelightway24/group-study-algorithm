import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx={0,1,-1,0};
    static final int[] dy={1,0,0,-1};
    static int[][] mat;
    static int groups = 0;
    static int n;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        n = Integer.parseInt(rc[0]);
        mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] num = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(num[j])==1 ? -1 : 0;
            }
        }
        boolean[][] visited = new boolean[n][n];

        // 섬 구분하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && mat[i][j] == -1) {
                    groups++;
                    dfs(i,j,visited);
                }
            }
        }
        //printIce();
        int dist = 300;
        for (int i = 1; i <= groups; i++) {
            dist = Math.min(dist,bfs(i));
        }
        System.out.println(dist);
    }

    private static void dfs(int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        mat[row][col] = groups;
        for (int i = 0; i < 4; i++) {
            int nr = row + dx[i];
            int nc = col + dy[i];

            if (isInside(nr, nc) && !visited[nr][nc] && mat[nr][nc] == -1) {
                dfs(nr,nc,visited);
            }
        }
    }


    private static int bfs(int g) {
        Deque<int[]> q = new ArrayDeque<>();
        int[][] dist = new int [n][n];
        // dist 배열 초기화 (방문 여부 + 이동 거리 체크용 배열)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = -1;
            }
        }

        // 거리 계산 대상인 섬에서 테두리 따기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == g) {
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dx[k];
                        int nc = j + dy[k];
                        if (isInside(nr, nc) && mat[nr][nc] == 0) {
                            q.addLast(new int[]{i, j});
                            dist[i][j] = 0; // 테두리인 경우 거리계산 시작점 이므로 거리 계산을 위해 0으로 초기화
                            break;
                        }
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int row = cur[0];
            int col = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = row + dx[i];
                int nc = col + dy[i];
                if (!isInside(nr, nc)) continue;
                if (mat[nr][nc] != 0 && mat[nr][nc] != g) {
                    // 다른 섬 도달
                    return dist[row][col];
                }
                if (mat[nr][nc] == 0 && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[row][col] + 1; // 새로 이동한 바다 칸의 dist에는 기존 칸+1 로 기록하여 이동거리 저장
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return 300;
    }

    private static boolean isInside(int nr, int nc) {
        return nr >= 0 && nr < n && nc>=0 && nc <n;
    }






    private static void printIce() {
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d", mat[i][j]);
            }
            System.out.println();
        }
    }
}
