package com.techbeetraining.EbayAppTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Main {
	
	public static void main(String [] args) {
		
		CalculatorElements calcElements = new CalculatorElements();
		AndroidDriver<AndroidElement> driver = calcElements.getDriver();
		
		calcElements.pause();
		driver.findElementByXPath(calcElements.getClearXpath()).click();
		driver.findElementByXPath(calcElements.getTwoXpath()).click();
		driver.findElementByXPath(calcElements.getPlusXpath()).click();
		driver.findElementByXPath(calcElements.getTwoXpath()).click();
		driver.findElementByXPath(calcElements.getEqualsXpath()).click();
		
		driver.quit();
	}
}