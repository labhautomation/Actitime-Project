package com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name="username")
	private WebElement unTxtBx;
	
	@FindBy(name="pwd")
	private WebElement pwdTxtBx;
	
	@FindBy(id="loginButton")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[@id='ServerSideErrorMessage']//span[@class='errormsg']")
	private WebElement invalidLoginMsgEle;
	
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getInvalidLoginMsgEle() {
		return invalidLoginMsgEle;
	}

	public WebElement getUnTxtBx() {
		return unTxtBx;
	}

	public WebElement getPwdTxtBx() {
		return pwdTxtBx;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
}
