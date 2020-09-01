package com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCustPage {

	
	@FindBy(name="name")
	private WebElement custNameTxtBx;
	@FindBy(name="createCustomerSubmit")
	private WebElement createCustSubmitBtn;
	
	public CreateNewCustPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getCustNameTxtBx() {
		return custNameTxtBx;
	}
	public WebElement getCreateCustSubmitBtn() {
		return createCustSubmitBtn;
	}
	
}
