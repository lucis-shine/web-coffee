package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	public static String parseDate(Date date,String pattern) {
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

}
