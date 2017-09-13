package com.cathay.hw5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hw_fifth_1 {

	private static final Exception Exception = null;

	/**
	 * 1. 請下載cars.csv這個檔案 (csv檔為逗號分隔的檔案) 將檔案在Java中讀取，並做以下輸出：
	 * 
	 * a. 一筆資料轉存成一個Map，並將所有資料放入List中並 利用Collections類別的sort方法，針對Price這個欄位進行
	 * 資料排序後輸出成另一份檔案, ex: cars2.csv 。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new hw_fifth_1().carsPrice();	// new Obj呼叫下方的function
		} catch (IOException e) {
			e.printStackTrace();	// 回報錯誤訊息
		}
	}

	// 建立public名為carsPrice的List
	public List carsPrice() throws IOException {
		// 讀取csv
		BufferedReader reader = new BufferedReader(new FileReader(
				"D:\\新進人員作業\\作業五 - 檔案與數字分析\\cars.csv"));
		String rd = reader.readLine(); // 跳過第一列標題讀取
		String[] keys = rd.split(","); // key做split
		String line = null;
		List<Map> lst = new ArrayList<Map>(); // 建立list
		while ((line = reader.readLine()) != null) { // 讀取非空值的時候
			String[] item = line.split(","); // item做split
			String value = item[item.length - 1]; // data的item內容,保留header
			Map mapdb = new HashMap(); // 建立map,暫不要設定泛型

			// readline 讀取後丟進map, 建立key和value值
			for (int i = 0; i < keys.length; i++) {
				String key = keys[i];
				value = item[i];
				if ("Price".equals(key) || "Min.Price".equals(key)) { // 這兩欄位轉成BigDecimal
					mapdb.put(key, new BigDecimal(value)); // key值放入map
				} else {
					mapdb.put(key, value);
				}
			}
			lst.add(mapdb); // 再把map放入list
		}
		Comparator<Map> comparator = new Comparator<Map>() {
			public int compare(Map m1, Map m2) {
				return -((BigDecimal) m1.get("Price"))
						.compareTo((BigDecimal) m2.get("Price")); // 擷取Price欄位轉成BigDecimal做comparator
			}
		};
		Collections.sort(lst, comparator); // 做sort

		String str = "";
		str = rd + "\n";	// 回傳header

		for (int i = 0; i < lst.size(); i++) {
			for (int j = 0; j < keys.length; j++) {
				str += lst.get(i).get(keys[j]) + ",";
				//System.out.println(str);
			}
			str += "\n";
		}

		// 輸出儲存檔案
		File save = new File("D:\\新進人員作業\\作業五 - 檔案與數字分析\\cars2.csv");
		OutputStream out = new FileOutputStream(save);
		OutputStreamWriter osr = new OutputStreamWriter(out, "UTF-8"); // 設定輸出資料的編碼方式
		BufferedWriter bw = new BufferedWriter(osr); // 建立緩衝區
		osr.write(str); // 編碼後內容寫入檔案
		osr.close();

		return lst;	// return回傳lst到最外層的public
	}
}
