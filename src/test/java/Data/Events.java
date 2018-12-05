package Data;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import Data.EnumVariable.Browser;

public class Events {
	
	private static final ThreadLocal<Events> T = new ThreadLocal<Events>();
	
	public static Events get() {
		return T.get();		
	}
	public static void set(Events events) {
		T.set(events);
	}	
	
	
   public static void launchApp(Browser browser) {
	   
	   switch (browser) {
	case CHROME:
		 System.setProperty("Webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		 ChromeOptions cOptions = new ChromeOptions();
		 cOptions.addArguments("--ignore-certificate-errors", "--disable-extensions", "--dns-prefetch-disable", "lang=en_US.UTF-8","--disable-infobars","--new-window","--start-maximized");
		 cOptions.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION	, true);
		 HashMap<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			cOptions.setExperimentalOption("prefs", prefs);
			
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 Driver.set(new ChromeDriver(cOptions));	
		 break;
	case FIREFOX:
		System.setProperty("Webdriver.gecko.driver", "Drivers\\geckodriver.exe");
		FirefoxOptions fOptions = new FirefoxOptions();
		fOptions.addArguments("--ignore-certificate-error","--disable-extensions","--dns-prefetch-disable","lang=en_US.UFT-8","--disable-infobars","--new-window");
		fOptions.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		
		HashMap<String, Object> preff = new HashMap<String, Object>();
		preff.put("credentials_enable_service", false);
		preff.put("profile.password_manager_enabled", false);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Driver.set(new FirefoxDriver(fOptions));
		break;
	default:
		break;
	}
   }
   
   public static void urlToTest(String url) {
	   
	    
   }

}
