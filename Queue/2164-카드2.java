import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> st = new ArrayDeque<>(n);
        for(int i=n; i>0;i--) {
            st.addLast(i);
        }

        boolean popFlag = true;
        while (st.size() != 1) {
            if(popFlag) {
                st.pollLast();
                popFlag = false;
            } else {
                st.addFirst(st.pollLast());
                popFlag = true;
            }
        }

        System.out.println(st.peek());
    }
}
