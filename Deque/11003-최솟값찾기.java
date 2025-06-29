import java.io.*;
import java.util.*;

public class Main {
    /*
     *
     * */

    private static class Pair {
        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int windowSize = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i =0; i<n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Pair> window = new ArrayDeque<>(windowSize);
        int windowHead = -1;
        int windowTail = windowHead-windowSize;

        for(int i = 0; i<n;++i) {
            windowHead++;
            windowTail++;
            //System.out.println("WindowHead: "+ windowHead+ " WindowTail: "+ windowTail);
            Pair cur = new Pair(i, arr[i]);
            if(window.isEmpty()) window.add(cur);
            else{
                if(window.peekFirst().index <= windowTail) {
                    Pair deletingPair = window.peekFirst();
                    //System.out.println("Deleting window tail because index exceeded: "+ deletingPair.index + "value: "+ deletingPair.value);
                    window.pollFirst();
                }
                while(!window.isEmpty() && window.peekLast().value > cur.value) {
                    window.pollLast();
                }
                window.add(cur);
            }
            //System.out.println("window last index:" + window.peekLast().index + " window tail index: " + windowTail);

            //printWindowstatus(window);
            sb.append(window.peekFirst().value).append(' ');
        }
        System.out.println(sb);
    }

    private static boolean isNotInWindow(Pair pair, int windowHead, int windowTail) {
        return pair.index <= windowTail || pair.index > windowHead;
    }

    private static void printWindowstatus(Deque<Pair> window) {
        Iterator<Pair> it = window.iterator();
        while (it.hasNext()) {
            System.out.print(it.next().value);
            System.out.print(" ");
        }
        System.out.println();
    }
}



