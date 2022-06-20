package board.model.jsoup;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;



public class BloodJsoup {
	
		public String[] bloodCellDay() {
			
			String URL = "https://www.bloodinfo.net/bloodstats_stocks.do";
			String bloodCellDay = null;
			Document doc = null;
			Elements tmp;

			try {
				doc = Jsoup.connect(URL).get();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			Elements elem = doc.select(".1");
			
			bloodCellDay = elem.text();
			
			String[] bloodCellDays = bloodCellDay.split(" ");
			
			return bloodCellDays;
		}
		
		public String[] bloodCellTotal() {
			
			String URL = "https://www.bloodinfo.net/bloodstats_stocks.do";
			String bloodCellTotal = null;
			Document doc = null;
			Elements tmp;

			try {
				doc = Jsoup.connect(URL).get();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			Elements elem = doc.select(".2");
			
			bloodCellTotal = elem.text();
			
			String[] bloodCellTotals = bloodCellTotal.split(" ");
			
			return bloodCellTotals;
		}
		
		
			
		public String[] bloodCellStock() {
			
			String URL = "https://www.bloodinfo.net/bloodstats_stocks.do";
			String[] bloodCellStocks = new String[5];
			String bloodCellStock1 = null;
			String bloodCellStock2 = null;
			String bloodCellStock3 = null;
			String bloodCellStock4 = null;
			String bloodCellStock5 = null;
			Document doc = null;
			Elements tmp;

			try {
				doc = Jsoup.connect(URL).get();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			Elements elem1 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(3) > table > tbody > tr:nth-child(3) > td:nth-child(2)");
			Elements elem2 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(3) > table > tbody > tr:nth-child(3) > td:nth-child(3)");
			Elements elem3 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(3) > table > tbody > tr:nth-child(3) > td:nth-child(4)");
			Elements elem4 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(3) > table > tbody > tr:nth-child(3) > td:nth-child(5)");
			Elements elem5 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(3) > table > tbody > tr:nth-child(3) > td:nth-child(6)");
			
			bloodCellStock1 = elem1.text();
			bloodCellStock2 = elem2.text();
			bloodCellStock3 = elem3.text();
			bloodCellStock4 = elem4.text();
			bloodCellStock5 = elem5.text();
		
			bloodCellStocks[0] = bloodCellStock1;
			bloodCellStocks[1] = bloodCellStock2;
			bloodCellStocks[2] = bloodCellStock3;
			bloodCellStocks[3] = bloodCellStock4;
			bloodCellStocks[4] = bloodCellStock5;
			
			
			return bloodCellStocks;
		}

			
			
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		public String[] PlateletDay() { //혈소판 - Platelet
			
			String URL = "https://www.bloodinfo.net/bloodstats_stocks.do";
			String[] PlateletDays = new String[5];
			String PlateletDay1 = null;
			String PlateletDay2 = null;
			String PlateletDay3 = null;
			String PlateletDay4 = null;
			String PlateletDay5 = null;
			Document doc = null;
			Elements tmp;

			try {
				doc = Jsoup.connect(URL).get();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			Elements elem1 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(8) > table > tbody > tr:nth-child(1) > td:nth-child(2)");
			Elements elem2 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(8) > table > tbody > tr:nth-child(1) > td:nth-child(3)");
			Elements elem3 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(8) > table > tbody > tr:nth-child(1) > td:nth-child(4)");
			Elements elem4 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(8) > table > tbody > tr:nth-child(1) > td:nth-child(5)");
			Elements elem5 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(8) > table > tbody > tr:nth-child(1) > td:nth-child(6)");
			
			PlateletDay1 = elem1.text();
			PlateletDay2 = elem2.text();
			PlateletDay3 = elem3.text();
			PlateletDay4 = elem4.text();
			PlateletDay5 = elem5.text();
			
			PlateletDays[0] = PlateletDay1;
			PlateletDays[1] = PlateletDay2;
			PlateletDays[2] = PlateletDay3;
			PlateletDays[3] = PlateletDay4;
			PlateletDays[4] = PlateletDay5;
			
			return PlateletDays;
		}

		public String[] PlateletTotal() { //혈소판 - Platelet
			
			String URL = "https://www.bloodinfo.net/bloodstats_stocks.do";
			String[] PlateletTotals = new String[5];
			String PlateletTotal1 = null;
			String PlateletTotal2 = null;
			String PlateletTotal3 = null;
			String PlateletTotal4 = null;
			String PlateletTotal5 = null;
			Document doc = null;
			Elements tmp;

			try {
				doc = Jsoup.connect(URL).get();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
			
			Elements elem1 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(8) > table > tbody > tr:nth-child(2) > td:nth-child(2)");
			Elements elem2 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(8) > table > tbody > tr:nth-child(2) > td:nth-child(3)");
			Elements elem3 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(8) > table > tbody > tr:nth-child(2) > td:nth-child(4)");
			Elements elem4 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(8) > table > tbody > tr:nth-child(2) > td:nth-child(5)");
			Elements elem5 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(8) > table > tbody > tr:nth-child(2) > td:nth-child(6)");
			
			PlateletTotal1 = elem1.text();
			PlateletTotal2 = elem2.text();
			PlateletTotal3 = elem3.text();
			PlateletTotal4 = elem4.text();
			PlateletTotal5 = elem5.text();
			
			PlateletTotals[0] = PlateletTotal1;
			PlateletTotals[1] = PlateletTotal2;
			PlateletTotals[2] = PlateletTotal3;
			PlateletTotals[3] = PlateletTotal4;
			PlateletTotals[4] = PlateletTotal5;
			
			return PlateletTotals;
		}
		
		
		public String[] PlateletStock() { //혈소판 - Platelet
			
			String URL = "https://www.bloodinfo.net/bloodstats_stocks.do";
			String[] PlateletStocks = new String[5];
			String PlateletStock1 = null;
			String PlateletStock2 = null;
			String PlateletStock3 = null;
			String PlateletStock4 = null;
			String PlateletStock5 = null;

			Document doc = null;
			Elements tmp;

			try {
				doc = Jsoup.connect(URL).get();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			Elements elem1 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(8) > table > tbody > tr:nth-child(3) > td:nth-child(2)");
			Elements elem2 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(8) > table > tbody > tr:nth-child(3) > td:nth-child(3)");
			Elements elem3 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(8) > table > tbody > tr:nth-child(3) > td:nth-child(4)");
			Elements elem4 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(8) > table > tbody > tr:nth-child(3) > td:nth-child(5)");
			Elements elem5 = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(8) > table > tbody > tr:nth-child(3) > td:nth-child(6)");

			
			PlateletStock1 = elem1.text();
			PlateletStock2 = elem2.text();
			PlateletStock3 = elem3.text();
			PlateletStock4 = elem4.text();
			PlateletStock5 = elem5.text();

			PlateletStocks[0] = PlateletStock1;
			PlateletStocks[1] = PlateletStock2;
			PlateletStocks[2] = PlateletStock3;
			PlateletStocks[3] = PlateletStock4;
			PlateletStocks[4] = PlateletStock5;

			
			
			return PlateletStocks;
		}


		public String today() {
			
			String URL = "https://www.bloodinfo.net/bloodstats_stocks.do";
			String today;

			Document doc = null;
			Elements tmp;

			try {
				doc = Jsoup.connect(URL).get();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			Elements elem = doc.select("#contents_box > div.content > div > div.area_content > div > div > div > div:nth-child(2) > p.txt.min.colorC.right.mt10 > strong");

			today = elem.text();
	
			return today;
			
		}

}
	



