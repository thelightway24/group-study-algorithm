import java.io.*;
import java.util.*;

public class Main {

    static int[][] mat;
    static int N;
    static int CN;
    static int CZ;
    static int CP;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        mat = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] r = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                mat[i][j] = Integer.parseInt(r[j]);
            }
        }
        makePart(0,0,N);
        System.out.println(CN);
        System.out.println(CZ);
        System.out.println(CP);
    }
    private static void makePart(int r, int c, int size) {
        if(checkSameColor(r,c,size)) {
            switch(mat[r][c]) {
                case -1:
                    CN++;
                    break;
                case 0:
                    CZ++;
                    break;
                case 1:
                    CP++;
                    break;
            }
        } else {
            int partSize = size/3;

            makePart(r, c, partSize);
            makePart(r, c + partSize, partSize);
            makePart(r, c + 2 * partSize, partSize);
            makePart(r + partSize, c, partSize);
            makePart(r + partSize, c + partSize, partSize);
            makePart(r + partSize, c + 2 * partSize, partSize);
            makePart(r + 2 * partSize, c, partSize);
            makePart(r + 2 * partSize, c + partSize, partSize);
            makePart(r + 2 * partSize, c + 2 * partSize, partSize);
        }

    }

    private static boolean checkSameColor(int r, int c, int size) {
        int num = mat[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c+size; j++) {
                if(mat[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }

}
