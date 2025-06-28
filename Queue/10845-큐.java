import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();

        int orderNumber = Integer.parseInt(br.readLine());

        while (orderNumber-- > 0) {
            String order = br.readLine();

            if (order.startsWith("push")) {
                int targetInt = Integer.parseInt(order.substring(5));
                queue.addLast(targetInt);
            } else if (order.equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.removeFirst()).append('\n');
            } else if (order.equals("size")) {
                sb.append(queue.size()).append('\n');
            } else if (order.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append('\n');
            } else if (order.equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append('\n');
            } else if (order.equals("back")) {
                sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
            }

        }
        System.out.print(sb);
    }
}
