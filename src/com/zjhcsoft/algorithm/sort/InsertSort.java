package com.zjhcsoft.algorithm.sort;

import java.util.Arrays;

public class InsertSort {
	/**
	 * 直接插入排序
	 * 简介:将一个数据插入到已经排好序的有序数据中，从而得到一个新的、个数加一的有序数据
	 * 时间复杂度为O(n^2)
	 * 稳定排序方式
	 * @param nums 待排序数组
	 */
	public static void sort(int[] nums){
		for (int i = 0; i < nums.length-1; i++) {
			int j = i+1;
			int temp = nums[j];
			//待插入数与以排序部分的最大数,即nums[i]进行比较
			while(i>=0 && nums[i]>temp){
				nums[j]=nums[i];
				i--;
				j--;
			}
			nums[j] = temp;
		}
	}
	
	// 直接插入排序的实现
	public static void main(String[] args) {

		int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };

		InsertSort.sort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
