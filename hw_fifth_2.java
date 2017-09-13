package com.cathay.hw5;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class hw_fifth_2 {

	/**
	 * b. 針對Manufacturer這個欄位將資料分組，並計算Min.Price ,Price這兩個欄位的小計、合計並輸出在螢幕上。
	 * ※所有的數字欄位請轉存成BigDecimal來運算
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<Map> carsList;
		try {
			carsList = new hw_fifth_1().carsPrice(); // 呼叫hw_fifth_1的carsprice
			// 錯誤會直接跳到下方return回傳到main, 不會執行return下方的code
		} catch (IOException e) {
			e.printStackTrace();
			return; // return回去main
		}
		// System.err.println("carsList:"+carsList); // 確認carsList

		// 擷取Manufacturer欄位做sort排序
		Comparator<Map> comparator = new Comparator<Map>() {
			public int compare(Map m1, Map m2) {
				return ((String) m1.get("Manufacturer")).compareTo((String) m2.get("Manufacturer"));
			}
		};
		Collections.sort(carsList, comparator); // 做sort

		String isSame = "";
		String Manu = (String) carsList.get(0).get("Manufacturer"); // 上一筆data
		BigDecimal tcntmp = BigDecimal.ZERO; // 設定合計初始 new BigDecimal("0");
		BigDecimal tcntpr = BigDecimal.ZERO;
		BigDecimal scntmp = BigDecimal.ZERO;	// 設定小計初始
		BigDecimal scntpr = BigDecimal.ZERO;
		
		System.out.println("Manufacturer\t"+ "Type\t" + "Min.Price\t" + "Price");

		for (int i = 0; i < carsList.size(); i++) {
			Map tmp = carsList.get(i);	// 先解鎖把list傳回map
			BigDecimal bdmp = (BigDecimal) tmp.get("Min.Price"); // map取key擷取到bdmin
			BigDecimal bdpr	= (BigDecimal) tmp.get("Price"); // map取key擷取到bdpr
			tcntmp = bdmp.add(tcntmp);	// bdmp做加總
			tcntpr = bdpr.add(tcntpr);	// bdpr做加總
			String cur = (String) tmp.get("Manufacturer"); // 現在這筆data
			
			
			System.out.println(tmp.get("Manufacturer") +"\n" + tmp.get("Type") + "\n" + tmp.get("Min.Price") + "\n" + tmp.get("Price")+ "\n" );
			
			if (cur.equals(Manu)) {  // Manufac和上一個比較若是相同就執行加總
				scntmp = bdmp.add(scntmp);
				scntpr = bdpr.add(scntpr);
			} else { // data歸零
				System.out.print("小計值: " + scntmp + " " + scntpr + "\n"); // 印出小計

				scntmp = BigDecimal.ZERO;	// data歸零後回傳
				scntpr = BigDecimal.ZERO;
				scntmp = scntmp.add(bdmp);
				scntpr = scntpr.add(bdpr);
				Manu = cur;	// 現在資料回歸上一筆再做執行
			}
		}
				System.out.print("小計值: " + " " + scntmp + " " + scntpr + "\n");
				System.out.print("合計值: " + tcntmp + " " + tcntpr + "\n");
	}
}
