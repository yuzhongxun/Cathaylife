package com.cathay.hw4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class hw_forth {

	private static final int UTF = 0;

	/**
	 * ���� encode_file.txt �������H UTF-8
	 * �s�X���r��A�мg�@��{��Ū���ɮפ��e�A���r��i��ѽX�A�ñN�r��̭쥻���榡�g�J�t�@�ɮ� (decode_file.txt)�C
	 * 
	 * @param args
	 */

	public static void main(String[] args) throws IOException {

		File start = new File("D:\\�s�i�H���@�~\\�@�~�| - �ɮ׻P�s�X\\encode_text.txt"); // �}���ɮ�
		InputStream is = new FileInputStream(start); // �إߦ줸��y
		InputStreamReader isr = new InputStreamReader(is, "UTF-8"); // �]�w��J��ƪ��s�X�覡
		BufferedReader br = new BufferedReader(isr); // �إ߽w�İ�
		String br2, text = "";
		// System.out.println(br.readLine()); // ReadLine�u�|Ū�@��, �Y�L����h�U������q�U�@��}�l�ʧ@

		while ((br2 = br.readLine()) != null) { // �ɮפ��U�@��^�Ǩ�String�Y�D�ŭȴN����ʧ@
			text += java.net.URLDecoder.decode(br2, "UTF-8"); // �L�X�U�@��øѽX
		}
		System.out.println(text);
		is.close();

		File end = new File("D:\\�s�i�H���@�~\\�@�~�| - �ɮ׻P�s�X\\decode_file.txt");
		OutputStream out = new FileOutputStream(end);
		OutputStreamWriter osr = new OutputStreamWriter(out, "UTF-8"); // �]�w��X��ƪ��s�X�覡
		BufferedWriter bw = new BufferedWriter(osr); // �إ߽w�İ�
		osr.write(text); // �s�X�᤺�e�g�J�ɮ�
		osr.close();
	}
}
