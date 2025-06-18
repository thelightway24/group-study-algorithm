import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] heights;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        heights = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; ++i)  {
            heights[i] = Integer.parseInt(input[i]);
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; ++i) {
            while(!st.isEmpty() && heights[st.peek()] < heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(st.peek() + 1).append(" ");
            }
            st.push(i);
        }
        System.out.println(sb);
    }


}
