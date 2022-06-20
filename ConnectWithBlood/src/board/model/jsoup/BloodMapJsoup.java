package board.model.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class BloodMapJsoup {

	public String seoul() {
		
		String URL = "https://www.bloodinfo.net/bloodstats_statistics.do";
		String seoul = null;
		Document doc = null;
		Elements tmp;

		try {
			doc = Jsoup.connect(URL).get();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		Elements elem = doc.select("#area_blood_stock_numbers > div > table > tbody > tr:nth-child(1) > td:nth-child(6)");
//		#area_blood_stock_numbers > div > table > tbody > tr:nth-child(1)
		//System.out.println(elem);
		
		seoul = elem.text();
	
		
		
		
		return seoul;
	}
	
	
	
	
	
}
