import java.io.*;
import java.util.*;

class Main {
    static char[][] puyo = new char[13][7];
    static boolean[][] visit = new boolean[13][7];
    static int[] dx = {-1, 1,  0, 0};
    static int[] dy = { 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // 뿌요 입력
        for (int row = 1; row < 13; row++) {
            char[] c = in.readLine().toCharArray();
            for (int col = 1; col < 7; col++) {
                puyo[row][col] = c[col-1];
            }
        }

        int pangCnt = 0;

        while (true) {
            boolean pangStat = false;
            for (int r = 1; r < 13; r++){
                Arrays.fill(visit[r], false);
			}
            
            Set<Integer> pangCols = new HashSet<>();

            for (int r = 1; r < 13; r++) {
                for (int c = 1; c < 7; c++) {
                    if (puyo[r][c] == '.' || visit[r][c]) continue;
                    List<int[]> group = bfs_4연속찾기(r, c);
                    if (group.size() >= 4) {
                        pangStat = true;
                        for (int[] pos : group) {
                            puyo[pos[0]][pos[1]] = '.';
                            pangCols.add(pos[1]);
                        }
                    }
                }
            }

            if (!pangStat) break;

            for (int col : pangCols) {
                gravity(col);
            }

            pangCnt++;
        }

        System.out.println(pangCnt);
    }

    static void gravity(int col) {
        for (int row = 11; row > 0; row--) {
            if (puyo[row][col] == '.') continue;

            int nextRow = row;
            while (nextRow + 1 < 13 && puyo[nextRow + 1][col] == '.') {
                puyo[nextRow + 1][col] = puyo[nextRow][col];
                puyo[nextRow][col] = '.';
                visit[nextRow + 1][col] = false;
                visit[nextRow][col] = false;
                nextRow++;
            }
        }
    }

    static List<int[]> bfs_4연속찾기(int row, int col) {
        List<int[]> result = new LinkedList<>();
        char color = puyo[row][col];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{row, col});
        result.add(new int[]{row, col});
        visit[row][col] = true;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = pos[0] + dx[i];
                int nextCol = pos[1] + dy[i];

                if (nextRow < 1 || nextRow > 12 || nextCol < 1 || nextCol > 6) continue;
                if (puyo[nextRow][nextCol] == color && !visit[nextRow][nextCol]) {
                    visit[nextRow][nextCol] = true;
                    q.add(new int[]{nextRow, nextCol});
                    result.add(new int[]{nextRow, nextCol});
                }
            }
        }
        return result;
    }
}
