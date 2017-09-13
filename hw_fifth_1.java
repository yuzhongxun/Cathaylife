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
	 * 1. �ФU��cars.csv�o���ɮ� (csv�ɬ��r�����j���ɮ�) �N�ɮצbJava��Ū���A�ð��H�U��X�G
	 * 
	 * a. �@�������s���@��Map�A�ñN�Ҧ���Ʃ�JList���� �Q��Collections���O��sort��k�A�w��Price�o�����i��
	 * ��ƱƧǫ��X���t�@���ɮ�, ex: cars2.csv �C
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new hw_fifth_1().carsPrice();	// new Obj�I�s�U�誺function
		} catch (IOException e) {
			e.printStackTrace();	// �^�����~�T��
		}
	}

	// �إ�public�W��carsPrice��List
	public List carsPrice() throws IOException {
		// Ū��csv
		BufferedReader reader = new BufferedReader(new FileReader(
				"D:\\�s�i�H���@�~\\�@�~�� - �ɮ׻P�Ʀr���R\\cars.csv"));
		String rd = reader.readLine(); // ���L�Ĥ@�C���DŪ��
		String[] keys = rd.split(","); // key��split
		String line = null;
		List<Map> lst = new ArrayList<Map>(); // �إ�list
		while ((line = reader.readLine()) != null) { // Ū���D�ŭȪ��ɭ�
			String[] item = line.split(","); // item��split
			String value = item[item.length - 1]; // data��item���e,�O�dheader
			Map mapdb = new HashMap(); // �إ�map,�Ȥ��n�]�w�x��

			// readline Ū�����imap, �إ�key�Mvalue��
			for (int i = 0; i < keys.length; i++) {
				String key = keys[i];
				value = item[i];
				if ("Price".equals(key) || "Min.Price".equals(key)) { // �o������নBigDecimal
					mapdb.put(key, new BigDecimal(value)); // key�ȩ�Jmap
				} else {
					mapdb.put(key, value);
				}
			}
			lst.add(mapdb); // �A��map��Jlist
		}
		Comparator<Map> comparator = new Comparator<Map>() {
			public int compare(Map m1, Map m2) {
				return -((BigDecimal) m1.get("Price"))
						.compareTo((BigDecimal) m2.get("Price")); // �^��Price����নBigDecimal��comparator
			}
		};
		Collections.sort(lst, comparator); // ��sort

		String str = "";
		str = rd + "\n";	// �^��header

		for (int i = 0; i < lst.size(); i++) {
			for (int j = 0; j < keys.length; j++) {
				str += lst.get(i).get(keys[j]) + ",";
				//System.out.println(str);
			}
			str += "\n";
		}

		// ��X�x�s�ɮ�
		File save = new File("D:\\�s�i�H���@�~\\�@�~�� - �ɮ׻P�Ʀr���R\\cars2.csv");
		OutputStream out = new FileOutputStream(save);
		OutputStreamWriter osr = new OutputStreamWriter(out, "UTF-8"); // �]�w��X��ƪ��s�X�覡
		BufferedWriter bw = new BufferedWriter(osr); // �إ߽w�İ�
		osr.write(str); // �s�X�᤺�e�g�J�ɮ�
		osr.close();

		return lst;	// return�^��lst��̥~�h��public
	}
}
