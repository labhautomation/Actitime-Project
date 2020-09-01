package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseLib {
	public static WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser","baseurl"})
	public void preCondition(String browserName, String baseurl){
		driver=DriverFactory.launch(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseurl);
	}
	
	@AfterMethod
	public void postCondition(){
		driver.close();
		
		Reporter.log("Browser closed", true);
		
	}
	

}
