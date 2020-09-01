package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.features.LoginFeatures;
import com.actitime.features.TimeTrackFeatures;
import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;

public class LoginTest extends BaseLib {
	String filepath="E:/workspace/ActitimeProjectMaven/testdata/testdata.xlsx";
	@Test(priority=1)
	public void validLogin()
	{
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String username=eu.readData("sheet1", 1, 1);
		String password=eu.readData("sheet1", 1, 2);
		
		LoginFeatures lf= new LoginFeatures(driver);
		lf.login(username, password);
		
		TimeTrackFeatures ttf = new TimeTrackFeatures(driver);
		ttf.verifyHomePage();
    }
	
	@Test(priority=2)
	public void invalidlogin(){
		ExcelUtilities eu= new ExcelUtilities(filepath);
		String username=eu.readData("sheet1", 2, 1);
		String password = eu.readData("sheet1", 2, 2);
		LoginFeatures lf = new LoginFeatures(driver);
		lf.login(username, password);
		
		lf.verifyInvalidLogin();
	}
}
