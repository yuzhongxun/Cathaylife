package com.cathay.hw2;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class hw_second_1 {

	/**
	 * ����3�ɻ�l���Y100��(�H��)�A�òέp�I���`�M�X�{������, �N���G�H*�L�X. �Ч�HMap������Ӽ��g�C(���Ƭ�0�����ΦL�X)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int count = 100; // �`�@���Y 100 ��
		int sum = 0;

		Map<Integer, Integer> mapbox = new TreeMap<Integer, Integer>(); // <>�x��; key and value type
		for (int i = 0; i < count; i++) { // repeat 100 times
			int RadomNum = (int) (Math.random() * 16 + 3); // index 0~16, �ƭȽd��+3 �ܦ�, 3~18���I�Ƽƭ�
			if (mapbox.containsKey(RadomNum)) { // contains �P�_ RandomNumber�O�_���X�{�L
				int times = mapbox.get(RadomNum); // get ���� key ���X�^�� times �ܼ�
				times = times + 1; // �s�J value �� times ���֥[
				mapbox.put(RadomNum, times); // ��J put in Mapbox
			} else {
				mapbox.put(RadomNum, 1); // �S���X�{�L�N������J mapbox ���Ƭ� 1
			}
		}

		for (int j = 0; j < mapbox.size(); j++) { // for�O�] j = key ��
			System.err.print((j + 3) + " : "); // (j+3) ���첾, �I�ƽd��3~18
			for (int k = 0; k < mapbox.get(j + 3); k++) { // for �Ovalue�ȦL '*', key�ܤַ|�O3���I�ƥH�W(j+3)
				System.err.print("*");
			}
			System.err.println();

			/*
			 * method 1: �إ� entry.Set() ���覡�Ө��X map Integer key = (Integer)
			 * entry.getKey(); Integer Value = (Integer) entry.getValue();
			 * System.out.print("(point: %s, times: %s)%n", entry.getKey(),
			 * entry.getValue());
			 */

			/*
			 * method 2: �ϥ� KeySet ��²��ֳt���إߤ覡���Xmap Set<Integer> mapboxKeySet =
			 * mapbox.keySet(); for (Integer mapboxKey : mapboxKeySet) { Integer
			 * times = mapbox.get(mapboxKey);}
			 */

		}
	}
}
