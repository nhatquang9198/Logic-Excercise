package john_vacation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		// January, February, March, April, May, June, July, August, September, October,
		// November, December.

		// Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
		System.out.println("Number of weeks: " + solution(2014, "April", "May", "Wednesday"));

	}

	/**
	 * @param y: year
	 * @param a: month begin
	 * @param b: month end
	 * @param w: day of week for 1st January of year
	 * @return number of week
	 */
	public static int solution(int y, String a, String b, String w) {
		int month_begin = 0;
		int month_end = 0;
		int day_begin = 0;
		int day_end = 0;
		int dayOfWeek = 0;

		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 31);
		if (y % 4 == 0) {
			map.put(2, 29);
		} else {
			map.put(2, 28);
		}
		map.put(3, 31);
		map.put(4, 30);
		map.put(5, 31);
		map.put(6, 30);
		map.put(7, 31);
		map.put(8, 31);
		map.put(9, 30);
		map.put(10, 31);
		map.put(11, 30);
		map.put(12, 31);

		month_begin = convertMonth(a);
		month_end = convertMonth(b);
		dayOfWeek = convertDayOfWeek(w) - 1;

		for (int month = 1; month <= month_end; month++) {
			for (int dayOfMonth = 1; dayOfMonth <= map.get(month); dayOfMonth++) {
				dayOfWeek = (dayOfWeek == 7) ? 1 : dayOfWeek + 1;
				if (dayOfWeek == 2 && month == month_begin && dayOfMonth <= 7) {
					day_begin = dayOfMonth;
				}

				if (dayOfWeek == 1 && month == month_end) {
					day_end = dayOfMonth;
				}
			}
		}

		System.out.println(a + " " + b + " " + w);
		System.out.println(month_begin + " " + month_end + " " + dayOfWeek);
		System.out.println("day begin: " + day_begin);
		System.out.println("day end: " + day_end);

		LocalDate date_begin = LocalDate.of(y, month_begin, day_begin);
		LocalDate date_end = LocalDate.of(y, month_end, day_end);

		long weeks = ChronoUnit.WEEKS.between(date_begin, date_end) + 1;

		return (int) weeks;
	}

	public static int convertMonth(String s) {
		int month = 0;

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

	public static int convertDayOfWeek(String s) {
		int dayOfWeek = 0;

		switch (s) {
		case "Sunday":
			dayOfWeek = 1;
			break;
		case "Monday":
			dayOfWeek = 2;
			break;
		case "Tuesday":
			dayOfWeek = 3;
			break;
		case "Wednesday":
			dayOfWeek = 4;
			break;
		case "Thursday":
			dayOfWeek = 5;
			break;
		case "Friday":
			dayOfWeek = 6;
		case "Saturday":
			dayOfWeek = 7;
			break;
		}

		return dayOfWeek;

	}

}
