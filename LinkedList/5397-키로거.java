import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            String str = br.readLine();
            solve(str);
        }
    }

    private static void solve(String str) {
        LinkedList<Character> ll = new LinkedList<>();
        ListIterator<Character> it = ll.listIterator(ll.size());
        for (char c: str.toCharArray()) {
            if (c == '<') {
                if (it.hasPrevious()) it.previous();
            } else if (c == '>') {
                if (it.hasNext()) it.next();
            } else if (c == '-' ) {
                if (it.hasPrevious()) {
                    it.previous();
                    it.remove();
                }
            } else {
                it.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : ll) sb.append(c);
        System.out.println(sb);
    }



}

