import java.util.*;
import java.io.*;

/*
에디터 스펙
1. 최대 600_000 글자
2. 영어 소문자만 입력 가능

커서 위치 조건
1. 문자 사이사이에 있을 수 있음
    ex) abc 가 문자인 경우(L=3) |abc a|bc ab|c abc| 이렇개 4곳(L+1)에 위치할 수 있음

지원 명령어

L	|  커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)

D	|  커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)

B	|  커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
    |  삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임

P $	|  $라는 문자를 커서 왼쪽에 추가함

문제
문자열 입력받은 후, 모든 명령어 수행 뒤에 편집기에 입력되어있을 문자열 구하기.
커서는 입력받은 문자열의 가장 끝에서 시작함.

풀이
1. 초기 문자열입력 -> 커서위치 계산을 위해 전체 길이 구해두기
2. 입력할 명령어 수 받음
3. 명령어 만큼 순차 시행
4. 결과 출력

명령어 로직
일단 명령어 시작 전 cursorPosition size로 초기화
L => cP -= 1 (cP>0 일 경우에만)
D => cP += 1 (cP<size 일 경우에만)
B => cP인덱스 위치의 문자를 제거 == concat( 0~cP-2, cP~ size-1)
P $ =>
 */

public class main {

    private static char[] inputstr;
    private static int size;
    private static Deque<Character> leftD = new ArrayDeque<>();
    private static Deque<Character> rightD = new ArrayDeque<>();

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        inputstr = bf.readLine().toCharArray();
        size = inputstr.length;

        int len = Integer.parseInt(bf.readLine());
        for(char ch: inputstr) {
            leftD.add(ch);
        }

        for(int i=0; i<len; i++) {
            String command = bf.readLine();
            performCommand(command);
        }

        printD();
    }

    private static void performCommand(String command) {
        String commandType = command.split(" ")[0];
        switch (commandType) {
            case "L": {
                if(!leftD.isEmpty()) {
                    char c = leftD.removeLast();
                    rightD.addFirst(c);
                }
                break;
            }
            case "D": {
                if(!rightD.isEmpty()) {
                    char c = rightD.removeFirst();
                    leftD.addLast(c);
                }
                break;
            }
            case "B": {
                if(!leftD.isEmpty()) leftD.removeLast();
                break;
            }
            case "P": {// str을 커서 왼쪽에 추가
                char str = command.split(" ")[1].charAt(0);
                leftD.addLast(str);
                break;
            }
        }
    }

    private static void printD() {
        StringBuilder sb = new StringBuilder();
        for(char c: leftD) sb.append(c);
        for(char c: rightD) sb.append(c);
        System.out.println(sb);
    }
}


