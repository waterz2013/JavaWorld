package com.isandou.www.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.xml.crypto.Data;

public class URLProducer3 {
	static List<String> keywordList = new ArrayList<String>();

	public static void process(BufferedWriter bufferedWriter,String info[]) throws IOException {
		for (String keyword:keywordList) {
			int len = Integer.parseInt(keyword.split(",")[1]);
			for (int i = 1; i < len+1; i++) {
				bufferedWriter.append(info[0] + URLEncoder.encode(keyword)
						+ info[1]+(i)+info[2]);
			}
			
		}
	}
	
	public static void main(String[] args) {
		// produceGoogleUrl();
//		System.out.println("重要环保关键词:"+Keywords1.length+"\n一般环保关键词:"+keywords2.length);
		File file = new File("/home/hadoop/urls/existinterval/zjrb.txt");
		
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write("");
			String url = "http://zjrb.zjol.com.cn/html/2013-11/29/node_18.htm";
			long now = System.currentTimeMillis();
			int year = 2013;
			
			while (year == 2013) {
				Date date = new Date(now);
				String day = new SimpleDateFormat("yyyy-MM/dd").format(now);
				year = Integer.parseInt(day.substring(0,4));
				System.out.println(year);
				bufferedWriter.append("http://zjrb.zjol.com.cn/html/"+day+"/node_18.htm\n");
				now -=86400000;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(bufferedWriter!=null){
					bufferedWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// System.out.println(new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new
		// Date(1376296170L)));
		// System.out.println(URLEncoder.encode("衢州"));
//		String luanString = "Â¥ÀïÓÐ¹ÉÆæ¹ÖµÄ³ôÎ¶ ¾ÓÃñÒÔÎªÊ¬Ìå¸¯ÀÃ-Äþ²¨ÆµµÀ-Õã½­ÔÚÏß";

	}

}
