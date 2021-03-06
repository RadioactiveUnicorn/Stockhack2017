package StockHack;


import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Scraper {


	public Scraper() {

		Document doc = null;

		try {
			doc = Jsoup.connect("https://www.wunderground.com/weather/us/nj/princeton/08540").get();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		try {
			doc = Jsoup.connect("https://www.wunderground.com/weather/us/nj/princeton/08540").get();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		Elements table = doc.getElementsByClass("wu-value wu-value-to");
		Elements rainPerc = doc.getElementsByClass("hook");
		
		//System.out.println(table);
		
		List<String> temp = new ArrayList<>();
		for(Element e : table){
			
			temp.add(e.text());
			
		}
		
		for(Element e : rainPerc){
			
			temp.add(e.text());
			
		}
		
		double avgTemp = Double.parseDouble(temp.get(1));
		String percent = temp.get(8);
		
		int index = percent.indexOf("%");
		
		double percentDouble = Double.parseDouble(percent.substring(0, index));
		
		System.out.println(temp);
		
		System.out.println("Average Temp = " + avgTemp + ", % Rainfall = " + percentDouble);
		
	}
	
	public static void main (String args[]) {

		new Scraper();
	
	}
	
}
