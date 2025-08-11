public class Main {
	public static void main(String[] args) throws Exception {
		int read;
		int[] result = new int[26];
		while ((read = System.in.read()) != 10 && read != 13) {
			result[read - 97] = result[read - 97] + 1;
		}
		for (int i : result) {
			System.out.print(i);
			if (i < 26) {
				System.out.print(" ");
			}
		}
	}
}
