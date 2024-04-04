package SandaliaApps.appidroid;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import SandaliaApps.appidroid.Config.Configuration;

public class Open extends Configuration{

	@Test
	public void test() throws MalformedURLException, InterruptedException {
		
		customOptions.put("appPackage","host.exp.exponent");
		customOptions.put("appActivity","host.exp.exponent.experience.ExperienceActivity");
		
		initDriver();
		
		driver.get("exp://192.168.0.106:8081");

		Thread.sleep(5000);
		
	}
}
