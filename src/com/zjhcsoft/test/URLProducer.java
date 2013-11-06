package com.zjhcsoft.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;

public class URLProducer {
	static String IKeywords[] = "污染,废气,辐射,垃圾,噪音,噪声,水质,空气".split(",");
	static String keywords[] = "pm,超标,臭气,臭味,光污染,处理厂,重金属,电磁,恶臭熏天,二氧化硫,二氧化碳,放射性,焚烧,核事故,化工厂,甲醛,减排,节能,扰民,死鱼,偷排,污垢,污泥,雾霾,脏,中毒".split(",");
	static String addr[] = "浙江 ,衢州 ".split(",");
	static final int IPAGE_LEN = 10;
	static final int PAGE_LEN = 5;

	@SuppressWarnings("deprecation")
	public static void produceGoogleUrl(BufferedWriter bufferedWriter) throws IOException {
		for (String kw : IKeywords) {
			for (int i = 0; i < IPAGE_LEN; i++) {
				for (int j = 0; j < addr.length; j++) {
					String record = "http://www.google.de/search?q=" + URLEncoder.encode(addr[j] + kw) + "&tbm=nws&start=" + 10 * i
							+ "\tnutch.fetchInterval=7200\n";
					bufferedWriter.append(record);
					//System.out.println(record);
				}
			}
		}
		for (String kw : keywords) {
			for (int i = 0; i < PAGE_LEN; i++) {
				for (int j = 0; j < addr.length; j++) {
					String record = "http://www.google.de/search?q=" + URLEncoder.encode(addr[j] + kw) + "&tbm=nws&start=" + 10 * i
							+ "\tnutch.fetchInterval=7200\n";
					bufferedWriter.append(record);
					//System.out.println(record);
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static void produceBaiduUrl(BufferedWriter bufferedWriter) throws IOException {
		for (String kw : IKeywords) {
			for (int i = 0; i < IPAGE_LEN; i++) {
				for (int j = 0; j < addr.length; j++) {
					String record = "http://news.baidu.com/ns?bt=0&et=0&si=&rn=20&tn=news&ie=utf8&ct=0&word=" + URLEncoder.encode(addr[j] + kw) + "&pn="
							+ 20 * i + "\tnutch.fetchInterval=7200\n";
					bufferedWriter.append(record);
					//System.out.println(record);
				}
			}
		}
		for (String kw : keywords) {
			for (int i = 0; i < PAGE_LEN; i++) {
				for (int j = 0; j < addr.length; j++) {
				String record = "http://news.baidu.com/ns?bt=0&et=0&si=&rn=20&tn=news&ie=utf8&ct=1&word=" + URLEncoder.encode(addr[j] + kw) + "&pn="
						+ 20 * i + "\tnutch.fetchInterval=7200\n";
				bufferedWriter.append(record);
				//System.out.println(record);
				}
			}
		}
	}

	public static void produceBingUrl(BufferedWriter bufferedWriter) throws IOException {
		for (String kw : IKeywords) {
			for (int i = 0; i < IPAGE_LEN; i++) {
				for (int j = 0; j < addr.length; j++) {
				String record = "http://cn.bing.com/news/search?q=" + URLEncoder.encode(addr[j] + kw)
						+ "&p1=%5bNewsVertical+SortByDate%3d%221%22+Interval%3d%227%22%5d&first=" + (10 * i + 1) + "\tnutch.fetchInterval=7200\n";
				bufferedWriter.append(record);
				//System.out.println(record);
				}
			}
		}
		for (String kw : keywords) {
			for (int i = 0; i < PAGE_LEN; i++) {
				for (int j = 0; j < addr.length; j++) {
				String record = "http://cn.bing.com/news/search?q=" + URLEncoder.encode(addr[j] + kw)
						+ "&p1=%5bNewsVertical+SortByDate%3d%221%22+Interval%3d%227%22%5d&first=" + (10 * i + 1) + "\tnutch.fetchInterval=7200\n";
				bufferedWriter.append(record);
				//System.out.println(record);
				}
			}
		}
	}

	public static void produce360Url(BufferedWriter bufferedWriter) throws IOException {
//		for (String kw : IKeywords) {
//			for (int i = 0; i < IPAGE_LEN; i++) {
//				String record = "http://news.so.com/ns?q=" + URLEncoder.encode(addr[j] + kw) + "&pn=" + (i + 1)
//						+ "&tn=news&rank=pdate\tnutch.fetchInterval=7200\n";
//				bufferedWriter.append(record);
//				//System.out.println(record);
//			}
//		}
//		for (String kw : keywords) {
//			for (int i = 0; i < PAGE_LEN; i++) {
//				String record = "http://news.so.com/ns?q=" + URLEncoder.encode(addr[j] + kw) + "&pn=" + (i + 1)
//						+ "&tn=news&rank=pdate\tnutch.fetchInterval=7200\n";
//				bufferedWriter.append(record);
//				//System.out.println(record);
//			}
//		}
	}
	
	public static void produceSogou(BufferedWriter bufferedWriter) throws IOException {
		String info[] = new String[3];
		info[0] = "http://news.sogou.com/news?mode=1&media=&query=";
		info[1] = "&time=0&clusterId=&sort=1&page=";
		info[2] = "\tnutch.fetchInterval=1800\n";
		process(bufferedWriter, info);
	}
	
	public static void produceWeiboUrl(BufferedWriter bufferedWriter) throws IOException {
		String info[] = new String[3];
		info[0] = "http://weibo.yunyun.com/Weibo.php?q=";
		info[1] = "&wbts=1&p=";
		info[2] = "\tnutch.fetchInterval=1800\n";
		process(bufferedWriter, info);
	}

	public static void process(BufferedWriter bufferedWriter,String info[]) throws IOException {
		for (String kw : IKeywords) {
			for (int i = 0; i < IPAGE_LEN; i++) {
				for (int j = 0; j < addr.length; j++) {
					String record = info[0] + URLEncoder.encode(addr[j] + kw)
							+ info[1]+(i+1)+info[2];
					bufferedWriter.append(record);
				}
			}
		}
		for (String kw : keywords) {
			for (int i = 0; i < PAGE_LEN; i++) {
				for (int j = 0; j < addr.length; j++) {
					String record = info[0] + URLEncoder.encode(addr[j] + kw)
							+ info[1]+(i+1)+info[2];
					bufferedWriter.append(record);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// produceGoogleUrl();
		System.out.println("重要环保关键词:"+IKeywords.length+"\n一般环保关键词:"+keywords.length);
		
		File file = new File("/home/hadoop/urls/existinterval/weibo.txt");
		
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write("");
//			produceBaiduUrl(bufferedWriter);
//			produceBingUrl(bufferedWriter);
//			produce360Url(bufferedWriter);
//			produceSogou(bufferedWriter);
			produceWeiboUrl(bufferedWriter);
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
