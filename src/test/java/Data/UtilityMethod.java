package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

//import javax.lang.model.element.Element;
import javax.print.attribute.standard.RequestingUserName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import Data.EnumVariable.locator;
import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

public class UtilityMethod {

	private static final ThreadLocal<UtilityMethod> T = new ThreadLocal<UtilityMethod>();
	
	public static UtilityMethod get() {
		return T.get();
	}
	public static void set(UtilityMethod utilitymethod) {
		T.set(utilitymethod);
	}
	
	public static HashMap<String, String> readProperty(String propertyFile){
		HashMap<String, String> propertyData = new HashMap<String, String>();
		
		try {
			FileInputStream fio = new FileInputStream(propertyFile);
			Properties prop = new Properties();
			prop.load(fio);
			prop.getProperty(propertyFile);
			Set<Object> allkeys = prop.keySet();
			for(Object key:allkeys) {
			  String propval = prop.getProperty(key.toString());
			}
			fio.close();
			
		} catch ( IOException e) {			
			e.printStackTrace();
		}		
		return propertyData;
		
	}
	
	
	public static void loadRepositroy(String repFilePath) {
		
		File repFile = new File(repFilePath);
		if(repFile.exists()) {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = null;
			try {
				dBuilder = dbFactory.newDocumentBuilder();
				Data.common.objectRepository = dBuilder.parse(repFile);
			} catch(ParserConfigurationException | SAXException | IOException e) {
				
				e.printStackTrace();
			} 
		}else {
			System.out.println("ERROR : Object repository file  : " + repFilePath + " is not found.");
			System.exit(0);
		}
	}
	
	public  static String[] getObjectIdentification(String ObjectName) {
		String[] procol = new String[2];
		 NodeList proval = Data.common.objectRepository.getElementsByTagName(ObjectName);
		
		 if(proval.getLength() == 0) {
			 System.out.println("ERROR : The properties are not defined for object : "+ ObjectName + " in Object Repository file");
				System.exit(0);
		 }else if(proval.getLength() > 1) {
			 System.out.println("WARNING : there are multiple objects listed in Repostiroy file with same name : " + ObjectName + " Please keep the object name (Element Name) as unque name." );
				System.exit(0);
		 }else {
			 Element toElem = (Element) proval.item(0);
			 if(toElem.hasAttribute("locator")) {
				 procol[0]= toElem.getAttribute("locator");
			 }else {					
					System.out.println("ERROR : the TO Element :" + ObjectName + " does not have locator attribute in Object Repository File");
					System.exit(0);
				}
			 if(toElem.hasAttribute("value")) {
				procol[1]= toElem.getAttribute("value");
			 }else {
				 System.out.println("ERROR: the Element :" + ObjectName + " does not have value for given locator in Object Repository File");
			    System.exit(0);
			 }
		 }
		return procol;
	}
public static By getByFromRepository(locator obj ) {
		By by =null;
		
		String[] propertycol = getObjectIdentification(obj);
		
//		final String name = objectName;
		switch (propertycol[0].toLowerCase()) {
		case :
			
			
			break;
		case  :
			
			
			break;

		default:
			break;
		}
		
		return by;
	}
	
}
