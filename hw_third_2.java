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

		Calendar cal =  Calendar.getInstance(); // �^�� current time
		cal.set(cal.get(Calendar.YEAR), m - 1, 1);
				
		System.out.println("\n    " + cal.get(Calendar.YEAR) + " �~ " + m + " ��");
		System.out.println("====================");
		System.out.println("��   �@   �G   �T   �|   ��   ��");
		System.out.println("--------------------");	
		
		//System.err.println(cal.get(Calendar.DAY_OF_WEEK)); // ���X�M�s�J�����P���X���ƭ�
		//System.err.println(Calendar.DAY_OF_WEEK); // �ȬO�@�ӭ�
		int totalCnt = 0;
		int calwk = cal.get(Calendar.DAY_OF_WEEK);
		int calmth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		for(int i=1; i< calwk; i++){
			System.out.print("   ");
			totalCnt++;  // �p��ĴX�Ӧ�Ƥ��ᴫ��
				for (int j = 1; j <= calmth; j++) {  // set date of month
			if (i % 7 == 0) {	// ����
				System.out.print("\n");			
			}
			System.out.print(j + "  ");
			totalCnt++;
		}
	}
	}
}
