package john_vacation;

import java.time.LocalDate;
import java.time.LocalTime;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solution(2012, "January", "February", "Monday"));

	}

	public static int solution(int y, String a, String b, String w) {
		int month_begin = 0;
		int month_end = 0;

		month_begin = convertMonth(a);
		month_end = convertMonth(b);

		System.out.println(a + " " + b);

		// LocalDate date_begin = LocalDate.of(y, month_begin, dayOfMonth);

		return 0;
	}

	public static int convertMonth(String s) {
		int month = 0;

		// January, February, March, April, May, June, July, August, September, October,
		// November, December.

		switch (s) {
		case "January":
			month = 1;
			break;

		case "February":
			month = 2;
			break;
		case "March":
			month = 3;
			break;
		case "April":
			month = 4;
			break;
		case "May":
			month = 5;
			break;
		case "June":
			month = 6;
			break;
		case "July":
			month = 7;
			break;
		case "August":
			month = 8;
			break;
		case "September":
			month = 9;
			break;
		case "October":
			month = 10;
			break;
		case "November":
			month = 11;
			break;
		case "December":
			month = 12;
			break;

		}

		return month;
	}

}
