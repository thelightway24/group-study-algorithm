public class Main {
	public static void main(String[] args) throws Exception {
		int read;
		int[] input = new int[10];
		while ((read = System.in.read()) != 10 && read != 13) {
			input[read - 48] = input[read - 48] + 1;
		}
		int count = 0;
		for (int i = 0; i < 10; i++) {
			if (i != 6 && i != 9) {
				if (count < input[i]) {
					count = input[i];
				}
			}
		}
		double sum = input[6] + input[9];
		int ceil = (int)Math.ceil(sum / 2);
		if (count < ceil) {
			count = ceil;
		}

		System.out.println(count);
	}
}
