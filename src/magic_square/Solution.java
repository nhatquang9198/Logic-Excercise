package magic_square;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		int[][] matrix;
		int n, m;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter N and M:");
		n = scanner.nextInt();
		m = scanner.nextInt();
		matrix = new int[n][m];

		System.out.println("Enter the matrix with size N x M");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}

		// this loop is just for printing the input matrix
		System.out.println("This is the input matrix:");
		for (int[] x : matrix) {
			for (int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}

		System.out.println("\nSize of the largest magic square: " + solution(matrix));

		scanner.close();
	}

	public static int solution(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		if (n == 1 || m == 1) {
			// matrix size is 1x1
			return 1;
		} else {
			// find the smaller number between m and n
			// max_length = m if n is bigger
			// max_length = n if m is bigger or n == m
			int max_length = (n > m) ? m : n;
			int size = 1, answer = 1;
			int[][] temp;
			int x = 0, y = 0;
			boolean flag;

			for (int length = 2; length <= max_length; length++) {
				temp = new int[length][length];
				flag = false;

				for (int row = 0; row < n - size; row++) {
					for (int column = 0; column < m - size; column++, x = 0) {
						for (int i = row; i < row + length && x < length; i++, x++, y = 0) {
							for (int j = column; j < column + length && y < length; j++, y++) {
								temp[x][y] = matrix[i][j];
							}
						}

						System.out.println("square:");
						for (int[] u : temp) {
							for (int i : u) {
								System.out.print(i + " ");
							}
							System.out.println();
						}

						if (isMagical(temp)) {
							flag = true;
							// break innerloop;
						}
					}
				}
				size = length;

				if (flag == true) {
					answer = length;
				}
			}

			return answer;
		}
	}

	public static boolean isMagical(int[][] square) {
		int sum = 0;
		int sum_temp = 0;

		for (int i = 0; i < square.length; i++) {
			sum = sum + square[i][i];
		}

		for (int i = square.length - 1; i >= 0; i--) {
			sum_temp = sum_temp + square[i][i];
		}

		if (sum != sum_temp) {
			return false;
		}

		for (int i = 0; i < square.length; i++) {
			sum_temp = 0;
			for (int j = 0; j < square.length; j++) {
				sum_temp = sum_temp + square[i][j];
			}
			if (sum != sum_temp) {
				return false;
			}
		}

		for (int j = 0; j < square.length; j++) {
			sum_temp = 0;
			for (int i = 0; i < square.length; i++) {
				sum_temp = sum_temp + square[i][j];
			}
			if (sum != sum_temp) {
				return false;
			}
		}

		return true;
	}

}
