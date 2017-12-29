package com.ebafni.AppiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestDropdownsonWebApp {
	
	// IOSElement, AndroidElement, MobileElement, WebElement 
	public static AndroidDriver<WebElement> driver;
	
public static void main(String[] args) throws MalformedURLException, InterruptedException{
		
		// starting the Appium server code 
	// Applications/Appium.app/Contents/Resources/node/bin/node
	
	//appium/build/lib/main.js
	
	AppiumDriverLocalService service = AppiumDriverLocalService
			.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File("/usr/local/bin/node"))
					.withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/node_modules/appium/lib/appium.js"))
					.withLogFile(new File("/Desktop/appiumlogs/logs.txt")));
	service.start();
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("deviceName", "SAMSUNG-SGH-1337");
		capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability("platformName", "Android");
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		driver.get("http://wikipedia.org");
		
		driver.manage().deleteAllCookies();
		
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		// new Select(dropdown).selectByValue("hi");
		Select select = new Select(dropdown);
		select.selectByValue("hi");
		
		// printing all values from drop down 
		List<WebElement> values = driver.findElements(By.tagName("option"));
		
		System.out.println(values.size());
		for (WebElement value : values){
			value.getAttribute("lang");
		}
		
		// printing all values from drop down 
				List<WebElement> links = driver.findElements(By.tagName("option"));
				
				System.out.println(links.size());
				for (WebElement link : links){
					System.out.println(link.getAttribute("href")+"----"+link.getText());
				}
		
		
		Thread.sleep(2000);
		
		
		driver.quit();
		service.stop();
		
	}


}
