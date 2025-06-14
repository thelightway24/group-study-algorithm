import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        LinkedList<Character> editor = new LinkedList<>();
        for (char c : br.readLine().toCharArray()) {
            editor.add(c);
        }

        int orderCount = Integer.parseInt(br.readLine());
        ListIterator<Character> cursor = editor.listIterator();

        while (cursor.hasNext()){
            cursor.next();
        }

        for (int i = 0; i < orderCount; i++) {
            String command = br.readLine();
            char charCommand = command.charAt(0);

            if (charCommand == 'L' && cursor.hasPrevious()) {
                cursor.previous();
            } else if (charCommand == 'D' && cursor.hasNext()) {
                cursor.next();
            } else if (charCommand == 'B' && cursor.hasPrevious()) {
                cursor.previous();
                cursor.remove();
            } else if (charCommand == 'P') {
                cursor.add(command.charAt(2));
            }
        }

        for (char c : editor) sb.append(c);
        System.out.println(sb);
    }
}
