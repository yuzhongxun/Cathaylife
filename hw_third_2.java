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

		Calendar cal =  Calendar.getInstance(); // 回傳 current time
		cal.set(cal.get(Calendar.YEAR), m - 1, 1);
				
		System.out.println("\n    " + cal.get(Calendar.YEAR) + " 年 " + m + " 月");
		System.out.println("====================");
		System.out.println("日   一   二   三   四   五   六");
		System.out.println("--------------------");	
		
		//System.err.println(cal.get(Calendar.DAY_OF_WEEK)); // 取出和存入當月份星期幾的數值
		//System.err.println(Calendar.DAY_OF_WEEK); // 僅是一個值
		int totalCnt = 0;
		int calwk = cal.get(Calendar.DAY_OF_WEEK);
		int calmth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		for(int i=1; i< calwk; i++){
			System.out.print("   ");
			totalCnt++;  // 計算第幾個位數之後換行
				for (int j = 1; j <= calmth; j++) {  // set date of month
			if (i % 7 == 0) {	// 換行
				System.out.print("\n");			
			}
			System.out.print(j + "  ");
			totalCnt++;
		}
	}
	}
}
