import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] testCase = br.readLine().toCharArray();
        int count = solve(testCase);
        System.out.println(count);
    }
    private static int solve(char[] arr) {
        int number = 1;
        int total = 0;
        Deque<Character> stack = new ArrayDeque<>();
        fun:
        {
            for (int i = 0; i < arr.length; ++i) {
                switch (arr[i]) {
                    case '(': {
                        stack.addLast(arr[i]);
                        number *= 2;
                        break;
                    }
                    case '[': {
                        stack.addLast(arr[i]);
                        number *= 3;
                        break;
                    }
                    case ')': {
                        if (stack.isEmpty() || stack.peekLast() == '[') { // 비정상 괄호 체크
                            total = 0;
                            break fun;
                        }

                        if (arr[i - 1] == '(') {
                            total += number;
                        }
                        stack.pollLast(); //괄호 닫힘 처리
                        number /= 2; // 괄호 열릴 때 곱해준 수 원상 복구
                        break;
                    }
                    case ']': {
                        if (stack.isEmpty() || stack.peekLast() == '(') { // 비정상 괄호 체크
                            total = 0;
                            break fun;
                        }
                        if (arr[i - 1] == '[') {
                            total += number;
                        }
                        stack.pollLast(); //괄호 닫힘 처리
                        number /= 3; // 괄호 열릴 때 곱해준 수 원상 복구
                        break;
                    }
                }
            }
        }
        if(!stack.isEmpty()) total = 0;
        return total;
    }
}



