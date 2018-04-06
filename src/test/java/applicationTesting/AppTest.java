package applicationTesting;

import org.testng.annotations.Test;

import DriverFactory.DriverScript;

public class AppTest {
	
	@Test
	public void kickStart() throws Throwable {
		
			DriverScript ds = new DriverScript();
			ds.startTest();
		
	}

}
