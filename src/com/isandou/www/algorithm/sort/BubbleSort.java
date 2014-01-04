package com.isandou.www.algorithm.sort;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BubbleSort {
	
	
	static Logger logger = Logger.getLogger(BubbleSort.class);
	
	/**
	 * 冒泡排序
	 * 简介:由于在排序过程中总是小数往前放，大数往后放，相当于气泡往上升，所以称作冒泡排序。
	 * 时间复杂度为O（n^2）
	 * 稳定排序方式
	 * @param nums 待排序数组
	 */
	public static void sort(int[] nums){
		boolean isChanged;
		for (int i = 0; i < nums.length; i++) {
			isChanged = false;
			//若发现较大元素,则往后移
			for (int j = 0; j < nums.length-i-1; j++) {
				if (nums[j]>nums[j+1]) {
					int temp = nums[j+1];
					nums[j+1]=nums[j];
					nums[j]=temp;
					isChanged = true;
				}
			}
			//若没有移动,说明序列已经有序,跳出循环
			if (!isChanged) {
				break;
			}
		}
	}
	
	// 冒泡排序的实现
	public static void main(String[] args) {
		//log4j默认配置   
//		BasicConfigurator.configure(); 
		
		//动态配置,参数可以是一个properties文件所在路径的String对象       
		PropertyConfigurator.configure("E:/wangtao/BigJava/jar包/log4j.properties");       
        
		
		int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };

		BubbleSort.sort(nums);
		logger.debug(Arrays.toString(nums));
		System.out.println(5&11);
		System.out.println(5|11);
//		System.out.println(Arrays.toString(nums));
		
	}
}
