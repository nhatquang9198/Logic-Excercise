package diverve_string;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		int a, b, c;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter A, B, C number of a, b, c character: ");
		a = scanner.nextInt();
		b = scanner.nextInt();
		c = scanner.nextInt();

		System.out.println(solution(a, b, c));

		scanner.close();

	}

	public static String solution(int a, int b, int c) {
		String s = "";
		boolean flag = true;

		if (a == 0 && b == 0 || a == 0 && c == 0 || b == 0 && c == 0) {
			return s;
		} else if (a > b && a > c) {
			while (flag) {
				if (s.length() > 2) {
					if (a-- > 0) {
						s = s + "a";
					}
				} else if (b-- > 0) {
					s = s + "b";
				} else if (c-- > 0) {
					s = s + "c";
				} else {
					flag = false;
				}
			}
		} else if (b > a && b > c) {
			s = "b";
		} else {
			s = "c";

		}
		return s;
	}

}
