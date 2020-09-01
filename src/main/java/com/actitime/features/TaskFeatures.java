package com.actitime.features;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.actitime.pageobject.ActiveProjCustPage;
import com.actitime.pageobject.CreateNewCustPage;
import com.actitime.pageobject.EnterTimeTrackPage;
import com.actitime.pageobject.OpenTaskPage;

public class TaskFeatures {

	WebDriver driver;
	EnterTimeTrackPage ettp;
	OpenTaskPage otp;
	ActiveProjCustPage apcp;
	CreateNewCustPage cncp;
	
	public TaskFeatures(WebDriver driver){
		this.driver=driver;
		ettp= new EnterTimeTrackPage(driver);
		otp= new OpenTaskPage(driver);
		apcp= new ActiveProjCustPage(driver);
		cncp= new CreateNewCustPage(driver);
	}
	
	public void createCustomer(String customerName){
		
		ettp.getTaskEle().click();
		otp.getProjCusLink().click();
		apcp.getCreateNewCustBtn().click();
		cncp.getCustNameTxtBx().sendKeys(customerName);
		cncp.getCreateCustSubmitBtn().click();
	}
	
	public void verifyCreateCustomer(String customerName){
	String expectedMsg = "Customer \""+customerName+"\" has been successfully created.";
	String actualMsg=apcp.getSuccessMsgEle().getText();
	Assert.assertEquals(actualMsg, expectedMsg);
	Reporter.log(expectedMsg, true);	
	}
	public void logout(){
		apcp.getLogoutLink().click();
	}
}
