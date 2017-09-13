package com.cathay.hw3;

import java.util.*;

public class hw_third_2 {

	/**
	 * ��J����1-12�������m, �ùB��java �� Date, Calendar�����O�C�L�X���~m�몺���
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("�п�J�@�ӼƦr(���)�G");
		int m = scanner.nextInt();

		Calendar cal = Calendar.getInstance(); // �^�ǲ{�b����M�ɶ�
		cal.set(cal.get(Calendar.YEAR), m - 1, 1);

		System.out.println("\n    " + cal.get(Calendar.YEAR) + " �~ " + m + " ��");
		System.out.println("====================");
		System.out.println("��   �@   �G   �T   �|   ��   ��");
		System.out.println("--------------------");

		int calwk = cal.get(Calendar.DAY_OF_WEEK); // ���o�{�b�O�P���X
		// int calmth = cal.get(Calendar.DAY_OF_MONTH); // ��몺�Ĥ@��
		int mthday = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // ���o���̤j�Ѽ�

		// System.err.println(cal.get(Calendar.DAY_OF_WEEK)); // ���X�M�s�J�����P���X���ƭ�
		// System.err.println(Calendar.DAY_OF_WEEK); // �ȬO�@�ӭ�
		// System.err.println("calwk:" + calwk);
		// System.err.println("calmth:" + mthday);

		for (int i = 1; i < calwk; i++) {
			System.out.print("   "); // ����Ů�L�X��
		}
		for (int i = 1; i <= mthday; i++) { // set date of month
			if (i < 10) { // �Ӧ�ƪ��L�k
				System.out.print(" " + i + " ");
			} else { // �Q�i�쪺�L�k
				System.out.print(" " + i);
			} // �վ�榡
			if (cal.get(Calendar.DAY_OF_WEEK) == 7) { // �C��P�����h����
				System.out.println("");
			}
			cal.add(Calendar.DAY_OF_MONTH, 1); // ����֥[�{�b���Ѽ�
		}
	}
}
