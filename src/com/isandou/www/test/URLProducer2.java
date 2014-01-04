package com.isandou.www.test;


public class URLProducer2 {
	public static void main(String[] args) {
//		String upart[] = {"http://www.mr699.cn/mr_list_64_",".html"};
		String upart[] = {"http://www.cn-em.com/yp/?----",".htm"};
		
		for (int i = 1; i < 608; i++) {
			System.out.println(upart[0]+i+upart[1]);
		}
	}
}
