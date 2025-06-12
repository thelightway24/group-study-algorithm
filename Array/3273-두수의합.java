import java.io.*;
import java.util.*;

public class prob4_3273_두수의합 {
    /*
       1. 수열 크기 입력
       2. 공백기준 분할된 수열 입력
       3. 합 계산 대상이될 x 입력

       풀이
       1. 수열 정렬
       2. left 포인터 0번째로 초기화
       3. right 포인터 위치 초기화 (x 보다 작을때까지 내려옴)
       4. left+right 가 x와 같은지 비교
            4-1. 같을 경우 count++, left++, right--
            4-2. 작을경우 left++
            4-3. 클 경우 right--
       !! 루프 탈출 조건 : left >= right

        */
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(bf.readLine());

        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(bf.readLine());
        Arrays.sort(arr);

        int equalcount = 0;
        int left = 0;
        int right = len-1;
        while(arr[right]>=x) right--;
        while(left<right) {
            int sum = arr[left]+arr[right];
            if(sum==x) {
                equalcount++;
                left++;
                right--;
            } else if(sum<x) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(equalcount);
    }
}
