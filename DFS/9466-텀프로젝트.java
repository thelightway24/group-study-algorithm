import java.io.*;
import java.util.*;

public class Main {

    static int t, n;
    static int[] students;
    static boolean[] vst;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t  = Integer.parseInt(br.readLine());
        String[] input;

        for (int i = 0; i < t; ++i)  {
            n = Integer.parseInt(br.readLine());
            students = new int[100001];
            input = br.readLine().split(" ");
            for (int j = 1; j <= n; ++j) students[j] = Integer.parseInt(input[j - 1]);

            vst = new boolean[100001];
            finished = new boolean[100001];
            count = 0;

            for (int j = 1; j <= n; ++j) {
                if (!vst[j]) {
                    dfs(j);
                }
            }

            System.out.println(n - count);
        }
    }

    public static void dfs(int x) {
        vst[x] = true;
        int next = students[x];

        if (!vst[next]) {
            dfs(next);
        } else if (!finished[next]) {
            for (int cur = next; cur != x; cur = students[cur]) {
                count++;
            }
            count++;
        }

        finished[x] = true;
    }
}
