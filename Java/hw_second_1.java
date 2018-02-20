package com.cathay.hw2;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class hw_second_1 {

	/**
	 * 模擬3粒骰子投擲100次(隨機)，並統計點數總和出現的次數, 將結果以*印出. 請改以Map類物件來撰寫。(次數為0的不用印出)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int count = 100; // 總共投擲 100 次
		int sum = 0;

		Map<Integer, Integer> mapbox = new TreeMap<Integer, Integer>(); // <>泛型; key and value type
		for (int i = 0; i < count; i++) { // repeat 100 times
			int RadomNum = (int) (Math.random() * 16 + 3); // index 0~16, 數值範圍為+3 變成, 3~18的點數數值
			if (mapbox.containsKey(RadomNum)) { // contains 判斷 RandomNumber是否有出現過
				int times = mapbox.get(RadomNum); // get 拿到 key 取出回傳 times 變數
				times = times + 1; // 存入 value 做 times 的累加
				mapbox.put(RadomNum, times); // 放入 put in Mapbox
			} else {
				mapbox.put(RadomNum, 1); // 沒有出現過就直接放入 mapbox 次數為 1
			}
		}

		for (int j = 0; j < mapbox.size(); j++) { // for是跑 j = key 值
			System.err.print((j + 3) + " : "); // (j+3) 做位移, 點數範圍3~18
			for (int k = 0; k < mapbox.get(j + 3); k++) { // for 是value值印 '*', key至少會是3個點數以上(j+3)
				System.err.print("*");
			}
			System.err.println();

			/*
			 * method 1: 建立 entry.Set() 的方式來走訪 map Integer key = (Integer)
			 * entry.getKey(); Integer Value = (Integer) entry.getValue();
			 * System.out.print("(point: %s, times: %s)%n", entry.getKey(),
			 * entry.getValue());
			 */

			/*
			 * method 2: 使用 KeySet 更簡單快速的建立方式走訪map Set<Integer> mapboxKeySet =
			 * mapbox.keySet(); for (Integer mapboxKey : mapboxKeySet) { Integer
			 * times = mapbox.get(mapboxKey);}
			 */

		}
	}
}
