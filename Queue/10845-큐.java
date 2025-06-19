import java.io.*;
import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                int value = Integer.parseInt(input[1]);
                q.add(value);
            } else if (input[0].equals("pop")) {
                if (!q.isEmpty()) {
                    System.out.println(q.poll());
                } else {
                    System.out.println(-1);
                }
            } else if (input[0].equals("size")) {
                System.out.println(q.size());
            } else if (input[0].equals("empty")) {
                System.out.println(q.isEmpty() ? 1 : 0);
            } else if (input[0].equals("front")) {
                System.out.println(q.isEmpty() ? -1 : q.peekFirst());
            } else {
                System.out.println(q.isEmpty() ? -1 : q.peekLast());
            }
        }
    }
}
