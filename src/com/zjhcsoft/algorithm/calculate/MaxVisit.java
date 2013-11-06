package com.zjhcsoft.algorithm.calculate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class MaxVisit {
	
	static Logger logger = Logger.getLogger(MaxVisit.class);

	/**
	 * 典故:现将举行一个餐会，让访客事先填写到达时间与离开时间，为了掌握座位的数目，必须先估计不同时间的最大访客数。
	 * 算法思路:假设访客 i 的来访时间为x[i]，而离开时间为y[i]。在资料输入完毕之后，将x[i]与y[i]分别进行排序（由小到大），道理很简单，只要先计算
	 *			某时之前总共来访了多少访客，然后再减去某时之前的离开访客，就可以轻易的解出这个问题。 
	 * @param x 来访时间数组
	 * @param y 离开时间数组
	 * @param time 时间点
	 * @return
	 */
	
	public static int maxGuest(int[] x, int[] y, int time) {
		int num = 0;

		// 进行时间点的比较
		for (int i = 0; i < x.length; i++) {
			//已经到访,则人数加一
			if (time > x[i]) {
				num++;
			}
			//已经离开,则人数减一
			if (time > y[i]) {
				num--;
			}
		}

		return num;
	}

	public static void main(String[] args) throws IOException {
		//log4j默认配置
		BasicConfigurator.configure();
		
		//输入数据
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		logger.debug("输入来访时间与离开时间(0~24)：");
		logger.debug("范例：10 15");
		logger.debug("输入-1结束");

		java.util.ArrayList<String> list = new ArrayList<String>();

		while (true) {
			logger.debug(">>");
			String input = buf.readLine();

			if (input.equals("-1")) {
				break;
			}

			list.add(input);
		}

		int[] x = new int[list.size()];//到访时间数组
		int[] y = new int[list.size()];//离开时间数组

		//对录入数据进行处理
		for (int i = 0; i < x.length; i++) {
			String input = (String) list.get(i);
			String[] strs = input.split(" ");

			x[i] = Integer.parseInt(strs[0]);
			y[i] = Integer.parseInt(strs[1]);
		}

		Arrays.sort(x);
		Arrays.sort(y);

		for (int time = 0; time < 25; time++) {
			logger.debug(time + " 时的最大访客数："
					+ MaxVisit.maxGuest(x, y, time));
		}
	}
}