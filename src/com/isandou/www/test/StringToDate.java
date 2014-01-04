package com.isandou.www.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {
	public static void main(String[] args) throws ParseException {
		String s = "2013-02-04 12:12:12";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse(s);
		Long l = d.getTime();
		System.out.println(l);
	}
}
