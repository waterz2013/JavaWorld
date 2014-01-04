package com.isandou.www.algorithm.gamble;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class ShuffleCard {

	static Logger logger = Logger.getLogger(ShuffleCard.class);

	/**
	 * 洗扑克牌(乱数排列)
	 * 简介:洗扑克牌的原理其实与乱数排列是相同的，都是将一组数字（例如1～N）打乱重新排列，只不过洗扑克牌多了一个花色判断的动作而已。
	 * @param args
	 */
	public static void main(String args[]) {
		//log4j默认配置
		BasicConfigurator.configure();
		
		final int N = 52;
		int[] poker = new int[N + 1];

		// 初始化阵列
		for (int i = 1; i <= N; i++)
			poker[i] = i;

		// 洗牌
		for (int i = 1; i <= N; i++) {
			int j = (int) (Math.random() * N);

			if (j == 0)
				j = 1;

			int tmp = poker[i];
			poker[i] = poker[j];
			poker[j] = tmp;
		}

		for (int i = 1; i <= N; i++) {
			// 判断花色
			switch ((poker[i] - 1) / 13) {
			case 0:
				logger.debug("黑桃");
				break;
			case 1:
				logger.debug("红桃");
				break;
			case 2:
				logger.debug("方块");
				break;
			case 3:
				logger.debug("梅花");
				break;
			}

			// 扑克牌数字
			int remain = poker[i] % 13;
			switch (remain) {
			case 0:
				logger.debug("K ");
				break;
			case 12:
				logger.debug("Q ");
				break;
			case 11:
				logger.debug("J ");
				break;
			default:
				logger.debug(remain + " ");
				break;
			}

			if (i % 13 == 0)
				logger.debug("");
		}
	}
}
