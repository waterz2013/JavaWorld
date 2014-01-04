package com.isandou.www.test;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		URL url = new URL("http://www.chinaz.com/news/2013/1122/327926.shtml");
		System.out.println(url.getHost());
		System.out.println(url.getPath());
		System.out.println(url.getProtocol());
		System.out.println(url.getPort());
		System.out.println(url.getUserInfo());
		
		
	}

}
