package utils;

import java.text.SimpleDateFormat;

public class UtilDate {
	public static java.sql.Date changeDate(java.util.Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String stringDate= dateFormat.format(date);
		return java.sql.Date.valueOf(stringDate);
	}
}
