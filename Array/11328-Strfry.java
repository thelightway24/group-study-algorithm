import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class prob7_11328_Strfry {
    /*
    * 1. 케이스 수 입력
    * 2. 테스트 케이스 입력 (공백기준 구분된 문자열)
    * 3. strfry 적용 여부 반환
    *
    *
    * ==> 문자열 정렬해서 같은지 비교
    * ==> 정렬할 필요도 없네, char 빈도수 같은지 비교
    * */
    public static void main(String[] args) throws Exception{
        int i,j;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for(i=0; i<n; i++) {
            int[] afreq = new int[26];
            int[] bfreq = new int[26];
            String[] input  = bf.readLine().split(" ");
            char[] a = input[0].toCharArray();
            char[] b = input[1].toCharArray();

            for(j=0; j<a.length; j++) {
                afreq[a[j]-'a']++;
            }

            for(j=0; j<b.length; j++) {
                bfreq[b[j]-'a']++;
            }

            if(Arrays.equals(afreq, bfreq)) {
                System.out.println("Possible");
            } else{
                System.out.println("Impossible");
            }
        }
    }
}
