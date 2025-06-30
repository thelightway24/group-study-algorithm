import java.io.*;
import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String input;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            input = br.readLine();
            if (goodWord(input)) ans++;
        }
        System.out.println(ans);
    }


    private static boolean goodWord(String input) {

        Deque<Character> st = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            if (st.isEmpty() || st.peekLast() != c) {
                st.addLast(c);
            } else {
                st.pollLast();
            }
        }

        return st.isEmpty();
    }

}