package dgbas;

import java.io.IOException;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class NationalIncome {

	public static void main(String[] args) throws IOException {
		
		try {
			// 資料項目：國民所得統計常用資料-年
			String url = "http://statdb.dgbas.gov.tw/PXweb/XMLFile/NationalIncome/NA8101A1A.xml";
			Document xml = Jsoup.connect(url).get();
			
			// connect to wait 1,000 million second after run
			Thread.sleep(1000);

			// output data change to JSON Object format
			JSONObject jsonXml = org.json.XML.toJSONObject(xml.getElementsByTag("Series").toString());
			System.out.println(jsonXml.toString(4));
			
		}	catch (InterruptedException e) {
            e.printStackTrace(); 
        }
	}
}
