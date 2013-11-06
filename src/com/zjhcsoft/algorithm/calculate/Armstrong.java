package com.zjhcsoft.algorithm.calculate;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Armstrong {

	static Logger logger = Logger.getLogger(Armstrong.class);

	/**
	 * 阿姆斯壮数
	 * 说明:在三位的整数中，例如153可以满足13 + 53 + 33 = 153，这样的数称之为Armstrong数，试写出一程式找出所有的三位数Armstrong数。
	 * @param args
	 */
	public static void main(String[] args) {
		// log4j默认配置
		BasicConfigurator.configure();
		
		logger.debug("寻找Armstrong数：");

		for (int i = 100; i <= 999; i++) {
			int a = i / 100;
			int b = (i % 100) / 10;
			int c = i % 10;
			if (a * a * a + b * b * b + c * c * c == i)
				logger.debug(i + " ");
		}

	}
}
