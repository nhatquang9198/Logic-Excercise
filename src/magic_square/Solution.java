package magic_square;

import java.util.Arrays;
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
		int max_lenght;
		int temp[][];
		int sum, sum_temp;

		// matrix size is 1x1
		if (n == 1 && m == 1) {
			return 1;
		}
		// matrix is a square
		else if (n == m) {
			max_lenght = n;

			for (int i = max_lenght; i > 1; i--) {
				temp = new int[i][i];
				int x = 0, y = 0;
				sum = 0;
				sum_temp = 0;

				outerloop: for (int j = 0; j <= n - max_lenght; j++, x++) {
					for (int j2 = 0; j2 < m - max_lenght; j2++, y++) {
						temp[x][y] = matrix[j][j2];
					}
					// System.arraycopy(matrix[j], j, temp[x], 0, max_lenght);
					
					System.out.println("\n");
					for (int[] t : temp) {
						for (int r : t) {
							System.out.print(r + " ");
						}
						System.out.println();
					}
				}
			}
		}
		// matrix is a rectangle
		else if (n > m) {
			max_lenght = Math.abs(n - m);
		} else {
			max_lenght = Math.abs(n - m);
		}
		return 1;
	}

}
