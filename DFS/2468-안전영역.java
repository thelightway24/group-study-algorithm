import java.io.*;
import java.util.*;

public class Main {
    /*
    <기본 입력>
     * 1. matrix 사이즈 입력 n => n x n
     * 2. n 줄만큼 n 개의 지역의 높이 정보 입력
     <로직>
     !! 물의 높이는 1<= h <= 100 인 정수
     안전영역 판단 로직 필요 (해당 영역이 기존 영역에 포함되는지 또는 새로운 영역을 만들어 내는지 판정)
     * */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int matSize = Integer.parseInt(br.readLine());
        int[][] mat = new int[matSize][matSize];
        int i, j;
        for (i = 0; i < matSize; ++i) {
            String[] input = br.readLine().split(" ");
            for (j = 0; j < matSize; ++j) {
                int h = Integer.parseInt(input[j]);
                mat[i][j] = h;
            }
        }

        int maxArea = 0;
        for(int height = 0; height<=100; ++height) {
            int ithArea = getAreaCount(height, mat, matSize);
            if (ithArea > maxArea) {
                maxArea = ithArea;
            }
        }
        System.out.println(maxArea);

    }

    private static int getAreaCount(int height, int[][] mat, int matSize) {
        boolean[][] visited = new boolean[matSize][matSize];
        int areaCount = 0;
        for (int i = 0; i < matSize; ++i) {
            for (int j = 0; j < matSize; j++) {
                if (!visited[i][j] && mat[i][j] > height) {
                    areaCount++;
                    dfs(height, mat, visited, matSize, i, j);
                }
            }
        }
        return areaCount;
    }

    private static void dfs(int height, int[][] mat, boolean[][] visited, int matSize, int row, int col) {
        if(visited[row][col]) return;
        visited[row][col] = true;
        //위쪽 탐색
        if (row - 1 >= 0) {
            if (!visited[row - 1][col]) {
                if (mat[row - 1][col] > height) {
                    dfs(height, mat, visited, matSize, row - 1, col);
                }
            }
        }
        //아래쪽 탐색
        if (row + 1 < matSize) {
            if (!visited[row + 1][col]) {
                if (mat[row + 1][col] > height) {
                    dfs(height, mat, visited, matSize, row + 1, col);
                }
            }
        }
        //좌측 탐색
        if (col - 1 >= 0) {
            if (!visited[row][col - 1]) {
                if (mat[row][col - 1] > height) {
                    dfs(height, mat, visited, matSize, row, col - 1);
                }
            }
        }
        // 우측 탐색
        if (col + 1 < matSize) {
            if (!visited[row][col + 1]) {
                if (mat[row][col + 1] > height) {
                    dfs(height, mat, visited, matSize, row, col + 1);
                }
            }
        }
    }
}

