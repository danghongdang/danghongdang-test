package com.danghongdang;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CodeC {

	// 查询文件
	private static List<File> sourceFileList = new ArrayList<>();
	private static List<File> otherFileList = new ArrayList<>();

	// 获取文件下所有文件
	private static void getFileList(File f) throws IOException {
		if (!f.exists()) {
			System.out.println("文件不存在");
		} else {
			// 如果是文件
			if (f.isFile()) {
				String fName = f.getName();
				if (fName.substring(fName.lastIndexOf(".") + 1).equals("java")) {
					sourceFileList.add(f);
					Thread t = new Thread(new FileC(f));
					t.start();
					threadList.add(t);
				} else {
					otherFileList.add(f);
				}
			} else { // 是路径
				File[] files = f.listFiles();
				if (files == null) {
					return;
				}
				for (File tmpF : files) {
					getFileList(tmpF);
				}
			}
		}
	}

	static class FileC implements Runnable {
		private File f;
		FileC (File f) {
			this.f = f;
		}
		@Override
		public void run() {
			try {
				getCodeNum(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static ConcurrentHashMap<String, Integer> fileCodeCountMap = new ConcurrentHashMap<>(); // 有效代码行数
	private static ConcurrentHashMap<String, Integer> fileNoCodeCountMap = new ConcurrentHashMap<>(); // 注释行数
	private static ConcurrentHashMap<String, Integer> fileNullCountMap = new ConcurrentHashMap<>(); // 空行

	private static List<Thread> threadList = new ArrayList<>();

	private static void getCodeNum(File f) throws IOException {
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(f));
			BufferedReader br = new BufferedReader(inputStreamReader);
			int codeCount = 0;
			int noCodeCount = 0;
			int nullCount = 0;
			String str;
			while ((str = br.readLine()) != null) {
				if (str.startsWith("//")
						|| str.startsWith("*")
						|| str.startsWith("/*")) {
					noCodeCount ++;
				} else if (str.isEmpty()) {
					nullCount ++;
				} else {
					codeCount ++;
				}
			}
			fileCodeCountMap.put(f.getAbsolutePath(), codeCount);
			fileNoCodeCountMap.put(f.getAbsolutePath(), noCodeCount);
			fileNullCountMap.put(f.getAbsolutePath(), nullCount);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws InterruptedException {
		try {
			getFileList(new File("/home/danghongdang/Desktop/mail"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Thread t : threadList) {
			if (t.isAlive()) {
				Thread.sleep(1000);
			}
		}
		System.out.println("在此文件下面一共有源码文件个数：" + sourceFileList.size());
		System.out.println("非源码个数：" + otherFileList.size());
		for (Map.Entry<String, Integer> entry : fileCodeCountMap.entrySet()) {
			Integer noCodeCount = fileNoCodeCountMap.get(entry.getKey());
			Integer nullCount = fileNullCountMap.get(entry.getKey());
			System.out.print("文件: " + entry.getKey() + ", 代码行数：" + entry.getValue());
			System.out.print(", 注释行数：" + (noCodeCount == null ? 0 : noCodeCount));
			System.out.println(", 空行数：" + (nullCount == null ? 0 : nullCount));
		}
	}
}
