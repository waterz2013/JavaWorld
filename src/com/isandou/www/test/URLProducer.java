package com.isandou.www.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class URLProducer {
	static List<String> keywordList = new ArrayList<String>();

	private static void init(int[] lens) {
		String keywords1[] = "污染,垃圾,噪声,水质,空气".split(",");
		String keywords2[] = "废气,辐射,噪音,pm,超标,处理厂,重金属,电磁,二氧化硫,二氧化碳,放射性,焚烧,核事故,化工厂,甲醛,减排,节能,扰民,偷排,污垢,污泥,雾霾,脏,中毒".split(",");
		String keywords3[] = "臭气臭味光污染".split(",");
		String ADDR1[] = "浙江 ,杭州 ,宁波 ,温州 ,嘉兴 ,绍兴 ,金华 ".split(",");
		String ADDR2[] = "衢州 ,湖州 ,台州 ,丽水 ,舟山 ".split(",");
		for (int i = 0; i < keywords1.length; i++) {
			for (int j = 0; j < ADDR1.length; j++) {
				keywordList.add(ADDR1[j]+keywords1[i]+","+lens[0]);
			}
			for (int j = 0; j < ADDR2.length; j++) {
				keywordList.add(ADDR1[j]+keywords1[i]+","+lens[1]);
			}
		}
		for (int i = 0; i < keywords2.length; i++) {
			for (int j = 0; j < ADDR1.length; j++) {
				keywordList.add(ADDR1[j]+keywords1[i]+","+lens[1]);
			}
			for (int j = 0; j < ADDR2.length; j++) {
				keywordList.add(ADDR1[j]+keywords1[i]+","+lens[3]);
			}
		}
		for (int i = 0; i < keywords3.length; i++) {
			for (int j = 0; j < ADDR1.length; j++) {
				keywordList.add(ADDR1[j]+keywords1[i]+","+lens[2]);
			}
			for (int j = 0; j < ADDR2.length; j++) {
				keywordList.add(ADDR1[j]+keywords1[i]+","+lens[4]);
			}
		}
		
	}
	
	public static void produceBaiduUrl(BufferedWriter bufferedWriter) throws IOException {
		String info[] = new String[3];
		info[0] = "http://news.baidu.com/ns?bt=0&et=0&si=&rn=20&tn=news&ie=utf8&ct=0&word=";
		info[1] = "&pn=";
		info[2] = "\tnutch.fetchInterval=3600\n";
		process(bufferedWriter, info);
	}

	public static void produceBingUrl(BufferedWriter bufferedWriter) throws IOException {
		String info[] = new String[3];
		info[0] = "http://cn.bing.com/news/search?q=";
		info[1] = "&p1=%5bNewsVertical+SortByDate%3d%221%22+Interval%3d%227%22%5d&first=";
		info[2] = "\tnutch.fetchInterval=600\n";
		process(bufferedWriter, info);
	}

	public static void produce360Url(BufferedWriter bufferedWriter) throws IOException {
		String info[] = new String[3];
		info[0] = "http://news.so.com/ns?q=";
		info[1] = "&pn=";
		info[2] = "&tn=news&rank=pdate\tnutch.fetchInterval=600\n";
		process(bufferedWriter, info);
	}
	
	public static void produceSogou(BufferedWriter bufferedWriter) throws IOException {
		String info[] = new String[3];
		info[0] = "http://news.sogou.com/news?mode=1&media=&query=";
		info[1] = "&time=0&clusterId=&sort=1&page=";
		info[2] = "\tnutch.fetchInterval=600\n";
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
		for (String keyword:keywordList) {
			int len = Integer.parseInt(keyword.split(",")[1]);
			for (int i = 1; i < len+1; i++) {
				bufferedWriter.append(info[0] + URLEncoder.encode(keyword)
						+ info[1]+(i)+info[2]);
			}
			
		}
//		for (String kw : Keywords1) {
//			for (int i = 0; i < LEN1; i++) {
//				for (int j = 0; j < ADDR2.length; j++) {
//					String record = info[0] + URLEncoder.encode(ADDR2[j] + kw)
//							+ info[1]+(i+1)+info[2];
//					bufferedWriter.append(record);
//				}
//			}
//		}
//		for (String kw : keywords2) {
//			for (int i = 0; i < PAGE_LEN; i++) {
//				for (int j = 0; j < ADDR2.length; j++) {
//					String record = info[0] + URLEncoder.encode(ADDR2[j] + kw)
//							+ info[1]+(i+1)+info[2];
//					bufferedWriter.append(record);
//				}
//			}
//		}
	}
	
	public static void main(String[] args) {
		// produceGoogleUrl();
//		System.out.println("重要环保关键词:"+Keywords1.length+"\n一般环保关键词:"+keywords2.length);
		int[] level = {1,1,1,1,1};
		init(level);
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
