package com.zjhcsoft.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DetainUrl {

	public void init() {
		appendToSomeWhere("/home/hadoop/dpi.txt", "/home/hadoop/dpiURL.txt");
	}

	public void appendToSomeWhere(String sourcePath, String appendToPath) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		File input = new File(sourcePath);
		File output = new File(appendToPath);
		if (output.exists()) {
			output.delete();
		}
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output, true)));
			String rdString = null;
			int x=0;
			bw.write("");
			while ((rdString = br.readLine()) != null) {
				String[] content = rdString.split("\\|");
				if (content.length<13) {
					continue;
				}
				if (!"".equals(content[12])) {
					bw.append(content[12]);
					bw.newLine();
					bw.newLine();
				}
				if (x==100) {
					break;
				}
			}
			
		} catch (IOException e) {
			throw new RuntimeException();
		} finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				throw new RuntimeException();
			}
		}
	}

	public static void main(String[] args) {
		new DetainUrl().init();
	}

}
