package SandaliaApps.appidroid.Config;

import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Configuration extends InitDriver {

	public AppiumDriverLocalService service;

	
	@BeforeClass // This method will be called automatically before executing any code of the child class
	public void start() throws MalformedURLException{

		//map environment variables
		 Map<String, String> env = new HashMap<>(System.getenv());
	        env.put("ANDROID_HOME", "C://Users//johnk//AppData//Local//Android//Sdk");
	        env.put("JAVA_HOME", "C://Program Files//Java//jdk-21");

		//Initialize appium server

		service = new AppiumServiceBuilder()
				.withEnvironment(env)
				.withAppiumJS(new File("C://Users//johnk//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();

		//Start Server
		service.start();
	}

	public void longPressEvent(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", (element), "duration", 2000
			));
	}

	public void scrollEvent(String menuText) {

		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + menuText + "\"));")).click();

	}

	public void swipeEvent(WebElement element, String direction) {

		// swipe
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
		    "elementId",(element),
		    "direction", direction,
		    "percent", 0.10
		));
	}

	public void dragDropEvent(WebElement element, Integer x, Integer y) {

		// Java
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", (element),
		    "endX", x,
		    "endY", y
		));

	}

	@AfterClass // This method will be called automatically after executing the class
	public void stop() {

		//stop driver
		driver.quit();

		//stop server
		service.stop();

	}
	
}
