import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int ROW;
    static int COL;
    static int[][] mat;
    static int R;
    static int C;
    static Dice DICE;

    private static class Dice {
        int top;
        int bottom;
        int front;
        int back;
        int left;
        int right;

        public Dice(int top, int bottom, int front, int back, int left, int right) {
            this.top = top;
            this.bottom = bottom;
            this.front = front;
            this.back = back;
            this.left = left;
            this.right = right;
        }

        public void rollEast() {
            int temp = top;
            this.top = this.left;
            this.left = this.bottom;
            this.bottom = this.right;
            this.right = temp;
        }

        public void rollWest() {
            int temp = top;
            this.top = this.right;
            this.right = this.bottom;
            this.bottom = this.left;
            this.left = temp;
        }

        public void rollNorth() {
            int temp = top;
            this.top = this.front;
            this.front = this.bottom;
            this.bottom = this.back;
            this.back = temp;
        }

        public void rollSouth() {
            int temp = top;
            this.top = this.back;
            this.back = this.bottom;
            this.bottom = this.front;
            this.front = temp;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        ROW = Integer.parseInt(info[0]);
        COL = Integer.parseInt(info[1]);
        R = Integer.parseInt(info[2]);
        C = Integer.parseInt(info[3]);
        N = Integer.parseInt(info[4]);
        mat = new int[ROW][COL];
//        DICE = new Dice(1,6,5,2,4,3);
        DICE = new Dice(0,0,0,0,0,0);
        for (int i = 0; i < ROW; i++) {
            String[] r = br.readLine().split(" ");
            for (int j = 0; j < COL; j++) {
                mat[i][j] = Integer.parseInt(r[j]);
            }
        }
        String[] cmds = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            moveDice(Integer.parseInt(cmds[i]));
        }
    }

    private static void moveDice(int command) {
        if(command == 4) { // 남쪽이동
            int nr = R+1;
            if(nr >= ROW) {
                return;
            }
            R = nr;
            DICE.rollSouth();
        } else if(command == 3) { // 북쪽이동
            int nr = R-1;
            if(nr < 0) {
                return;
            }
            R = nr;
            DICE.rollNorth();
        } else if(command == 2) { // 서쪽 이동
            int nc = C-1;
            if(nc<0) {
                return;
            }
            C = nc;
            DICE.rollWest();
        } else if (command == 1) {
            int nc = C+1;
            if(nc>=COL) {
                return;
            }
            C = nc;
            DICE.rollEast();
        }
        if(mat[R][C] == 0) {
            mat[R][C] = DICE.bottom;
        } else {
            DICE.bottom = mat[R][C];
            mat[R][C] = 0;
        }
        System.out.println(DICE.top);
    }
}
