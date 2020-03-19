package bussiness_man;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {

		String s = "Sun 10:00-20:00\n" + "Fri 05:00-10:00\n" + "Fri 16:30-23:50\n" + "Sat 10:00-24:00\n"
				+ "Sun 01:00-04:00\n" + "Sat 02:00-06:00\n" + "Tue 03:30-18:15\n" + "Tue 19:00-20:00\n"
				+ "Wed 04:25-15:14\n" + "Wed 15:14-22:40\n" + "Thu 00:00-23:59\n" + "Mon 05:00-13:00\n"
				+ "Mon 15:00-21:00\n";

		// String s = "Mon 01:00-23:00\n" + "Tue 01:00-23:00\n" + "Wed 01:00-23:00\n" +
		// "Thu 01:00-23:00\n"
		// + "Fri 01:00-23:00\n" + "Sat 01:00-23:00\n" + "Sun 01:00-21:00\n";

		Map<DayOfWeek, TreeMap<LocalTime, LocalTime>> schedule = new TreeMap<>();
		// List<Meeting> schedule = new ArrayList<>();

		String[] inputString = s.split("\n");

		for (String part : inputString) {
			String day = part.split(" ")[0];
			String time = part.split(" ")[1];

			DayOfWeek dayOfWeek = null;
			LocalTime begin;
			LocalTime end;

			begin = LocalTime.parse(time.split("-")[0]);
			if (time.split("-")[1].equalsIgnoreCase("24:00")) {
				end = LocalTime.MIDNIGHT;
			} else {
				end = LocalTime.parse(time.split("-")[1]);
			}

			switch (day) {
			case "Mon":
				dayOfWeek = DayOfWeek.MONDAY;
				break;

			case "Tue":
				dayOfWeek = DayOfWeek.TUESDAY;
				break;

			case "Wed":
				dayOfWeek = DayOfWeek.WEDNESDAY;
				break;

			case "Thu":
				dayOfWeek = DayOfWeek.THURSDAY;
				break;

			case "Fri":
				dayOfWeek = DayOfWeek.FRIDAY;
				break;

			case "Sat":
				dayOfWeek = DayOfWeek.SATURDAY;
				break;

			case "Sun":
				dayOfWeek = DayOfWeek.SUNDAY;
				break;
			}

			if (!schedule.containsKey(dayOfWeek)) {
				schedule.put(dayOfWeek, new TreeMap<>());
			}
			schedule.get(dayOfWeek).put(begin, end);
		}

		schedule.forEach((k, v) -> {
			System.out.println(k + " " + v);
		});

		System.out.println("\nThe longest time James can sleep: " + solution(schedule) + " minutes");

	}

	public static long solution(Map<DayOfWeek, TreeMap<LocalTime, LocalTime>> schedule) {
		Duration duration = Duration.ZERO;
		Duration temp = Duration.ZERO;
		// begin at 00.00
		LocalTime begin = LocalTime.MIDNIGHT;
		LocalTime end = LocalTime.MIDNIGHT;

		for (Map.Entry<DayOfWeek, TreeMap<LocalTime, LocalTime>> schec : schedule.entrySet()) {
			// System.out.println("\n");
			for (Map.Entry<LocalTime, LocalTime> entry : schec.getValue().entrySet()) {
				end = entry.getKey();

				// System.out.println("begin: " + begin + " end: " + end);

				temp = Duration.between(begin, end);
				if (temp.toMinutes() < 0) {
					temp = Duration.ofMinutes(1440 + temp.toMinutes());
					if (duration.compareTo(temp) < 0) {
						duration = temp;
					}
				}

				// System.out.println("dura: " + temp.toMinutes() + "\n");

				begin = entry.getValue();
			}
		}

		end = LocalTime.MIDNIGHT;
		temp = Duration.ofMinutes(1440 + Duration.between(begin, end).toMinutes());
		if (duration.compareTo(temp) < 0) {
			duration = temp;
		}

		return duration.toMinutes();
	}
}
