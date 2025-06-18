import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int index = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            int inputVal = Integer.parseInt(br.readLine());

            for (; index <= inputVal; ++index) {
                st.push(index);
                sb.append("+\n");
            }
            if (st.peek() == inputVal) {
                st.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
