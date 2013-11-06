package com.zjhcsoft.test;

/**
 * hashcode比较
 * @author Administrator
 *
 */
public class HashCodeTest {
	
	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder(" #杭州湾污染# @肖隆平:我曾经接触过类似排污现象，试图报道");
		StringBuilder sb2 = new StringBuilder(" #杭州湾污染# @肖隆平:我曾经接触过类似排污现象，试图报道");
		String string1 = " #杭州湾污染# @肖隆平:我曾经接触过类似排污现象，试图报道1";
		String string2 = " #杭州湾污染# @肖隆平:我曾经接触过类似排污现象，试图报道";
		System.out.println(string1.hashCode());
		System.out.println(string2.hashCode());
		System.out.println(sb1.toString().hashCode());
		System.out.println(sb2.toString().hashCode());
		System.out.println(" #杭州湾污染# @肖隆平:我曾经接触过类似排污现象，试图报道".hashCode() == " #杭州湾污染# @肖隆平:我曾经接触过类似排污现象，试图报道".hashCode());
	}
}
