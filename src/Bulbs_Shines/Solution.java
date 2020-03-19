package bulbs_shines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	// Solution to the problem is under the main function
	// Please ignore and skip this function
	public static void main(String[] args) {
		int flag;
		int number;
		List<Integer> sequence;
		List<Bulb> bulbs;

		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("--------------------------//--------------------------");
			sequence = new ArrayList<>();
			System.out.println("Enter the array\nEnter 0 to stop");

			do {
				number = scanner.nextInt();
				if (number != 0) {
					sequence.add(number);
				}
			} while (number != 0);

			bulbs = new ArrayList<Bulb>();
			for (int i = 0; i < Collections.max(sequence); i++) {
				bulbs.add(new Bulb());
			}

			System.out.println(Bulbs_Shine(bulbs, sequence));

			System.out.println("Do you want to continue?\n1 = yes | 0 = no");
			flag = scanner.nextInt();
		} while (flag == 1);

		scanner.close();
	}

	// Solution to the exercise
	private static int Bulbs_Shine(List<Bulb> bulbs, List<Integer> sequence) {
		int count = 0;
		int best_index = 0;
		int max_index = -1;
		boolean flag;

		for (int i : sequence) {
//			System.out.println("\ni: " + (i - 1) + " best: " + best_index);
			bulbs.get(i - 1).setOn(true);

			if (i - 1 > max_index) {
				max_index = i - 1;
			}

			flag = true;
			innerloop: for (int j = best_index; j <= max_index; j++) {
				if (!bulbs.get(j).isOn()) {
					flag = false;
					break innerloop;
				}
			}
//			System.out.println(bulbs);
//			System.out.println("flag: " + flag + " max: " + max_index);

			if (flag == true) {
				best_index = i - 1;
				count++;
			}
		}

		return count;
	}

}
