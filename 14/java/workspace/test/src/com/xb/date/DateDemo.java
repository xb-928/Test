package com.xb.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
//		long a = System.currentTimeMillis();
//		Date date = new Date();
//	
//		System.out.println(date);
//		
//		Date date1 = new Date((long)1000*60*60*24*1000);
//		System.out.println(date1);
		
//		Date date2 = new Date();
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date2);
//		int year = calendar.get(Calendar.YEAR);
//		int month = calendar.get(Calendar.MONTH)+1;
//		int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);
//		String[] a = {"日","一","二","三","四","五","六"};
//		System.out.println(year+"年"+month+"月"+"星期"+a[day_of_week-1]);
		
		String string = "2010年9月19日 20:23:22";
		String parten = "yyyy年MM月dd日 HH小时mm分ss秒";
		SimpleDateFormat sdf = new SimpleDateFormat(parten);
		try {
			Date date = sdf.parse(string);
			System.out.println(date);
			String dString = sdf.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
;	}
}
