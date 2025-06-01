package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 세트당 0~9 숫자 제공. 6,9는 서로 사용가능
        /*
        1. 번호파싱
        2. n6+n9+1 / 2
        2. max값 계산
        3. 세트수 출력
        !! 엣지 케이스
        66999 => 6개수+9개수 + 1 / 2 => 필요 세트수 =? 2+3+1/2 => 3
         */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int[] count = new int[9];
        int i;

        for(i=0; i<input.length(); i++) {
            if(input.charAt(i)=='9') {
                count[6]++;
            } else {
                count[input.charAt(i)-'0']++;
            }
        }
        count[6] = (count[6]+1)/2;
        int maxset = 0;
        for(i=0; i<9; i++) {
            if(count[i]>maxset) {
                maxset = count[i];
            }
        }
        System.out.println(maxset);
    }
}
