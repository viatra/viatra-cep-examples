package com.rh12.tbcep;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.*;

public class CLog {
	
	public static String currentTime() {
		long t = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm ss.SSS");    
		Date resultdate = new Date(t);
		return sdf.format(resultdate);
	}
	
	public static final String UPDATE = "UPDATE";
	public static final String SIMPLE_TEST = "SIMPLE_TEST";
	
	public static final String ATOMIC = "ATOMIC";
	public static final String ATOMIC_IN = "ATOMIC_IN";
	public static final String ATOMIC_OUT = "ATOMIC_OUT";
	public static final String NAMED = "NAMED";
	public static final String JUMP = "JUMP";
	
	static final Map<String, Integer> DICT = newDict();
	static Map<String, Integer> newDict() {
		Map<String, Integer> dictionary = new HashMap<String, Integer>();

		dictionary.put("", 1);
		dictionary.put(UPDATE, 0);
		dictionary.put(SIMPLE_TEST, 0);
		
		dictionary.put(ATOMIC, 0);
		dictionary.put(ATOMIC_IN, 0);
		dictionary.put(ATOMIC_OUT, 0);
		dictionary.put(NAMED, 0);
		dictionary.put(JUMP, 1);

		return dictionary;
	}
	
	
	public static void print(String text) {
		print(text, "");
	}
	
	public static void print(String text, String category) {
		int shouldPrint = DICT.get(category);
		if (shouldPrint == 1) {
			System.out.println(text + currentTime());			
		}
	}
}
