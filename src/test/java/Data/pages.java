package Data;

import Data.EnumVariable.Browser;

public class pages {
     
	private static final  ThreadLocal<pages> T = new ThreadLocal<pages>();
	
	public static pages get() {
		return T.get();
	}
	public static void set(pages page) {
		T.set(page);
	}
	
	public static void main(String[] args) {
		
		
		Events.get().launchApp(Browser.CHROME);

	}

}
