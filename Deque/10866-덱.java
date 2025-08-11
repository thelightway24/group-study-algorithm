import java.io.*;
import java.util.*;
public class Main {
    public static void main (String[] a) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder result = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        while (n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            fun: {
                switch (st.nextToken()){
                    case "push_front":
                        deque.addFirst(Integer.parseInt(st.nextToken()));
                        break fun;
                    case "push_back":
                        deque.addLast(Integer.parseInt(st.nextToken()));
                        break fun;
                    case "pop_front":
                        if(deque.isEmpty()){
                            result.append("-1");
                        } else {
                            result.append(deque.pollFirst());    
                        }
                        break;
                    case "pop_back":
                        if(deque.isEmpty()){
                            result.append("-1");
                        } else {
                            result.append(deque.pollLast());    
                        }
                        break;
                    case "size":
                        result.append(deque.size());
                        break;
                    case "empty":
                        if(deque.isEmpty()){
                            result.append("1");
                        } else {
                            result.append("0");    
                        }
                        break;
                    case "front":
                        if(deque.isEmpty()){
                            result.append("-1");
                        } else {
                            result.append(deque.peekFirst());    
                        }
                        break;
                    case "back":
                        if(deque.isEmpty()){
                            result.append("-1");
                        } else {
                            result.append(deque.peekLast());    
                        }
                        break;
                }
                result.append("\n");
            }
            
        }
        System.out.println(result);
    }
}