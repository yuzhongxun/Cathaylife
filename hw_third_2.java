package com.cathay.hw3;

import java.util.*;

public class hw_third_2 {

	/**
	 * 輸入介於1-12間的整數m, 並運用java 的 Date, Calendar等類別列印出今年m月的月曆
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("請輸入一個數字(月份)：");
		int m = scanner.nextInt();

		Calendar cal = Calendar.getInstance(); // 回傳現在日期和時間
		cal.set(cal.get(Calendar.YEAR), m - 1, 1);

		System.out.println("\n    " + cal.get(Calendar.YEAR) + " 年 " + m + " 月");
		System.out.println("====================");
		System.out.println("日   一   二   三   四   五   六");
		System.out.println("--------------------");

		int calwk = cal.get(Calendar.DAY_OF_WEEK); // 取得現在是星期幾
		// int calmth = cal.get(Calendar.DAY_OF_MONTH); // 當月的第一天
		int mthday = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 取得當月最大天數

		// System.err.println(cal.get(Calendar.DAY_OF_WEEK)); // 取出和存入當月份星期幾的數值
		// System.err.println(Calendar.DAY_OF_WEEK); // 僅是一個值
		// System.err.println("calwk:" + calwk);
		// System.err.println("calmth:" + mthday);

		for (int i = 1; i < calwk; i++) {
			System.out.print("   "); // 先把空格印出來
		}
		for (int i = 1; i <= mthday; i++) { // set date of month
			if (i < 10) { // 個位數的印法
				System.out.print(" " + i + " ");
			} else { // 十進位的印法
				System.out.print(" " + i);
			} // 調整格式
			if (cal.get(Calendar.DAY_OF_WEEK) == 7) { // 每到星期六則跳行
				System.out.println("");
			}
			cal.add(Calendar.DAY_OF_MONTH, 1); // 往後累加現在的天數
		}
	}
}
