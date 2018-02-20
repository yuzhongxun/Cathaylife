package com.cathay.hw1;

public class hw_first_2 {

	/**
	 * 隨機產生15個介於1-10之間的浮點數(不能重覆), 將其取至小數第三位並依序存入陣列, 並計算15個數字之總合與平均數
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * System.err.println(Integer.MAX_VALUE); // 整數的極限最大值
		 * System.err.println(Integer.MIN_VALUE); // 整數的極限最小值 
		 * int x = 1; float y = 0.2f;
		 * float z = x - y; System.err.println(z); 
		 * boolean isE = (z == * 0.8);
		 * System.err.println(isE); boolean isDE = (z - 0.8) < 0.0001;
		 * System.err.println(isDE);
		 */

		int count = 15;
		float[] totalArr = new float[count]; // 建立array

		float sum = 0; // 宣告 sum
		System.err.printf("陣列: ");

		for (int i = 0; i < count; i++) {

			/*
			 * 錯誤地方 // float number = (float) (Math.random() * 10); // 建立random
			 * 15個值且index位移+1 // float new_number = (float) (number); // index往右位移
			 */

			boolean isSame = true;
			while (isSame) {
				float number = (float) (Math.random() * 10);
				// System.err.println("number:"+number); // print出浮點數七位數
				int numberI = (int) (number * 1000); // 小數點往左進3位

				/*
				 * 測試浮點數精進 System.err.println("numberI:"+numberI);
				 * number = numberI/1000; // 整除去小數
				 * System.err.println("D 1000 number:"+number);
				 */

				number = numberI / 1000f; // 整數除以有浮點數的整數會近似數值
				// System.err.println("D 1000f number:"+number);
				System.err.printf("%.3f ", number);

				for (int j = 0; j < i - 1; j++) {
					float tempNumber = totalArr[j];
					if (number == tempNumber) { // 判斷 array裡面的值是否有重覆,若有重覆就跳過
						continue;
						// random
					}
				}
				isSame = false;
				// System.err.printf("%.3f ", number);
				totalArr[i] = number; // 沒有重複就放入array, 每個值都占一個 index
				sum += number; // sum = sum + number;
			}

			/*
			 * 錯誤的地方 if (i != number) { // 不能重覆出現
			 * totalArr[(int) (number - 1)]++; //往右位移 } else { continue; }
			 * // totalArr[(int) (number - 1)] = totalArr[(int) (number - 1)] + 1;
			 * // sum += totalArr[(int) (number -1)];
			 */
		}

		float avg = (sum / count);
		System.out.printf("%n");
		System.out.printf("總合: %.3f%n", sum);
		System.out.printf("平均數: %.3f%n", avg);

	}

}
