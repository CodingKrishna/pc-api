package org.pioneercoders.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class DateParser {

	private static String dateFormate = "yyyy-MM-dd";

	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
		String dateStr = sdf.format(date);
		return dateStr;
	}
	
	

	public static Date strToDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date addDays(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days);
		date = c.getTime();
		return date;
	}
	
	public static String getDateAsNumber(Date date) {
		String dateFormate = "yyMMddhha";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
		String dateStr = sdf.format(date);
		return dateStr;
	}
	
	public static String getDateAsNumberSmall(Date date) {
		String dateFormate = "MMyy";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
		String dateStr = sdf.format(date);
		return dateStr;
	}
	
	public static long getAgeByDOB(String dob){
		Date d1 = strToDate(dob);
		Date d2 = new Date();
		System.out.println(d1);
		long diff = d2.getTime() - d1.getTime();
		long diffYears = ( diff / (24 * 60 * 60 * 1000) ) / 365;
		
		return diffYears;
	}
	
	public static Date[] getDateStartAndEnd(Date date) {
		Date [] dates = new Date[2];
		Calendar calendar =  Calendar.getInstance();
		calendar.setTime(date);
		
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		dates[0] = calendar.getTime();
		calendar.add(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		dates[1] = calendar.getTime();
		
		return dates;
	}
	public static Date removeTimeFromDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		
		return cal.getTime();
	}
	public static Date addTimeToDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		
		cal.set(Calendar.HOUR_OF_DAY,5);
		cal.set(Calendar.MINUTE,30);
		cal.set(Calendar.SECOND,0);
		
		return cal.getTime();
	}
	public static int[] getDayMonthYearFromDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		int[] a = new int[3];
		a[0]=cal.get(Calendar.YEAR);
		a[1]=cal.get(Calendar.MONTH)+1;
		a[2]=cal.get(Calendar.DAY_OF_MONTH);
		return a;
	}
	public static void main(String[] args) {
		System.out.println(getDayMonthYearFromDate(new Date())[2]);
	}
}