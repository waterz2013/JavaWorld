package com.isandou.www.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.isandou.www.util.StringUtil;

public class Dongwuxdl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "/home/hadoop/冬吴相对论";
		File dir = new File(path);
//		File fi1le = new File("/home/hadoop/documents/冬吴相对论/东吴相对论41-60.txt");
//		fi1le.renameTo(new File("/home/hadoop/documents/冬吴相对论/东吴相对论41-60.txt1"));
		ArrayList<String> dwList = new ArrayList<String>();

		if (dir.isDirectory()) {
			File files[] = dir.listFiles();
			for (File file : files) {
				String fileName = file.getName();
//				System.out.println(fileName);
				if (fileName.split(" ").length > 1) {
					dwList.add(fileName.substring(0,fileName.lastIndexOf(".")));
				}
				String name = "";
				String num = "";
				// System.out.println(fileName);
				if (fileName.indexOf("第") != -1 && fileName.indexOf("期") != -1) {
					num = fileName.substring(fileName.indexOf("第") + 1, fileName.indexOf("期")).trim();
					
					if (fileName.lastIndexOf("《") != -1) {
						name = fileName.substring(fileName.lastIndexOf("《") + 1, fileName.lastIndexOf("》")).trim();
					} else if (fileName.lastIndexOf("—") != -1) {
						name = fileName.substring(fileName.lastIndexOf("—") + 1, fileName.lastIndexOf(".")).trim()
								.replace("《", "").replace("》", "");
					}
					if (!StringUtil.isEmpty(num)&&!StringUtil.isEmpty(name)) {
						String newName = num + " " + name;
						dwList.add(num + " " + name);
						String suffix = fileName.substring(fileName.lastIndexOf("."),fileName.length());
						file.renameTo(new File("/home/hadoop/documents/冬吴相对论/"+newName+suffix));
					}
				}
				// file.renameTo(new File("/home/hadoop/documents/冬吴相对论/"+);
			}
			System.out.println(dwList.size());
			Collections.sort(dwList, new Comparator<String>() {
				public int compare(String o1, String o2) {
					Integer i1 = Integer.parseInt(o1.split(" ")[0]);
					Integer i2 = Integer.parseInt(o2.split(" ")[0]);
					return i1.compareTo(i2);
				};
			});

			Map<Integer,Integer> iMap = new HashMap<Integer, Integer>();
			int num = Integer.parseInt(dwList.get(dwList.size()-1).split(" ")[0]);
			
			for (int j = 1; j <= num; j++) {
				iMap.put(j, 0);
			}
			
			for (String dw : dwList) {
				int i = Integer.parseInt(dw.split(" ")[0]);
				if (i>num) {
					System.out.println("超出排序范围");
				}else {
					iMap.put(i, 1);
				}
				System.out.println(dw);
			}
			
			System.out.println("缺少以下期数：");
			ArrayList<Integer> iList = new ArrayList<Integer>();
			for (Integer i : iMap.keySet()) {
				if (iMap.get(i)!=1) {
					iList.add(i);
				}
			}
			Integer[] is = iList.toArray(new Integer[iList.size()]);
			Arrays.sort(is);
			for (int i = 0; i < is.length; i++) {
				System.out.print(is[i]+" ");
			}
			
		}
	}

}
