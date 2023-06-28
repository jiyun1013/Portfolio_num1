package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodayDate {
	public static void main(String[] args) {
		Date ToDa = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println(formatter.format(ToDa));
	}
}
