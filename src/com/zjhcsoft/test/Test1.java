package com.zjhcsoft.test;

import java.util.ArrayList;
import java.util.List;
/**
 * java 方法是按值传递，当入参是对象时，对象引用的变化不会反应到入参对象中，对象内容的变化会反应到入参
 * @author Administrator
 *
 */
public class Test1 {
	class Test2{
		String s1="s1";
		String s2="s2";
	}
	
	private void name1(){
		List<String> list = new ArrayList<String>();
		list.add("1");
		name2(list);
		String s = "1";
		name3(s);
		Test2 test2 = new Test2();
		name4(test2);
		System.out.println(test2.s1);
		System.out.println(list.size());
		System.out.println(s);
	}
	
	private void name2(List<String> list) {
		list.add("2");
	}
	
	private void name3(String s) {
		s="333";
	}
	
	private void name4(Test2 test2) {
		test2.s1="444";
	}
	
	public static void main(String[] args) {
//		Test1 test = new Test1();
//		test.name1();
//		List<String> ipList = new ArrayList<String>();
//		ipList.add("220.181.111.85");
//		ipList.add("204.79.197.200");
//		ipList.add("171.8.167.96");
//		ipList.add("220.181.124.201");
//		System.out.println(ipList.get((int)(Math.random()*(ipList.size()-1))));
		System.out.println(1/2);
	}
}
