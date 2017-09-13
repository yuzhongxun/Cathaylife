package com.cathay.hw5;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class hw_fifth_2 {

	/**
	 * b. �w��Manufacturer�o�����N��Ƥ��աA�íp��Min.Price ,Price�o�����쪺�p�p�B�X�p�ÿ�X�b�ù��W�C
	 * ���Ҧ����Ʀr������s��BigDecimal�ӹB��
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<Map> carsList;
		try {
			carsList = new hw_fifth_1().carsPrice(); // �I�shw_fifth_1��carsprice
			// ���~�|��������U��return�^�Ǩ�main, ���|����return�U�誺code
		} catch (IOException e) {
			e.printStackTrace();
			return; // return�^�hmain
		}
		// System.err.println("carsList:"+carsList); // �T�{carsList

		// �^��Manufacturer��찵sort�Ƨ�
		Comparator<Map> comparator = new Comparator<Map>() {
			public int compare(Map m1, Map m2) {
				return ((String) m1.get("Manufacturer")).compareTo((String) m2.get("Manufacturer"));
			}
		};
		Collections.sort(carsList, comparator); // ��sort

		String isSame = "";
		String Manu = (String) carsList.get(0).get("Manufacturer"); // �W�@��data
		BigDecimal tcntmp = BigDecimal.ZERO; // �]�w�X�p��l new BigDecimal("0");
		BigDecimal tcntpr = BigDecimal.ZERO;
		BigDecimal scntmp = BigDecimal.ZERO;	// �]�w�p�p��l
		BigDecimal scntpr = BigDecimal.ZERO;
		
		System.out.println("Manufacturer\t"+ "Type\t" + "Min.Price\t" + "Price");

		for (int i = 0; i < carsList.size(); i++) {
			Map tmp = carsList.get(i);	// �������list�Ǧ^map
			BigDecimal bdmp = (BigDecimal) tmp.get("Min.Price"); // map��key�^����bdmin
			BigDecimal bdpr	= (BigDecimal) tmp.get("Price"); // map��key�^����bdpr
			tcntmp = bdmp.add(tcntmp);	// bdmp���[�`
			tcntpr = bdpr.add(tcntpr);	// bdpr���[�`
			String cur = (String) tmp.get("Manufacturer"); // �{�b�o��data
			
			
			System.out.println(tmp.get("Manufacturer") +"\n" + tmp.get("Type") + "\n" + tmp.get("Min.Price") + "\n" + tmp.get("Price")+ "\n" );
			
			if (cur.equals(Manu)) {  // Manufac�M�W�@�Ӥ���Y�O�ۦP�N����[�`
				scntmp = bdmp.add(scntmp);
				scntpr = bdpr.add(scntpr);
			} else { // data�k�s
				System.out.print("�p�p��: " + scntmp + " " + scntpr + "\n"); // �L�X�p�p

				scntmp = BigDecimal.ZERO;	// data�k�s��^��
				scntpr = BigDecimal.ZERO;
				scntmp = scntmp.add(bdmp);
				scntpr = scntpr.add(bdpr);
				Manu = cur;	// �{�b��Ʀ^�k�W�@���A������
			}
		}
				System.out.print("�p�p��: " + " " + scntmp + " " + scntpr + "\n");
				System.out.print("�X�p��: " + tcntmp + " " + tcntpr + "\n");
	}
}
