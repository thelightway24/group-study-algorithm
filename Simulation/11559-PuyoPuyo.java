import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx={0,1,-1,0};
    static final int[] dy={1,0,0,-1};
    static final int ROW = 12;
    static final int COL = 6;
    static char[][] mat = new char[ROW][COL];



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < ROW; i++) {
            char[] r = br.readLine().toCharArray();
            for (int j = 0; j < COL; j++) {
                mat[i][j] = r[j];
            }
        }
//        printMat();
        int chain = 0;
        while(true) {
            boolean[][] visited = new boolean[ROW][COL];
            boolean explode = false;

            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    if (mat[i][j] != '.' && !visited[i][j]) {
                        List<int[]> res = bfs(i, j, mat[i][j], visited);
                        if (res.size() >= 4) {
                            explode = true;
                            for (int[] pos : res) { // 터뜨리기
                                mat[pos[0]][pos[1]] = '.';
                            }
                        }
                    }
                }
            }

            if(!explode) { // 터질게 없으면 loop 탈출
                break;
            }

            slide(); // 터진 후에 아직 내려오지 않은 블럭 내리기
            chain++;
        }
        System.out.println(chain);
//        printMat();
    }



    private static boolean isInside(int r, int c) {
        return r>=0 && r<ROW && c>=0 && c<COL;
    }

    private static void printMat() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.printf("%c ", mat[i][j]);
            }
            System.out.println();
        }
    }

    private static List<int[]> bfs(int r, int c, char color, boolean[][] visited) {
        Deque<int[]> q = new ArrayDeque<>();
        List<int[]> res = new ArrayList<>();

        int[] pos = new int[]{r,c};
        visited[r][c] = true;

        q.addLast(pos);
        res.add(pos);

        while(!q.isEmpty()) {
            int[] cur = q.removeFirst();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0]+dx[i];
                int nc = cur[1]+dy[i];
                if(isInside(nr,nc) && !visited[nr][nc] && mat[nr][nc] == color) {
                    visited[nr][nc] = true;
                    int[] newPos = new int[]{nr,nc};
                    res.add(newPos);
                    q.addLast(newPos);
                }
            }
        }
        return res;
    }

    private static void slide() {
        // 좌측 세로줄부터 한줄씩 처리
        for (int col = 0; col < COL; col++) {
            int rowPtr = ROW-1;
            for (int row = ROW-1; row>= 0; row--) { // 가장 아래 가로줄 부터 위로 올라가며 탐색

                if(mat[row][col] != '.') { // 블록이 있는 곳을 방문하면 이동처리
                    mat[rowPtr][col] = mat[row][col]; // 가장 마지막 빈칸이 있는곳으로 블록 이동.
                    if(rowPtr != row) {
                        mat[row][col] = '.'; // 실제로 이동했으면, 탐색한 위치는 . 처리
                    }
                    rowPtr--; // 그다음 빈칸이 있는 윗줄로 이동시킴
                }
            }
        }
    }
}
