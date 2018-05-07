package Maven.maven;


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
//import org.jsoup.select.Elements;
 
/**
 * Created by Steve on 2018/5/2
 */
public class HtmlParser {
	
    public static void main(String[] argv) throws IOException {
    	
//    		===== Demo code =====
			String url = "http://statdb.dgbas.gov.tw/PXweb/XMLFile/NationalIncome/NA8101A1A.xml";
			Document xml = Jsoup.connect(url).get();
			Document doc = Jsoup.parse(xml.toString(), "", Parser.xmlParser());
			Element question = doc.getElementById("NA8101A1A");	// can't cache by some id
//			String question = doc.select(".GenericData").text();		// can't cache
			System.out.println(question);
			
//			xml.getElementsByTag("Series").forEach(e->{
//			e.tag();
////			System.out.println(e.tag());
//			e.attributes();
////			System.out.println(e.attributes());
//			    
//			Elements e2 = e.getElementsByTag("SeriesProperty");
//			e2.forEach(e3->{
//				e3.attributes();
////				System.out.println(e3.attributes());
//				
//				Elements e4 = e.getElementsByTag("Obs");
//				e4.forEach(e5->{
//					e5.attributes();
////					System.out.println(e5.attributes());
//				});
//			});
//		});
			
    }
}

