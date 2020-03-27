package diverve_string;

public class Solution {

	public static String solution(int a, int b, int c) {
		String s = "";
		char lastChar = 0;

		while (a > 0 || b > 0 || c > 0) {
			if (a >= b && a >= c && lastChar != 'a') {
				for (int i = 0; i < 2 && a > 0; i++) {
					s = s + "a";
					a--;
				}
				lastChar = 'a';
			} else if (b >= a && b >= c && lastChar != 'b') {
				for (int i = 0; i < 2 && b > 0; i++) {
					s = s + "b";
					b--;
				}
				lastChar = 'b';
			} else if (lastChar != 'c') {
				for (int i = 0; i < 2 && c > 0; i++) {
					s = s + "c";
					c--;
				}
				lastChar = 'c';
			}
		}

		return s;
	}

	public static void main(String[] args) {
		// int a, b, c;
		//
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("Enter A, B, C number of a, b, c character: ");
		// a = scanner.nextInt();
		// b = scanner.nextInt();
		// c = scanner.nextInt();
		//
		// System.out.println("Longest diverse string: " + solution(a, b, c));
		//
		// scanner.close();

		System.out.println("program");

		System.out.println(solution(3,5,10));
	}

}
