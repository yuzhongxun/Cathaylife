package com.cathay.hw2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class hw_second_2 {

	/**
	 * �H������15�Ӥ���1-10������BigDecimal(���୫��), �N����ܤp�ƲĤT��(�|�ˤ��J)�ȩ̀Ǧs�JCollection������,
	 * �öi��U�C�p��: (1). �L�X��Ƨǫᤧ�ƦC (2). �p��15�ӼƦr��������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
			ArrayList <BigDecimal> ArrNum = new ArrayList<BigDecimal>();
				BigDecimal sum = new BigDecimal(0);
			
				for (int j = 0; j < 15; j++) { 
				 double num = (double) (Math.random() * 9 + 1);
				 BigDecimal BDnum = new BigDecimal(num);
				 ArrNum.add(BDnum.setScale(3, BigDecimal.ROUND_HALF_UP)); // �N BDnum ����3��ƪ� set ��J Arraylist 
				 
				boolean isSame = true;
				while (isSame) {
					 	num = (double) (Math.random() * 9 + 1);
					 	BDnum = new BigDecimal(num);
						for (int k = 0; k < j - 1; k++) {
							BigDecimal tempNum = ArrNum.get(k); // ��@�檺�ƭȨ��X���J tempNum
							if (BDnum == tempNum) { // �P�_�O�_������,�Y�����дN���L
								continue;
								// random
							}
						}
						isSame = false;
						ArrNum.set(j, BDnum.setScale(3, BigDecimal.ROUND_HALF_UP)); // �S�����ƴN��J ArrayList, �C�ӭȳ��e�@�� index
						sum = sum.add(BDnum); // sum ���[�`�^�ǩ�Jsum
					}			 						 
		}
						Collections.sort(ArrNum);  // �� sort�Ƨ�
						BigDecimal total = new BigDecimal(15);
						BigDecimal avg = sum.divide(total, 3, RoundingMode.HALF_UP);
						System.err.println("�Ƨǫ�: " + ArrNum);
						System.err.printf("������: " + avg);
	}
}
