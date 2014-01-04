package com.isandou.www.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownImage {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		// 构造URL
		URL url;
		try {
			url = new URL("http://avatar.csdn.net/B/9/C/1_nntt2010.jpg");
			// 打开连接
			URLConnection con = url.openConnection();
			// 输入流
			InputStream is = con.getInputStream();
			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流
			OutputStream os = new FileOutputStream("/home/hadoop/image.jpg");
			// 开始读取
			while ((len = is.read(bs)) != -1) {
//				System.out.println(bs);
				os.write(bs, 0, len);
			}
			// 完毕，关闭所有链接
			os.close();
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
