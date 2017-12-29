 /*
  * 
  * Starting app on phone directly and starting it .
  * 
  * */

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

public class TestDeployApp2 {
	
	// IOSElement, AndroidElement, MobileElement, WebElement 
public static AndroidDriver<WebElement> driver;
	
public static void main(String[] args) throws MalformedURLException, InterruptedException{
		
	
	
		AppiumDriverLocalService service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
						.usingDriverExecutable(new File("/Applications/Appium.app/Contents/Resources/node/bin/node")));
						//.withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/node_modules/appium/lib/appium.js"))
						//.withLogFile(new File("/Desktop/appiumlogs/logs.txt")));
		service.start();
		
		// File app = new File("/Users/basildzewu/Downloads/selendroid-test-app-0.17.0.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		// capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("deviceName", "SAMSUNG-SGH-1337");
		capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability("platformName", "Android");
		
		// capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "io.selendroid.testapp");
		capabilities.setCapability("appActivity", ".HomeScreenActivity");
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		
		
		Thread.sleep(2000);
		
		
		driver.quit();
		service.stop();
		
	}


}
