package com.techbeetraining.CalculatorAppTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorElements {
	
	private String twoXpath = "//android.widget.Button[@resource-id='com.google.android.calculator:id/digit_2']";
	private String plusXpath = "//android.widget.Button[@resource-id='com.google.android.calculator:id/op_add']";
	private String equalsXpath = "//android.widget.Button[@resource-id='com.google.android.calculator:id/eq']";
	private String clearXpath = "//android.widget.Button[@resource-id='com.google.android.calculator:id/clr']";
	
	private int waitTime = 10;
	
	private AndroidDriver<AndroidElement> driver = null;
	
	public CalculatorElements() {
		this.driver = setupDriver();
	}
	
	public String getTwoXpath () {
		return twoXpath;
	}
	
	public String getPlusXpath () {
		return plusXpath;
	}
	
	public String getEqualsXpath () {
		return equalsXpath;
	}
	
	public String getClearXpath () {
		return clearXpath;
	}
	
	public int getWaitTime() {
		return waitTime;
	}
	
	public AndroidDriver<AndroidElement> getDriver() {
		return driver;
	}
	
	private AndroidDriver<AndroidElement> setupDriver() {
	
		AndroidDriver<AndroidElement> driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		File appDir = new File("C:/Users/TimothyPolke/Desktop/");
		File app = new File(appDir, "Calculator_base.apk");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		capabilities.setCapability("appPackage", "com.google.android.calculator");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		//capabilities.setCapability("appWaitPackage","com.google.android.calculator");
		//capabilities.setCapability("appWaitActivity","com.android.calculator2.Calculator");
		
		try {
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return driver;
	}
	
	public void pause() {
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}
}