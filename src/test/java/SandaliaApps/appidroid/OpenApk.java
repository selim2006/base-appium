package SandaliaApps.appidroid;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import SandaliaApps.appidroid.Config.Configuration;

public class OpenApk extends Configuration{

	@Test
	public void test() throws MalformedURLException, InterruptedException {
		
		initDriver();
		
		Thread.sleep(5000);
		
	}
	
}
