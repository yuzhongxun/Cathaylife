package com.cathay.hw3;

public class hw_third_1 {

	/**
	 * 請分別以(1) String (2) StringBuilder兩種方法產生一字串”a”，並分別串接另一字串”0” (1) 一萬次 (2) 五萬次
	 * (3)十萬次，最後輸出花費的時間以及記憶體使用量。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int TimeOne = 10000, TimeTwo = 50000, TimeThree = 100000;
		// build call function
		doExecute(TimeOne);
		doExecute(TimeTwo);
		doExecute(TimeThree);
	}

	private static void doExecute(int times) {
		// String
		String Strword = "a";
		long starttime = System.currentTimeMillis(); // 執行前的時間
		Runtime rt = Runtime.getRuntime();
		rt.gc(); // get clear memory
		long usedMem = rt.totalMemory() - rt.freeMemory(); // occupy memory capacity
		for (int i = 0; i < times; i++) {
			Strword = Strword + "0";
		}
		long useEndMem = rt.totalMemory() - rt.freeMemory();
		long endtime = System.currentTimeMillis(); // 執行後的時間
		System.out.println("String 做 " + times + " 次的花費時間: " + (endtime - starttime) + " ms");
		System.out.println("String 做 " + times + " 次的記憶體使用量: " + (useEndMem - usedMem) + " byte");
		System.out.println("---------------------------------------------------------");

		// StringBuilder
		StringBuilder SBword = new StringBuilder("a");
		starttime = System.currentTimeMillis(); // 執行前的時間
		rt = Runtime.getRuntime();
		rt.gc(); // get clear memory
		usedMem = rt.totalMemory() - rt.freeMemory();
		for (int j = 0; j < times; j++) {
			SBword = SBword.append("0"); // now original string is changed
		}
		useEndMem = rt.totalMemory() - rt.freeMemory();
		endtime = System.currentTimeMillis(); // 執行後的時間
		System.out.println("StringBuilder 做 " + times + " 次的花費時間: " + (endtime - starttime) + " ms");
		System.out.println("StringBuilder 做 " + times + " 次的記憶體使用量: " + (useEndMem - usedMem) + " byte");
		System.out.println("---------------------------------------------------------");
	}
}
