package com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiveProjCustPage extends BasePage {
	
	@FindBy(css="input[value='Create New Customer']")
	private WebElement createNewCustBtn;
	
	@FindBy(xpath="//table[@id='SuccessMessages']//span")
	private WebElement successMsgEle;
	
	

	public ActiveProjCustPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateNewCustBtn() {
		return createNewCustBtn;
	}
	public WebElement getSuccessMsgEle() {
		return successMsgEle;
	}
}
