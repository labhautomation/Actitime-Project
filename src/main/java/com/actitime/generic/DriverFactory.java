package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public static WebDriver launch(String browserName){
		WebDriver driver=null;
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Users/Labh/Downloads/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:/Users/Labh/Downloads/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		return driver;
	}

}
