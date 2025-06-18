import java.io.*;
import java.util.*;

public class Main {


    /*
    * 역순으로 생각을 해보면 됨
    * 전의 문제와 다르게 문제에서 오른쪽 -> 왼쪽으로 바라보는 것이라고 설명이 되어있지만
    * 실제로 왼쪽 -> 오른쪽으로 바라보는 결과와 동일하다
    * 해당 이유는 하나의 건물이 들어올 때 왼쪽에 누적되어있는 건물들의 높이를 비교하여
    * 스택으로 합산을 하게 되면 각 건물별로 카운트가 되는것과 동일한 효과가 나오기에
    * 결국 정답과 동일하게 나온다
    * 예시로 설명을 하면
    * [10, 3, 7, 4 ,12, 2] 이렇게 들어온다고 했을 때
    * 실제 스택에 들어가는 값들과 누적합을 계산하는 과정을 보게 되면
    * i = 0, st = [10], ans = 0;
    * i = 1, st = 10 > 3, st = [10, 3], ans = 1; (10인 건물이 3을 볼 수 있음)
    * i = 2, st = 3 < 7 -> pop, st = [10, 7], ans = 2 (10인 건물이 7을 볼 수 있음, 3인 건물은 7을 볼 수 없음)
    * i = 3, st = 7 > 4,  st = [10, 7, 4], ans = 4 (10인 건물이 4를 볼 수 있음, 7인 건물은 4를 볼 수 없음)
    * i = 4, st = 4 < 12 -> pop, 7 < 12 -> pop, 10 < 12 -> pop, st = [12], ans = 4
    * i = 5, st = 12 > 2, st = [12, 2], ans = 5(12인 건물이 2를 볼 수 있음)
    * 이렇게 결과적으로 3 + 0 + 0 + 1 + 0 + 1 = 5와 동일한 0 + 1 + 1 + 2 + 0 + 1 = 5로 동일하다
    * */


    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            int h = Integer.parseInt(br.readLine());
            if (st.isEmpty()) {
                st.push(h);
                continue;
            }
            while (!st.isEmpty() && st.peek() <= h) {
                st.pop();
            }
            ans += st.size();
            st.push(h);
        }
        System.out.println(ans);
    }
}
