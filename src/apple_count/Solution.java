package apple_count;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		int[] a = { 6, 1, 4, 6, 3, 2, 7, 5 };
		int k = 3;
		int l = 2;

		System.out.println("Total apples: " + solution(a, k, l));
	}

	public static int solution(int[] a, int k, int l) {
		if (k + l > a.length) {
			return -1;
		} else {
			int[] alice = new int[k];
			int[] bob = new int[l];
			int max = 0;
			int sum_alice, sum_bob;

			for (int i = 0; i <= a.length - k; i++) {
				alice = Arrays.copyOfRange(a, i, i + k);
				sum_alice = sum(alice);

				for (int j = 0; j <= a.length - l; j++) {
					if (j == i) {
						j = j + k - 1;
					} else if ((j < i && j + l <= i) || j > i) {
						bob = Arrays.copyOfRange(a, j, j + l);
						sum_bob = sum(bob);

						if (sum_alice + sum_bob > max) {
							max = sum_alice + sum_bob;
						}
					}
				}
			}

			return max;
		}
	}

	public static int sum(int[] array) {
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}

		return sum;
	}
}
