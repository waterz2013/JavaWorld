package com.isandou.www.algorithm.search;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.isandou.www.algorithm.sort.QuickSort;

public class FibonacciSearch {
	
	static Logger logger = Logger.getLogger(FibonacciSearch.class);
	
	/**
	 * 斐波那契查找(费式查找)
	 * 说明:二分搜寻法每次搜寻时，都会将搜寻区间分为一半，所以其搜寻时间为O(log(2)n)，log(2)表示以2为底的log值，
	 * 		这边要介绍的费氏搜寻，其利用费氏数列作为间隔来搜寻下一个数，所以区间收敛的速度更快，搜寻时间为O(logn)。
	 * @param nums 待查找的数组
	 * @param num 带查找的值
	 * @return 带查找数的索引值
	 */
	public static int search(int[] nums, int num) {
		int[] fib = createFibonacci(nums.length);

		int x = findX(fib, nums.length + 1);
		int m = nums.length - fib[x];
		x--;
		int i = x;

		if (nums[i] < num){
			i += m;
		}

		while (fib[x] > 0) {
			if (nums[i] < num){
				i += fib[--x];
			}
			else if (nums[i] > num){
				i -= fib[--x];
			}
			else{
				return i;
			}
		}

		return -1;

	}

	/**
	 * 创建斐波那契数列
	 * @param max 新数列长度
	 * @return max长度的斐波那契数组
	 */
	private static int[] createFibonacci(int max) {
		int[] fib = new int[max];
		for (int i = 0; i < fib.length; i++) {
			fib[i] = Integer.MIN_VALUE;
		}

		fib[0] = 0;
		fib[1] = 1;

		for (int i = 2; i < max; i++){
			fib[i] = fib[i - 1] + fib[i - 2];
		}

		return fib;
	}
	
	/**
	 * 查找
	 * @param fib 查找数组对象
	 * @param n 长度
	 * @return
	 */
	private static int findX(int[] fib, int n) {
		int i = 0;

		while (fib[i] <= n){
			i++;
		}
		
		i--;

		return i;
	}
	
	/**
	 * 斐波那契查找实现
	 * @param args
	 */
	public static void main(String[] args) {
		//log4j默认配置
		BasicConfigurator.configure();
		
		int[] nums = { 1, 4, 2, 6, 7, 3, 9, 8 };

		QuickSort.sort(nums,0,nums.length-1);

		int find = FibonacciSearch.search(nums, 3);

		if (find != -1){
			logger.debug("找到数值于索引" + find);
		}
		else{
			logger.debug("找不到数值");
		}
	}
}
