package com.cathay.hw1;

public class hw_first_2 {

	/**
	 * �H������15�Ӥ���1-10�������B�I��(���୫��), �N����ܤp�ƲĤT��ȩ̀Ǧs�J�}�C, �íp��15�ӼƦr���`�X�P������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * System.err.println(Integer.MAX_VALUE); // ��ƪ������̤j��
		 * System.err.println(Integer.MIN_VALUE); // ��ƪ������̤p�� 
		 * int x = 1; float y = 0.2f;
		 * float z = x - y; System.err.println(z); 
		 * boolean isE = (z == * 0.8);
		 * System.err.println(isE); boolean isDE = (z - 0.8) < 0.0001;
		 * System.err.println(isDE);
		 */

		int count = 15;
		float[] totalArr = new float[count]; // �إ�array

		float sum = 0; // �ŧi sum
		System.err.printf("�}�C: ");

		for (int i = 0; i < count; i++) {

			/*
			 * ���~�a�� // float number = (float) (Math.random() * 10); // �إ�random
			 * 15�ӭȥBindex�첾+1 // float new_number = (float) (number); // index���k�첾
			 */

			boolean isSame = true;
			while (isSame) {
				float number = (float) (Math.random() * 10);
				// System.err.println("number:"+number); // print�X�B�I�ƤC���
				int numberI = (int) (number * 1000); // �p���I�����i3��

				/*
				 * ���կB�I�ƺ�i System.err.println("numberI:"+numberI);
				 * number = numberI/1000; // �㰣�h�p��
				 * System.err.println("D 1000 number:"+number);
				 */

				number = numberI / 1000f; // ��ư��H���B�I�ƪ���Ʒ|����ƭ�
				// System.err.println("D 1000f number:"+number);
				System.err.printf("%.3f ", number);

				for (int j = 0; j < i - 1; j++) {
					float tempNumber = totalArr[j];
					if (number == tempNumber) { // �P�_ array�̭����ȬO�_������,�Y�����дN���L
						continue;
						// random
					}
				}
				isSame = false;
				// System.err.printf("%.3f ", number);
				totalArr[i] = number; // �S�����ƴN��Jarray, �C�ӭȳ��e�@�� index
				sum += number; // sum = sum + number;
			}

			/*
			 * ���~���a�� if (i != number) { // ���୫�ХX�{
			 * totalArr[(int) (number - 1)]++; //���k�첾 } else { continue; }
			 * // totalArr[(int) (number - 1)] = totalArr[(int) (number - 1)] + 1;
			 * // sum += totalArr[(int) (number -1)];
			 */
		}

		float avg = (sum / count);
		System.out.printf("%n");
		System.out.printf("�`�X: %.3f%n", sum);
		System.out.printf("������: %.3f%n", avg);

	}

}
