package Data;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;

public class Data {
	private static final ThreadLocal<Data> T = new ThreadLocal<Data>();
	
	public static Data get() {
		return T.get();		
	}
		public static void set(Data data) {
			
			T.set(data);
		}
	public static class common{
		
		public static WebDriver driver;
		public static HashMap<String, String> envConfigData;
		public static Document objectRepository;
	}
		
	

}
