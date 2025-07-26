import java.io.*;
import java.util.*;

public class Main {
    /*
    <기본 입력>
     * 1. test case 수 입력
     * 2-1. 학생수 입력
     * 2-2. 희망 학생 입력
     <출력>
     각 test case 마다 팀에 속하지 않는 학생 수 출력
     * */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int students = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");

            int[] selArr = new int[students+1];
            boolean[] visited = new boolean[students+1];
            boolean[] finished = new boolean[students+1];

            for(int j = 1;j<= arr.length;j++) {
                selArr[j] = Integer.parseInt(arr[j-1]);
            }

            int matchCount = 0;
            for (int j = 1; j <= students; j++) {
                if(!visited[j]) {
                    matchCount = dfs(selArr, visited, finished,j,matchCount);

                }
            }
            sb.append(students-matchCount).append('\n');
        }
        System.out.println(sb);
    }

    private static int dfs(int[] sel, boolean[] visited, boolean[] finished,int current, int matchCount) {
        visited[current] = true;
        int next = sel[current];
        if(!visited[next]) {
            matchCount = dfs(sel,visited,finished,next, matchCount);
        }
        else {
            if(!finished[next]) { // 팀을 형성하지 않은 경우에 팀원수 계산
                int tmp = next;
                while(true) {
                    matchCount++;
                    if(tmp == current){
                        break;
                    }
                    tmp = sel[tmp];
                }
            }
        }
        finished[current] = true;
        return matchCount;
    }
}

