package com.zjhcsoft.algorithm.search;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.zjhcsoft.algorithm.sort.QuickSort;

public class InterpolationSearch {
	
	static Logger logger = Logger.getLogger(InterpolationSearch.class);
	
	/**
	 * 插补查找
	 * 说明:如果却搜寻的资料分布平均的话，可以使用插补查找来进行查找，在查找的对象大于500时，插补查找法会比 二分查找法 来的快速。
	 * @param nums 待查找的数组
	 * @param num 带查找的值
	 * @return 带查找数的索引值
	 */
	public static int search(int[] nums, int num) {
		int low = 0;
		int upper = nums.length - 1;

		while (low <= upper) {
			int mid = (upper - low) * (num - nums[low])
					/ (nums[upper] - nums[low]) + low;
			if (mid < low || mid > upper)
				return -1;

			if (num < nums[mid])
				upper = mid - 1;
			else if (num > nums[mid])
				low = mid + 1;
			else
				return mid;
		}

		return -1;
	}

	/**
	 * 插补查找的实现
	 * @param args
	 */
	public static void main(String[] args) {
		//log4j默认配置
		BasicConfigurator.configure();
		
		int[] nums = { 1, 4, 2, 6, 7, 3, 9, 8 };

		QuickSort.sort(nums,0,nums.length-1);

		int find = InterpolationSearch.search(nums, 3);

		if (find != -1)
			logger.debug("找到数值于索引" + find);
		else
			logger.debug("找不到数值");
	}
}
