package com.isandou.www.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 异常
 * @author wangtao
 *
 */
public class Test11 {
	
	public static int test() {
		int i =1;
		try {
			
		} catch (Exception e) {
			
		}
		return 1;
	}

	public static void main(String[] args) {
//		long temp=0;
//		for (int i = 0; i < 1000; i++) {
//			temp = System.currentTimeMillis();
//			for (int j = 0; j < 10; j++) {
//				temp++;
//			}
//			System.out.println(temp);
//		}
		
//		System.out.println(""+"我是中国人".hashCode());
		
		Integer[] a = {1,2,3};
		Map<String, Integer[]> map = new HashMap<String, Integer[]>();
		List<String> strings = new ArrayList<String>();
		List<Integer> sList = new ArrayList<Integer>();
		String string = "1";
		int i = 1;
		sList.add(i);
		strings.add(string);
		string = "2";
		i = 2;
		System.out.println(sList.get(0));
		System.out.println(strings.get(0));
		map.put("1", a);
		a[0] = 4;
		System.out.println(a[0]);
		System.out.println(map.get("1")[0]);
	}

}
