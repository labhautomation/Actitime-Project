package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.features.LoginFeatures;
import com.actitime.features.TaskFeatures;
import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;

public class TaskTest extends BaseLib {
	String filepath="E:/workspace/ActitimeProjectMaven/testdata/testdata.xlsx";

	@Test
	public void createCustomer(){
		ExcelUtilities eu= new ExcelUtilities(filepath);
		String username=eu.readData("sheet1", 3, 1);
		String password=eu.readData("sheet1", 3, 2);
		
		LoginFeatures lf= new LoginFeatures(driver);
		lf.login(username, password);
		
		String customerName = eu.readData("sheet1", 3, 3);
		TaskFeatures tf= new TaskFeatures(driver);
		tf.createCustomer(customerName);
		tf.verifyCreateCustomer(customerName);
		tf.logout();
		
		
		
	}

}
