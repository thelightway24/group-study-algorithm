import java.io.*;
import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        /*
        * size를 명시해서 Deque를 초기화하면
        * 1316ms -> 1280ms으로 줄어드는것을 볼 수 있다.
        * */
        Deque<Integer> q = new ArrayDeque<>(2000001);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                int value = Integer.parseInt(input[1]);
                q.add(value);
            } else if (input[0].equals("pop")) {
                if (!q.isEmpty()) {
                    sb.append(q.poll()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (input[0].equals("size")) sb.append(q.size()).append("\n");
            else if (input[0].equals("empty")) sb.append(q.isEmpty() ? 1 : 0).append("\n");
            else if (input[0].equals("front")) sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
            else sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
        }
        System.out.println(sb);
    }
}
