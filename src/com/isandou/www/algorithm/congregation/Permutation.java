package com.isandou.www.algorithm.congregation;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Permutation {

	static Logger logger = Logger.getLogger(Permutation.class);

	/**
	 * 排列组合
	 * 说明:将一组数字、字母或符号进行排列，以得到不同的组合顺序，例如1 2 3这三个数的排列组合有：1 2 3、1 3 2、2 1 3、2 3 1、3 1 2、3 2 1。
	 * @param nums 待处理数组
	 * @param i 排序的起始
	 */
	public static void perm(int[] nums, int i) {

		if (i < nums.length - 1) {
			for (int j = i; j <= nums.length - 1; j++) {
				int tmp = nums[j];
				// 旋转该区段最右边数字至最左边
				for (int k = j; k > i; k--) {
					nums[k] = nums[k - 1];
				}
				nums[i] = tmp;

				perm(nums, i + 1);

				// 还原
				for (int k = i; k < j; k++) {
					nums[k] = nums[k + 1];
				}
				nums[j] = tmp;
			}
		} else { // 显示此次排列
			for (int j = 1; j <= nums.length - 1; j++) {
				logger.debug("第" + j + "个数:" + nums[j]);
			}
			logger.debug("");
		}
	}

	/**
	 * 排列组合的实现
	 * @param args
	 */
	public static void main(String[] args) {
		// log4j默认配置
		BasicConfigurator.configure();
		
		//制定序列的最大数
		int num = 4;
		int[] nums = new int[num + 1];

		for (int i = 1; i <= nums.length - 1; i++){
			nums[i] = i;
		}

		perm(nums, 1);
	}
}
