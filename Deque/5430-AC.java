import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for(int i=0;i<n;i++) {
            char[] command = br.readLine().toCharArray();
            int listLen = Integer.parseInt(br.readLine());
            Deque<Integer> deque= new ArrayDeque<>(listLen);
            if(listLen >0) { // 리스트 길이가 0보다 크다고 입력받은 경우에만 deque에 숫자 채워넣기 (오류방지용)
                StringTokenizer st = new StringTokenizer(br.readLine(),"[],"); //입력받은 리스트 구분자 기준으로 입력받기

                for(int j=0;j<listLen;j++) {
                    deque.addLast(Integer.parseInt(st.nextToken()));
                }
            } else { // 길이가 0 인경우.. 한줄 넘기기
                br.readLine();
            }


            boolean reverse = false;
            boolean error = false;

            for(char c: command) {
                switch (c) {
                    case 'R': {
                        reverse = !reverse;
                        break;
                    }
                    case 'D' : {
                        if(deque.isEmpty()) { // 빈 deque 에서 제거 시도 할 경우 에러처리
                            error = true;
                            break;
                        }
                        if(reverse) { // reverse true 일 경우 뒤집은것과 같은 효과로 뒤에서 제거
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                        break;
                    }
                    default:{
                        error = true;
                        break;
                    }
                }
                if(error) {
                    System.out.println("error"); // 에러발생시 커맨드 진행 중단하고 에러문구 출력
                    break;
                }
            }
            if(!error) {
                sb.setLength(0);
                sb.append('[');
                if(reverse) {
                    Iterator<Integer> it = deque.descendingIterator();
                    while (it.hasNext()){
                        sb.append(it.next());
                        if(it.hasNext()){
                            sb.append(',');
                        }
                    }
                } else {
                    Iterator<Integer> it = deque.iterator();
                    while (it.hasNext()){
                        sb.append(it.next());
                        if(it.hasNext()){
                            sb.append(',');
                        }
                    }

                }
                sb.append(']');
                System.out.println(sb);
            }


        }


    }


}


