package Data;

public class EnumVariable {
	
	public enum Browser{
		
		CHROME,FIREFOX,IEEXPLORER;
	}
     public enum environment{
    	 QA,DEV;
    	 public String toString(){
    	        switch (this) {
    	            case QA: return "Qa";
    	            case DEV: return "Dev";
    	            
    	        }
    	        return null;
    	    }
     }
     
     public enum locator{
    	 
    	 XPATH,ID,CLASSNAME,PARTIALLINKTEXT,LINKTEXT,CSS,TAGNAME,NAME;    	 
     }

	public static final String locator = null;
}
