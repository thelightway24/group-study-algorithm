import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Deque<Integer> ans = new ArrayDeque<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; --i) {
            while (!st.isEmpty() && st.peek() <= arr[i]) st.pop();
            if (st.isEmpty()) ans.addLast(-1);
            else ans.add(st.peek());
            st.push(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            sb.append(ans.pollLast()).append(" ");
        }
        System.out.println(sb);
    }
}
