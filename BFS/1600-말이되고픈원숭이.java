import java.io.*;
import java.util.*;

public class Main {
    /*
     * 원숭이 기본 이동 조건.
     * k번 만큼은 나이트처럼 이동 가능
     * 그 이후에는 dx dy 로만 이동 가능
     *
     * 목표
     * 최소한의 동작으로 시작->도착 지점 까지 갈 수 있는 최소 이동 수
     *
     * 입력
     * k
     * w h
     *
     * 출력
     * 목적지까지 가는데에 필요한 이동 수
     * */
    static final int[] hdr={-2,-1, 1, 2, 2, 1,-1,-2};
    static final int[] hdc={-1,-2,-2,-1, 1, 2, 2, 1};
    static final int[] dr={0,1,-1,0};
    static final int[] dc={1,0,0,-1};
    static int K;
    static int ROW;
    static int COL;
    static int[][] mat;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        String[] rc = br.readLine().split(" ");
        COL = Integer.parseInt(rc[0]);
        ROW = Integer.parseInt(rc[1]);
        mat = new int[ROW][COL];
        visited = new boolean [ROW][COL][K+1];
        for (int i = 0; i < ROW; i++) {
            String[] r = br.readLine().split(" ");
            for (int j = 0; j < COL; j++) {
                mat[i][j] = Integer.parseInt(r[j]);
            }
        }
        int dist= bfs();
        if(dist == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist);
        }

    }

    private static int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{0,0,0,0}); // row, col, knight move count, distance count
        visited[0][0][0] = true;
        while(!q.isEmpty()) {
            int[] cur = q.removeFirst();
            if(cur[0] == ROW-1 && cur[1] == COL-1) {
                return cur[3];
            }
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(isInside(nr,nc)) {
                    if(!visited[nr][nc][cur[2]] && mat[nr][nc] == 0) {
                        visited[nr][nc][cur[2]] = true;
                        q.addLast(new int[] {nr,nc, cur[2], cur[3]+1}); // 일반 이동인 경우 이동거리만 1증가 시켜 bfs 용 큐에 저장
                    }
                }
            }
            if(cur[2] < K) {
                for (int i = 0; i < 8; i++) {
                    int nr = cur[0] + hdr[i];
                    int nc = cur[1] + hdc[i];
                    if(isInside(nr,nc)) {
                        if(!visited[nr][nc][cur[2]+1] && mat[nr][nc] == 0) {
                            visited[nr][nc][cur[2]+1] = true;
                            q.addLast(new int[]{nr,nc, cur[2]+1,cur[3]+1});
                        }
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    private static boolean isInside(int nr, int nc) {
        return nr >=0 && nr < ROW && nc>=0 && nc < COL;
    }

}
