import java.io.*;
import java.util.*;

public class main {
    /*
    풀이
    화살표 입력 <, >
    백스페이스 입력 -
    LinkedList 하나 이용하고, listiterator 로 커서 위치 관리하면서 풀이 <- 이거 채택
    Deque 두개 이용해서 커서위치는 leftD rightD 끝/시작점 위치로 풀이?
    */

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(bf.readLine());
        for (int i = 0; i < size; i++) {
            String input = bf.readLine();
            LinkedList<Character>pwd = getPassword(input);
            printPwd(pwd, sb);
        }
    }

    private static LinkedList<Character> getPassword(String input) {
        LinkedList<Character> pwd = new LinkedList<>();
        ListIterator<Character> lit = pwd.listIterator();
        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '<':
                    if(lit.hasPrevious()) lit.previous();
                    break;
                case '>':
                    if(lit.hasNext()) lit.next();
                    break;
                case '-':
                    if(lit.hasPrevious()) {
                        lit.previous();
                        lit.remove();
                    }
                    break;
                default:
                    lit.add(c);
            }
        }
        return pwd;
    }

    private static void printPwd(LinkedList<Character> pwd, StringBuilder sb) {
        sb.setLength(0); //기존 출력값 초기화
        for(char c:pwd){
            sb.append(c);
        }
        System.out.println(sb);
    }
}


