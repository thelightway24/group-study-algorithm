import java.io.*;
import java.util.*;

public class Main {

    /*
     * 전역 시간 카운트 변수 year
     * while 문.
     * count parts
     *
     * year +=1
     * melt
     *
     * 반복
     *
     * 탈출조건
     * 빙산 한번 녹이고 parts 수가 2보다 크거나 같으면 탈출
     *
     * */
    static final int[] dx={0,1,-1,0};
    static final int[] dy={1,0,0,-1};
    static int[][] ice;
    static int year = 0;
    static int r;
    static int c;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        r = Integer.parseInt(rc[0]);
        c = Integer.parseInt(rc[1]);
        ice = new int[r][c];

        for (int i = 0; i < r; i++) {
            String[] num = br.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                ice[i][j] = Integer.parseInt(num[j]);
            }
        }
        boolean[][] visited = new boolean[r][c];
        int[][] adj = new int[r][c];

        while(true) {
            int groups = 0;
//            boolean[][] visited = new boolean[r][c];
            initBooleanarr(visited);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(!visited[i][j] && ice[i][j] > 0) {
                        dfs(i,j,visited);
                        groups ++;
                    }
                }
            }
            if(groups >= 2) {
                System.out.print(year);
                return;
            } else if (groups == 0) {
                System.out.println(0);
                return;
            }
//            int[][] adj = new int[r][c];
            initIntarr(adj);
            year++;
            melt(adj);
            updateIce(adj);
//            printIce();
        }

    }

    private static void dfs(int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nr = row + dx[i];
            int nc = col + dy[i];

            if (isInside(nr, nc) && !visited[nr][nc] && ice[nr][nc] > 0) {
                dfs(nr,nc,visited);
            }
        }
    }

    private static void melt(int[][] adj) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(ice[i][j] > 0) {
                    for (int k = 0; k < 4; k++) {
                        int nr = i+dx[k];
                        int nc = j+dy[k];
                        if(isInside(nr,nc) && ice[nr][nc] == 0) {
                            adj[i][j]++;
                        }
                    }
                }

            }

        }
    }

    private static boolean isInside(int nr, int nc) {
        return nr >= 0 && nr < r && nc>=0 && nc <c;
    }

    private static void updateIce(int[][] adj) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ice[i][j] = Math.max(0, ice[i][j]-adj[i][j]);
            }
        }
    }

    private static void initIntarr(int[][] arr) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = 0;
            }
        }
    }
    private static void initBooleanarr(boolean[][] arr) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = false;
            }
        }
    }

    private static void printIce() {
        for (int i = 0; i < r ; i++) {
            for (int j = 0; j < c; j++) {
                System.out.printf("%d", ice[i][j]);
            }
            System.out.println();
        }
    }
}
