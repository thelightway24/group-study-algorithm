import java.io.*;
import java.util.*;

public class Main {
    static int r, c, k;
    static int[][] arr = new int[101][101];
    static int row = 3, col = 3;

    static class Pair {
        int num, cnt;

        Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (time <= 100) {
            if (r - 1 < row && c - 1 < col && arr[r - 1][c - 1] == k) {
                System.out.println(time);
                return;
            }

            if (row >= col) operatorR();
            else operatorC();
            time++;
        }

        System.out.println(-1);
    }

    static void operatorR() {
        int maxCol = 0;
        int[][] newArr = new int[101][101];

        for (int i = 0; i < row; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < col; j++) {
                int val = arr[i][j];
                if (val == 0) continue;
                map.put(val, map.getOrDefault(val, 0) + 1);
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
                if (a.cnt == b.cnt) return a.num - b.num;
                return a.cnt - b.cnt;
            });

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                pq.add(new Pair(entry.getKey(), entry.getValue()));
            }

            int idx = 0;
            while (!pq.isEmpty() && idx < 100) {
                Pair p = pq.poll();
                newArr[i][idx++] = p.num;
                if (idx < 100) newArr[i][idx++] = p.cnt;
            }

            maxCol = Math.max(maxCol, idx);
        }

        arr = newArr;
        col = maxCol;
    }

    static void operatorC() {
        int maxRow = 0;
        int[][] newArr = new int[101][101];

        for (int i = 0; i < col; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < row; j++) {
                int val = arr[j][i];
                if (val == 0) continue;
                map.put(val, map.getOrDefault(val, 0) + 1);
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
                if (a.cnt == b.cnt) return a.num - b.num;
                return a.cnt - b.cnt;
            });

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                pq.add(new Pair(entry.getKey(), entry.getValue()));
            }

            int idx = 0;
            while (!pq.isEmpty() && idx < 100) {
                Pair p = pq.poll();
                newArr[idx++][i] = p.num;
                if (idx < 100) newArr[idx++][i] = p.cnt;
            }

            maxRow = Math.max(maxRow, idx);
        }

        arr = newArr;
        row = maxRow;
    }
}
