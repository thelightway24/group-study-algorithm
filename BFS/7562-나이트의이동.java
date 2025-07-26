//import java.io.*;
//import java.util.*;
//
//public class Main {
//    /*
//    <기본 입력>
//     * 1. test case 수 입력
//     * 2-1. 체스판 사이즈 입력
//     * 2-2. 현재 칸 입력
//     * 2-3. 목표 칸 입력
//     <출력>
//     각 test case 마다 최소 이동 횟수 출력
//     * */
//    private static class Pos {
//        int row;
//        int col;
//
//        // move rules
//        private static final int[] dx = {-2,-1,1,2,2,1,-1,-2};
//        private static final int[] dy = {-1,-2,-2,-1,1,2,2,1};
//
//        public Pos(int row, int col) {
//            this.row = row;
//            this.col = col;
//        }
//
//        public Pos move(int dRow, int dCol) {
//            return new Pos(this.row + dRow, this.col + dCol);
//        }
//
//        public boolean isInside(int size, int row, int col) {
//            return row >= 0 && row < size && col >= 0 && col < size;
//        }
//
//        public boolean match(Pos other) {
//            return this.row == other.row && this.col == other.col;
//        }
//
//        public List<Pos> getNextPositions(int size) {
//            List<Pos> next = new ArrayList<>();
//            for (int i = 0; i < 8; i++) {
//                int nr = row + dx[i];
//                int nc = col + dy[i];
//                if (isInside(size,nr,nc)) {
//                    next.add(move(dx[i],dy[i]));
//                }
//            }
//            return next;
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int n = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < n; i++) {
//            int size = Integer.parseInt(br.readLine());
//            String[] start = br.readLine().split(" ");
//            Pos startPos = new Pos(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
//            String[] dest = br.readLine().split(" ");
//            Pos destPos = new Pos(Integer.parseInt(dest[0]), Integer.parseInt(dest[1]));
//            int count = bfs(size,startPos,destPos);
//            sb.append(count).append('\n');
//        }
//        System.out.println(sb);
//    }
//
//    private static int bfs(int size, Pos start, Pos dest) {
//        if(start.match(dest)) {
//            return 0;
//        }
//
//        int[][] table = new int[size][size];
//        for(int i=0;i<size;i++){ // table 초기화
//            for(int j=0;j<size;j++) {
//                table[i][j] = -1;
//            }
//        }
//        Deque<Pos> q = new ArrayDeque<>();
//        q.addLast(start);
//        table[start.row][start.col] += 1;
//        while(!q.isEmpty()) {
//            Pos current = q.removeFirst();
//            for(Pos next: current.getNextPositions(size)) {
//                if(table[next.row][next.col] == -1) { // 아직 방문하지 않은 좌표만 방문
//                    table[next.row][next.col] = table[current.row][current.col] + 1; // 누적 이동횟수를 다음 방문위치에 저장 (방문처리)
//                    if(next.match(dest)) { // 다음에 목표 좌표 도달하면 해당 위치의 누적 이동횟수 리턴
//                        return table[next.row][next.col];
//                    }
//                    q.addLast(next); // bfs 큐에 쌓기
//                }
//            }
//        }
//        return -2; // 나이트 체스판 순회문제에서는 도달 불가능한 좌표가 없긴하다는데..? 일단은 기본값 리턴
//    }
//
//
//}
//


import java.io.*;
import java.util.*;

public class Main {

    // 나이트 이동 규칙
    private static final int[] dx = {-2,-1,1,2,2,1,-1,-2};
    private static final int[] dy = {-1,-2,-2,-1,1,2,2,1};

    private static class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int size = Integer.parseInt(br.readLine());
            String[] start = br.readLine().split(" ");
            Pos startPos = new Pos(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
            String[] dest = br.readLine().split(" ");
            Pos destPos = new Pos(Integer.parseInt(dest[0]), Integer.parseInt(dest[1]));

            int result = bfs(size, startPos, destPos);
            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }

    private static int bfs(int size, Pos start, Pos dest) {
        if (match(start.row, start.col, dest.row, dest.col)) {
            return 0;
        }

        int[][] visited = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                visited[i][j] = -1;
            }
        }
        Deque<Pos> q = new ArrayDeque<>();

        q.add(start);
        visited[start.row][start.col] = 0;

        while (!q.isEmpty()) {
            Pos cur = q.removeFirst();

            for (int i = 0; i < 8; i++) {
                int nr = cur.row + dx[i];
                int nc = cur.col + dy[i];

                if (!isInside(size, nr, nc)) {
                    continue;
                }

                if(visited[nr][nc] != -1) {
                    continue;
                }

                visited[nr][nc] = visited[cur.row][cur.col]+1;

                if(match(nr,nc, dest.row, dest.col)) {
                    return visited[nr][nc];
                }
                q.add(new Pos(nr, nc));
            }
        }

        return -1;
    }

    private static boolean isInside(int size, int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    private static boolean match(int r, int c, int nr, int nc) {
        return r== nr && c == nc;
    }
}

