import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        int sum = 0;
        while(count-- > 0){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(!stack.isEmpty()){
                    sum -= stack.pop();
                }
            } else {
                sum += (stack.push(input));
            }
        }
        System.out.println(sum);
    }
}