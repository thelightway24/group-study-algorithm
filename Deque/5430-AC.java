import java.io.*;
import java.util.*;

public class Main {

    static int t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; ++i) {
            sb.append(solve(br));
        }
        System.out.println(sb);
    }

    private static String solve(BufferedReader br) throws Exception {
        String tmp = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String p = br.readLine();
        Deque<Integer> dq = new ArrayDeque<>();
        p = p.substring(1, p.length() - 1);
        if (!p.isEmpty()) {
            String[] arr = p.split(",");
            for (String s : arr) dq.addLast(Integer.parseInt(s));
        }

        boolean flag = false;
        for (int i = 0; i < tmp.length(); ++i) {
            if (tmp.charAt(i) == 'R') flag = !flag;
            else {
                if (dq.isEmpty()) return "error\n";
                if (flag) dq.pollLast();
                else dq.pollFirst();
            }
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        int i = dq.size() - 1;
        if (flag) {
            for (; i >= 0; --i) {
                result.append(dq.pollLast());
                if (i != 0) result.append(",");
            }
        } else {
            for (; i >= 0; --i) {
                result.append(dq.pollFirst());
                if (i != 0) result.append(",");
            }
        }

        return result.append("]\n").toString();
    }
}