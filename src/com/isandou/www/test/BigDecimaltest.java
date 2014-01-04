package com.isandou.www.test;
import java.math.BigDecimal;
import java.util.Scanner;


public class BigDecimaltest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入两个数字，1<=a,b<=2^64(输入每一个数字后回车即可)\n");
		Scanner scanner = new Scanner(System.in);
		BigDecimal a = scanner.nextBigDecimal();
		BigDecimal b = scanner.nextBigDecimal();
		String result = a.multiply(b)+"";
		System.out.println("您输入两个数字相乘后的位数是："+result.length());
		
		
	}

}
