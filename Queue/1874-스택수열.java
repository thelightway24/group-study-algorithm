import java.io.*;
import java.util.*;

public class Main {
    /*
    * 1. 입력값과 같거나 작을때까지 stack에 오름차순으로 숫자 push
    *   중복된 숫자는 push 할 수 없고 오름차순으로 숫자 push 하기 때문에,
    *   가장 마지막에 push 한 숫자만 유지하고 1씩 증가시키면서 push 하면됨
    * 2. stack의 가장 상단에 input값과 같은 값이 있으면 pop
    *   없을경우 pop 시에 입력한 stack 수열을 만들어낼 수 없으므로 실패처리
    * */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int len = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>(len);

        boolean noFlag = false;

        int peak = 1;
        for(int i =0;i<len;i++) {
            int input = Integer.parseInt(br.readLine());
            while(peak <= input){
                stack.addLast(peak++);
                sb.append("+\n");
            }
            if(stack.peekLast() == input) {
                stack.removeLast();
                if(i==len-1)
                    sb.append("-");
                else
                    sb.append("-\n");
            } else {
                noFlag = true;
                break;
            }
        }
        if(noFlag) System.out.println("NO");
        else {
            System.out.println(sb);
        }
    }
}


