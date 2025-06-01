import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());

            br.close();
            bw.flush();
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}


