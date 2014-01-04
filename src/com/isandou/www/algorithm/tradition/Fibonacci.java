package com.isandou.www.algorithm.tradition;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Fibonacci {

	static Logger logger = Logger.getLogger(Fibonacci.class);

	/**
	 * 斐波那契数列
	 * 典故:Fibonacci为1200年代的欧洲数学家，在他的著作中曾经提到：“若有一只免子每个月生一只小免子，一个月后小免子也开始生产。
	 * 		起初只有一只免 子，一个月后就有两只免子，二个月后有三只免子，三个月后有五只免子（小免子投入生产）......”。
	 * @param len 斐波那契数长度
	 * @return
	 */
	public static int[] fibonacci(int len) {
		int[] fib = new int[len];

		fib[0] = 0;
		fib[1] = 1;

		for (int i = 2; i < fib.length; i++)
			fib[i] = fib[i - 1] + fib[i - 2];

		for (int i = 0; i < fib.length; i++) {
			logger.debug(fib[i] + " ");
		}

		return fib;
	}

	/**
	 * 斐波那契数列实现
	 * @param args
	 */
	public static void main(String[] args) {
		// log4j默认配置
		BasicConfigurator.configure();
		fibonacci(10);

	}

}
