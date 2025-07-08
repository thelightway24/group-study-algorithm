import java.io.*;
import java.util.ArrayDeque;

// stack 사용하지 않은 풀이
"""
public class Main {
    static int OPEN = 0;
    static int COUNT = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] testCase = br.readLine().toCharArray();
        solve(testCase);
        System.out.println(COUNT);
    }
    private static void solve(char[] arr) {
        for(int i =0 ;i<arr.length ;++i) {
            if(arr[i] == '(') {
                OPEN++;
            } else {
                OPEN--;
                if(arr[i-1] == '(') { // 레이저 감지 -> 열려있는 쇠막대기 수 만큼 막대기 수 증가
                    COUNT += OPEN;
                } else {
                    COUNT++; // 닫는 괄호가 연속되는 경우, 쇠막대기 마지막 조각 하나만 추가
                }
            }
        }
    }
}
"""

// stack 사용한 풀이
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] testCase = br.readLine().toCharArray();
        int count = solve(testCase);
        System.out.println(count);
    }
    private static int solve(char[] arr) {
        int count =0;
        Deque<Character> stack = new ArrayDeque<>();
        for(int i =0 ;i<arr.length ;++i) {
            if(arr[i] == '(') {
                stack.addLast('(');
            } else { // 닫는 괄호일 경우
                stack.pollLast();
                if(arr[i-1] == '(') { // 레이저 감지 -> 열려있는 쇠막대기 수 만큼 막대기 수 증가
                    count += stack.size();
                } else { // 막대기 닫기 -> 레이저로 잘렸지만 카운팅 되지 않은 하나의 조각 카운트 +1
                    count++;
                }
            }
        }
        return count;
    }
}