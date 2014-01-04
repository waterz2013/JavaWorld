package com.isandou.www.test;

/**
 * ",,,," split(",") 长度为多少? A:到最后一个非,前都会分割
 * 
 * @author Administrator
 * 
 */
public class SplitTest {
	public static void main(String[] args) {
		String splits[] = ";;;;1".split(";");
		System.out.println(splits.length);
		for (int i = 0; i < splits.length; i++) {
			System.out.println("#" + splits[i] + "#");
		}
	}
}
