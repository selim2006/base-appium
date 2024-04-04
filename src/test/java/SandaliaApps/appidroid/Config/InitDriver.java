package SandaliaApps.appidroid.Config;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class InitDriver {

	public AndroidDriver driver;
	protected Map<String,String> customOptions = new HashMap<>();
	private UiAutomator2Options options = new UiAutomator2Options();
	//adjust path of local location of the testing app
	private String apkPath = "D://appium//Templates//appidroid//src//test//java//resources//ApiDemos-debug.apk";
	//private String appPackage = "com.google.android.apps.photos";
	private String deviceName = "Pixel 4 API 31 Android 12";
	
	public void initDriver() throws MalformedURLException {
		
		
		if(!customOptions.containsKey("app") && !customOptions.containsKey("appPackage")) {
			
			options.setCapability("app",apkPath);
			
		}else if(!customOptions.containsKey("deviceName")) {
			
			options.setCapability("deviceName",deviceName);
		}
			
		for(Map.Entry<String, String> set: customOptions.entrySet()) {
				
				options.setCapability(set.getKey(),set.getValue());
				
				System.out.println(set.getKey() + " = " + set.getValue());
				
		}
		
	       //Create and start Android Driver
			driver = new AndroidDriver(URI.create("http://127.0.0.1:4723").toURL(),options);
			//global timeout
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	}
	
	
}
