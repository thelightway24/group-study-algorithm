import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();


        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command) {
                case "push_back" : {
                    int num = Integer.parseInt(st.nextToken());
                    queue.addLast(num);
                    break;
                }
                case "push_front" : {
                    int num = Integer.parseInt(st.nextToken());
                    queue.addFirst(num);
                    break;
                }

                case "pop_front" : {
                    if(queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(queue.pollFirst()).append("\n");
                    }
                    break;
                }
                case "pop_back" : {
                    if(queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(queue.pollLast()).append("\n");
                    }
                    break;
                }
                case "size" :
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty" :
                    if(queue.isEmpty()) {
                        sb.append(1).append("\n");
                    }
                    else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front" :
                    if(queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(queue.peekFirst()).append("\n");
                    }
                    break;
                case "back" :
                    if(queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(queue.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }


}


