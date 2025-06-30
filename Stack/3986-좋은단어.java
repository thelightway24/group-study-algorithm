import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i =0; i<n ; ++i) {
            char[] testCase = br.readLine().toCharArray();
            if(isGoodWord(testCase)) count++;
        }
        System.out.println(count);
    }

    private static boolean isGoodWord(char[] arr) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: arr) {
            if(stack.isEmpty()) {
                stack.addLast(c);
            } else{
                if(stack.peekLast() == c) {
                    stack.pollLast();
                } else {
                    stack.addLast(c);
                }
            }
        }
        return stack.isEmpty();
    }
}