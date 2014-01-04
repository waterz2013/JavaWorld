package com.isandou.www.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.isandou.www.util.StringUtil;

public class AddNutchFetchInterval {

	public void init() {
		// appendToSomeWhere("/home/hadoop/urls/bbs/sanqu.txt","/home/hadoop/urls/bbs/quzhoubbs.txt");
		// appendToSomeWhere("/home/hadoop/urls/bbs/quzhou.txt","/home/hadoop/urls/bbs/quzhoubbs.txt");
		// appendToSomeWhere("/home/hadoop/urls/bbs/quzhou19lou.txt","/home/hadoop/urls/bbs/quzhoubbs.txt");
		// appendToSomeWhere("/home/hadoop/urls/bbs/jiufang.txt","/home/hadoop/urls/bbs/quzhoubbs.txt");
		// appendToSomeWhere("/home/hadoop/urls/bbs/jiutian.txt","/home/hadoop/urls/bbs/quzhoubbs.txt");
		// appendToSomeWhere("/home/hadoop/urls/bbs/fangmenjie.txt","/home/hadoop/urls/bbs/quzhoubbs.txt");
		// appendToSomeWhere("/home/hadoop/urls/news/csnews.txt","/home/hadoop/urls/news/news.txt");
		// appendToSomeWhere("/home/hadoop/urls/news/jsnews.txt","/home/hadoop/urls/news/news.txt");
		// appendToSomeWhere("/home/hadoop/urls/news/kcnews.txt","/home/hadoop/urls/news/news.txt");
		// appendToSomeWhere("/home/hadoop/urls/news/lynews.txt","/home/hadoop/urls/news/news.txt");
		// appendToSomeWhere("/home/hadoop/urls/news/qjnews.txt","/home/hadoop/urls/news/news.txt");
		// appendToSomeWhere("/home/hadoop/urls/news/quzhoulzjw.txt","/home/hadoop/urls/news/news.txt");
		// appendToSomeWhere("/home/hadoop/urls/news/quzhounews.txt","/home/hadoop/urls/news/news.txt");
		// appendToSomeWhere("/home/hadoop/urls/news/tongqu.txt","/home/hadoop/urls/news/news.txt");
		// appendToSomeWhere("/home/hadoop/urls/news/zjhbnews.txt","/home/hadoop/urls/existinterval/zjhbnews.txt");
		// appendToSomeWhere("/home/hadoop/urls/news/qq.txt","/home/hadoop/urls/existinterval/protalnews.txt");
		// appendToSomeWhere("/home/hadoop/urls/news/sina.txt","/home/hadoop/urls/existinterval/protalnews.txt");
		// appendToSomeWhere("/home/hadoop/urls/news/163.txt","/home/hadoop/urls/existinterval/protalnews.txt");
		// appendToSomeWhere("/home/hadoop/urls/news/sohu.txt","/home/hadoop/urls/existinterval/protalnews.txt");
		// appendToSomeWhere("/home/hadoop/urls/news/sohu.txt","/home/hadoop/urls/existinterval/searchengine.txt");
		appendToSomeWhere("/home/hadoop/workspace/lucenesolr-4.3/solr/isearch/seeds/bbs/", "/home/hadoop/urls/existinterval/bbs.txt");
	}

	public void appendToSomeWhere(String sourcePath, String appendToPath) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		File input = new File(sourcePath);
		File output = new File(appendToPath);
		try {
			if (input.exists()&&output.exists()) {
				if (input.isDirectory()) {
					for (String fileName: input.list()) {
						System.out.println(fileName);
					}
					
				}else {
					br = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
					bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output, true)));
					
					String rdString = null;
					while ((rdString = br.readLine()) != null) {
						if (!StringUtil.isEmpty(rdString)) {
							bw.append(rdString + "\tnutch.fetchInterval=43200\n");
						}
					}
				}
			}else {
				System.out.println("输入或输出路径不存在，请注意！");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		} finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				throw new RuntimeException();
			}
		}
	}

	public static void main(String[] args) {
		new AddNutchFetchInterval().init();
	}

}
