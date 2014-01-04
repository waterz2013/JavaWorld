package com.isandou.www.algorithm.sort;

import java.util.Arrays;

public class SelectSort {
	/**
	 * 简单选择排序
	 * 简介:每一趟从待排序的数据元素中选出最小（或最大）的一个元素，顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。
	 * 选择排序，分为简单选择排序、树形选择排序(锦标赛排序)、堆排序 此算法为简单选择排序 
	 * 时间复杂度为O(n^2)
	 * 不稳定排序方式
	 * @param nums 待排序数组
	 */
	public static void sort(int[] nums){
		for (int i = 0; i < nums.length; i++) {
			int minIndex = i;
			
			for (int j = i+1; j < nums.length; j++) {
				if (nums[minIndex]>nums[j]) {
					//指向较小指的指针变换
					minIndex = j;
				}
			}
			
			//把数据的交换提取出来可以有效减少交换次数,最多只需交换一次
			if (minIndex!=i) {
				int temp = nums[i];
				nums[i] = nums[minIndex];
				nums[minIndex] = temp;
			}
		}
	}
	
	
	// 简单选择排序的实现
	public static void main(String[] args) {

		int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };

		SelectSort.sort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
