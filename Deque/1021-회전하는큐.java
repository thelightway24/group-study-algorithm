import java.io.*;
import java.util.*;

public class Main {

    static int n, m, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; ++i)  dq.add(i + 1);
        input = br.readLine().split(" ");

        for (int i = 0; i < m; ++i) {
            int val = Integer.parseInt(input[i]);
            int tmp = dq.size() / 2;
            int idx = new ArrayList<>(dq).indexOf(val);
            while (dq.peekFirst() != val) {
                if (idx <= tmp) {
                    dq.addLast(dq.pollFirst());
                } else {
                    dq.addFirst(dq.pollLast());
                }
                ans++;
            }
            dq.pollFirst();
        }
        System.out.println(ans);
    }
}
