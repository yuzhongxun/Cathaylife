package com.cathay.hw2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class hw_second_2 {

	/**
	 * 隨機產生15個介於1-10之間的BigDecimal(不能重覆), 將其取至小數第三位(四捨五入)並依序存入Collection類物件,
	 * 並進行下列計算: (1). 印出其排序後之數列 (2). 計算15個數字之平均值
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
			ArrayList <BigDecimal> ArrNum = new ArrayList<BigDecimal>();
				BigDecimal sum = new BigDecimal(0);
			
				for (int j = 0; j < 15; j++) { 
				 double num = (double) (Math.random() * 9 + 1);
				 BigDecimal BDnum = new BigDecimal(num);
				 ArrNum.add(BDnum.setScale(3, BigDecimal.ROUND_HALF_UP)); // 將 BDnum 取第3位數的 set 放入 Arraylist 
				 
				boolean isSame = true;
				while (isSame) {
					 	num = (double) (Math.random() * 9 + 1);
					 	BDnum = new BigDecimal(num);
						for (int k = 0; k < j - 1; k++) {
							BigDecimal tempNum = ArrNum.get(k); // 把一格的數值取出後放入 tempNum
							if (BDnum == tempNum) { // 判斷是否有重覆,若有重覆就跳過
								continue;
								// random
							}
						}
						isSame = false;
						ArrNum.set(j, BDnum.setScale(3, BigDecimal.ROUND_HALF_UP)); // 沒有重複就放入 ArrayList, 每個值都占一個 index
						sum = sum.add(BDnum); // sum 做加總回傳放入sum
					}			 						 
		}
						Collections.sort(ArrNum);  // 做 sort排序
						BigDecimal total = new BigDecimal(15);
						BigDecimal avg = sum.divide(total, 3, RoundingMode.HALF_UP);
						System.err.println("排序後: " + ArrNum);
						System.err.printf("平均數: " + avg);
	}
}
