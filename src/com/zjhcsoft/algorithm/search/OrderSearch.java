package com.zjhcsoft.algorithm.search;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.zjhcsoft.algorithm.sort.QuickSort;

public class OrderSearch {
	
	static Logger logger = Logger.getLogger(OrderSearch.class);

	/**
	 * 顺序查找
	 * 简介:在一个已知无(或有序）序队列中找出与给定关键字相同的数的具体位置。原理是让关键字与队列中的数从第一个开始逐个比较，
	 * 		直到找出与给定关键字相同的数为止。
	 * @param nums 待查找的数组
	 * @param num 待查找的值
	 * @return 带查找数的索引值
	 */
	public static int search(int[] nums, int num) {
        int[] tmp = new int[nums.length + 1];
        
        for(int i = 1; i < tmp.length; i++) {
            tmp[i] = nums[i-1];  
        }
        
        tmp[0] = num;
        
        int k = tmp[0]; 
        int i = nums.length; 
        
        //当判断到tmp[0]的时候,不管数组中找不找得到数值,都跳出循环
        while(tmp[i] != k) {
        	i--; 
        }
        /*传统写法,此处的顺序查找进行了改进,省去了
        int i = 0;
        while(i < nums.length) { 
            if(nums[i] == k) { 
            	logger.debug("找到指定值");
                break; 
            } 
            i++; 
        } */

        return i - 1;    
    }
	
    /**
     * 顺序查找算法的实现
     * @param args
     */
    public static void main(String[] args) {
    	//log4j默认配置
		BasicConfigurator.configure();
		
        int[] nums = {1, 4, 2, 6, 7, 3, 9, 8};
        
        QuickSort.sort(nums,0,nums.length-1);
        
        int find = OrderSearch.search(nums, 3);
        
        if(find != 0) 
            logger.debug("找到数值于索引" + find); 
        else 
            logger.debug("找不到数值"); 
    }
}
