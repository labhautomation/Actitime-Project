package com.actitime.features;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.actitime.pageobject.LoginPage;

public class LoginFeatures {
	
	WebDriver driver;
	public LoginPage lp;
	
	public LoginFeatures(WebDriver driver){
		this.driver=driver;
		
		lp= new LoginPage(driver);
	}
	public void login(String username, String password){
		lp.getUnTxtBx().sendKeys(username);
		lp.getPwdTxtBx().sendKeys(password);
		lp.getLoginBtn().click();
		
		
	}
	public void verifyInvalidLogin(){
		String expectedText="Username or Password is invalid. Please try again.";
		String actualText=lp.getInvalidLoginMsgEle().getText();
		Assert.assertEquals(actualText, expectedText);
		Reporter.log("invalid login is verified", true);
		
	
	}

}
