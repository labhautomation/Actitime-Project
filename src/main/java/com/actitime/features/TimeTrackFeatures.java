package com.actitime.features;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.actitime.pageobject.EnterTimeTrackPage;

public class TimeTrackFeatures {
	
	WebDriver driver;
	EnterTimeTrackPage ettp;
	
	public TimeTrackFeatures(WebDriver driver){
		this.driver=driver;
		ettp= new EnterTimeTrackPage(driver);
	}
	
	public void verifyHomePage(){
		
		String expectedText="Enter Time-Track";
		String actualText = ettp.getPagetitle().getText();
		Assert.assertEquals(actualText, expectedText);
		
		String expectedTitle = "actiTIME - Enter Time-Track";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Home Page (EnterTimeTrack) is verified", true);
	}

}
