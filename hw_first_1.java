package com.cathay.hw1;

public class hw_first_1 {

	/** 
	 * ����1�ɻ�l���Y20��(�H��)�A�òέp�I���`�M�X�{������, �N���G�H�Ʀr�L�X
	 * @param args
	 */
	public static void main(String[] args) {

		int[] totalArr = new int[6]; // ��l�I��6�I, ���ͷs����A�إ�array

		for (int i = 1; i <= 20; i++) {
			int number = (int) (Math.random() * 6 + 1); // ���� 0~5 ���Ʀr, +1 �O ���ܽd�� 1~6
			totalArr[number - 1] = totalArr[number - 1] + 1; // �첾-1 �q index �q1�}�l, +1���֥[����
		}

		for (int i = 0; i < totalArr.length; i++) {
			int j = totalArr[i];
			System.out.println((i + 1) + " : " + j + " times");  // i + 1 ���첾���ƨ̶��ǦL�X array ����
		}

		System.out.println("finished");

		/*
		 * double k = Math.random() * 6 + 1; // �H�������ܼ�(double ���p���I�h����) * ��l�I��6�I
		 * + 1(�i��) int intK = (int) k; totalArr[intK - 1] = totalArr[intK - 1] + 1; // index ��1��@�֥[
		 * System.err.println("k:" + k); System.out.println("intk:" + intK);
		 */
	}
}
