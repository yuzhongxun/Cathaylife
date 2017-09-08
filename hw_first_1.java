package com.cathay.hw1;

public class hw_first_1 {

	/** 
	 * 模擬1粒骰子投擲20次(隨機)，並統計點數總和出現的次數, 將結果以數字印出
	 * @param args
	 */
	public static void main(String[] args) {

		int[] totalArr = new int[6]; // 骰子點數6點, 產生新物件再建立array

		for (int i = 1; i <= 20; i++) {
			int number = (int) (Math.random() * 6 + 1); // 產生 0~5 的數字, +1 是 改變範圍 1~6
			totalArr[number - 1] = totalArr[number - 1] + 1; // 位移-1 從 index 從1開始, +1做累加次數
		}

		for (int i = 0; i < totalArr.length; i++) {
			int j = totalArr[i];
			System.out.println((i + 1) + " : " + j + " times");  // i + 1 做位移重複依順序印出 array 的值
		}

		System.out.println("finished");

		/*
		 * double k = Math.random() * 6 + 1; // 隨機產生變數(double 取小數點去尾數) * 骰子點數6點
		 * + 1(進位) int intK = (int) k; totalArr[intK - 1] = totalArr[intK - 1] + 1; // index 第1位作累加
		 * System.err.println("k:" + k); System.out.println("intk:" + intK);
		 */
	}
}
