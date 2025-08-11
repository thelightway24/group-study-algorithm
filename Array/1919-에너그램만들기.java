import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		char[] a = br.readLine().toCharArray();
		char[] b = br.readLine().toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		int pointA = 0;
		int pointB = 0;
		int count = 0;
		while(pointA < a.length && pointB < b.length) {
			if(a[pointA] == b[pointB]) {
				pointA++;
				pointB++;
			} else if(a[pointA] > b[pointB]) {
				pointB++;
				count++;
			} else {
				pointA++;
				count++;
			}
		}
		System.out.println(a.length-pointA+b.length-pointB+count);
	}
}
