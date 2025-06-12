import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob6_13300_방배정 {
    /*
    * 1. 학생수 n, 방당인원수 k 입력
    * 2. n번 루프 돌아서 성별(0,1), 학년(1~6) 입력
    * 3. 필요한 방 개수 출력
    * 제약조건
    * 남녀따로
    * 한 방에는 같은 학년의 학생들만 배정
    * 한명만 배정 가능
    *
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bf.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[][] arr = new int[2][6];

        int i,j;

        for(i=0; i<n; i++) {
            String[] genderGrade = bf.readLine().split(" ");
            int gender = Integer.parseInt(genderGrade[0]);
            int grade = Integer.parseInt(genderGrade[1]);
            arr[gender][grade-1]++;
        }

        int roomcount = 0;
        for(i=0; i<2; i++) {
            for(j=0; j<6; j++) {
                roomcount += arr[i][j]/k;
                if(arr[i][j]%k!=0) roomcount++;
            }
        }
        System.out.println(roomcount);
    }
}
