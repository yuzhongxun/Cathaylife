package com.cathay.hw3;

public class hw_third_1 {

	/**
	 * �Ф��O�H(1) String (2) StringBuilder��ؤ�k���ͤ@�r�ꡨa���A�ä��O�걵�t�@�r�ꡨ0�� (1) �@�U�� (2) ���U��
	 * (3)�Q�U���A�̫��X��O���ɶ��H�ΰO����ϥζq�C
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
		long starttime = System.currentTimeMillis(); // ����e���ɶ�
		Runtime rt = Runtime.getRuntime();
		rt.gc(); // get clear memory
		long usedMem = rt.totalMemory() - rt.freeMemory(); // occupy memory capacity
		for (int i = 0; i < times; i++) {
			Strword = Strword + "0";
		}
		long useEndMem = rt.totalMemory() - rt.freeMemory();
		long endtime = System.currentTimeMillis(); // ����᪺�ɶ�
		System.out.println("String �� " + times + " ������O�ɶ�: " + (endtime - starttime) + " ms");
		System.out.println("String �� " + times + " �����O����ϥζq: " + (useEndMem - usedMem) + " byte");
		System.out.println("---------------------------------------------------------");

		// StringBuilder
		StringBuilder SBword = new StringBuilder("a");
		starttime = System.currentTimeMillis(); // ����e���ɶ�
		rt = Runtime.getRuntime();
		rt.gc(); // get clear memory
		usedMem = rt.totalMemory() - rt.freeMemory();
		for (int j = 0; j < times; j++) {
			SBword = SBword.append("0"); // now original string is changed
		}
		useEndMem = rt.totalMemory() - rt.freeMemory();
		endtime = System.currentTimeMillis(); // ����᪺�ɶ�
		System.out.println("StringBuilder �� " + times + " ������O�ɶ�: " + (endtime - starttime) + " ms");
		System.out.println("StringBuilder �� " + times + " �����O����ϥζq: " + (useEndMem - usedMem) + " byte");
		System.out.println("---------------------------------------------------------");
	}
}
