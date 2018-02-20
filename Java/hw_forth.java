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
	 * 附檔 encode_file.txt 中有兩行以 UTF-8
	 * 編碼的字串，請寫一支程式讀取檔案內容，為字串進行解碼，並將字串依原本的格式寫入另一檔案 (decode_file.txt)。
	 * 
	 * @param args
	 */

	public static void main(String[] args) throws IOException {

		File start = new File("D:\\新進人員作業\\作業四 - 檔案與編碼\\encode_text.txt"); // 開啟檔案
		InputStream is = new FileInputStream(start); // 建立位元串流
		InputStreamReader isr = new InputStreamReader(is, "UTF-8"); // 設定輸入資料的編碼方式
		BufferedReader br = new BufferedReader(isr); // 建立緩衝區
		String br2, text = "";
		// System.out.println(br.readLine()); // ReadLine只會讀一行, 若印此行則下次執行從下一行開始動作

		while ((br2 = br.readLine()) != null) { // 檔案內下一行回傳到String若非空值就執行動作
			text += java.net.URLDecoder.decode(br2, "UTF-8"); // 印出下一行並解碼
		}
		System.out.println(text);
		is.close();

		File end = new File("D:\\新進人員作業\\作業四 - 檔案與編碼\\decode_file.txt");
		OutputStream out = new FileOutputStream(end);
		OutputStreamWriter osr = new OutputStreamWriter(out, "UTF-8"); // 設定輸出資料的編碼方式
		BufferedWriter bw = new BufferedWriter(osr); // 建立緩衝區
		osr.write(text); // 編碼後內容寫入檔案
		osr.close();
	}
}
