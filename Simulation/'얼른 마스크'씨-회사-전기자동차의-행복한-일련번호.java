import java.io.*;
import java.util.*;

/*
* 문제 규칙 찾기 과정
* 1 -  1*1 =1 -> 행복 수
* 2 - 2*2=4 -> 4*4=16 -> 1*1+6*6=37 -> 3*3+7*7=58 -> 5*5+8*8=89 -> 8*8+9*9=145 -> 1*1+4*4+5*5=42 -> 4*4+2*2=20 -> 2*2=4 -> 4*4=16 무한 반복
* 3 - 3*3=9 -> 9*9=81 -> 8*8+1*1=65 -> 6*6+5*5=61 -> 6*6+1*1=37 무한 반복
* 4 - 4*4=16 -> 무한 반복
* 5 - 5*5=25 -> 2*2+5*5=29 -> 2*2+9*9=85-> 8*8+5*5=89 무한 반복
* 6 - 6*6=36 -> 3*3+6*6=45 -> 5*5+4*4=41 -> 4*4+1*1=17 -> 1*1+7*7=50 -> 5*5=25 무한 반복
* 7 - 7*7=49 -> 4*4+9*9=97 -> 9*9+7*7=130-> 1*1+3*3=10-> 1*1=1 행복 수
* 8 - 8*8=64 -> 6*6+4*4=52-> 5*5+2*2=29 무한 반복
* 9 - 9*9=81 -> 8*8+1*1=65 무한 반복
*
* 이 처럼 1~9까지의 숫자를 주어진 규칙을 따라서 계산을 하게 되면
* 결국 1과 4로 행복수의 조건을 찾아줄 수 있다.
* 1은 행복 수 이고, 4는 무한 반복이 되는 수이므로
* 주어진 입력에 따라서 1 또는 4의 값이 나올 때까지 계산을 하게 되면 문제를 해결할 수 있다.
*
* 만일 이 문제가 시간제한이 있었다면 한 번 계산을 해보면
* 우선 주어진 n의 범위가 1 ~ 9999 이고,
* 최대 값인 9999에서는 81 * 4 = 324로 연산 수가 적기 때문에
* O(1)이라고 생각을 해도 된다.
* 이 경우에는 N만큼 계산을 해줘야하기 때문에 O(1) * n = O(n) 으로 계산이 가능하다.
* 따라서 1초 미만의 시간으로 이 문제를 해결 가능하다.
*
*/

public class Main {

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        List<Integer> l = new ArrayList<>();

        for (int i = 1; i <= n; ++i) {
            if (solve(i))
                l.add(i);
        }
        int ans = 0;
		for (Integer val : l) {
			ans += val;
		}
        System.out.println("1 ~ " + n + " 범위의 행복 수는 "+ l.size() + "개이고 총합은 "+ ans + "입니다.");
        long ansVal = (long)l.size() * ans;
        System.out.println("두 수의 곱 :" + ansVal + "입니다.");
    }

    private static boolean solve(int n) {
        while (n != 1 && n != 4) {
            n = square(n);
        }
        return n == 1;
    }

    private static int square(int n) {
        int sum = 0;
        while(n > 0) {
            int tempVal = n % 10;
            n /= 10;
            sum += tempVal * tempVal;
        }
        return sum;
    }
}