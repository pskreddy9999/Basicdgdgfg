package Data;

import org.bridj.Pointer.StringType;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Data.EnumVariable.environment;
import bsh.This;

public class Configarations {
	
	public static final ThreadLocal<Configarations> T = new ThreadLocal<>();
	
	public static Configarations get() {
		
		return T.get();		
	}
	public static void AJ() {
		
	}
	public static void set(Configarations configarations) {
		T.set(configarations);
	}
		
	@Parameters("environment")
	@BeforeSuite
	public void beforeSuit(@Optional String environment){
		
//		 this.getEvnDetail(environment );
	}
	public static  void getEvnDetail(environment environConfig) {
		
		environConfig = (environConfig==null)? environment.QA:environConfig;
		System.out.println(environConfig);
		
		System.out.println(environConfig);
		switch (environConfig) {
		case QA:
			Data.common.envConfigData = UtilityMethod.readProperty("PropertiesFile\\Config_QA.properties");
			break;
		case DEV:
			Data.common.envConfigData = UtilityMethod.readProperty("PropertiesFile\\Config_Dev.properties");
			break;
		default:
			Assert.fail("The environment : " +environConfig +"is invalid. Environment must be choose the QA or DEV only");
			break;
		}
		Data.common.envConfigData = UtilityMethod.readProperty("PropertiesFile\\execution_config.properties");
	}

}
