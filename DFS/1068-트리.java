import java.io.*;
import java.util.*;

public class Main {

    static int n, delete;
    static int[] tree;
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new int[n];
        int root = 0;
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < input.length; ++i) {
            tree[i] = Integer.parseInt(input[i]);
            if(tree[i] == -1) {
                root = i;
            }
        }
        delete = Integer.parseInt(br.readLine());
        dfs(root);
        System.out.println(ans);
    }


    public static void dfs(int x) {
        if (delete == x) {
            tree[x] = -2;
            return;
        }
        boolean flag = true;
        for (int i = 0; i < n; ++i) {
            if (tree[i] == x && i != delete) {
                flag = false;
                dfs(i);
            }
        }
        if (flag) ans++;
    }
}