import java.io.*;


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