import java.io.*;

public class prob8_1919_애너그램만들기 {
    /*
    * 1. 두행 입력
    * 2. char 배열로 변환
    * 3, 알파벳 출현 빈도 저장
    * 4. 순회해서 neq 이면 큰수 - 작은수 만큼 count 증가
    * */
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] a = bf.readLine().toCharArray();
        char[] b = bf.readLine().toCharArray();
        int[] afreq = new int[26];
        int[] bfreq = new int[26];

        int i;
        for(i=0; i<a.length; i++) {
            afreq[a[i]-'a']++;
        }
        for(i=0; i<b.length; i++) {
            bfreq[b[i]-'a']++;
        }
        int count = 0;
        for(i=0; i<26; i++) {
            if(afreq[i]!=bfreq[i]){
                if(afreq[i]>bfreq[i]) {
                    count += afreq[i] - bfreq[i];
                } else {
                    count += bfreq[i] - afreq[i];
                }
            }
        }
        System.out.println(count);
    }
}