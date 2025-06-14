import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxCaseNumber = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < maxCaseNumber; i++) {
            LinkedList<Character> inputList = new LinkedList<>();
            ListIterator<Character> cursor = inputList.listIterator();

            for (char ch : br.readLine().toCharArray()) {
                if (ch == '<' && cursor.hasPrevious()) {
                    cursor.previous();
                } else if (ch == '>' && cursor.hasNext()) {
                    cursor.next();
                } else if (ch == '-' && cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                } else if (ch != '-' && ch != '<' && ch != '>') {
                    cursor.add(ch);
                }
            }
            for (char ch : inputList) {
                sb.append(ch);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
