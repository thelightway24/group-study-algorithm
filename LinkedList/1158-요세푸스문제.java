import java.io.*
import java.util.*;

public class main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int size = Integer.parseInt(input[0]);
        int offset = Integer.parseInt(input[1]);


        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            queue.add(i + 1);
        }

        System.out.print("<");
        for (int i = 0; i < size; i++) {
            if(i != 0){
                System.out.print(", ");
            }
            int step = 1;
            while (step < offset) {
                queue.add(queue.remove());
                step++;
            }
            System.out.print(queue.remove());
        }
        System.out.print(">");
    }

}