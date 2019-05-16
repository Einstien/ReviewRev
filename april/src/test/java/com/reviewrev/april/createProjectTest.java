package com.reviewrev.april;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.loginPage;
import pages.signupPage;
import utlilities.commonMethods;
import utlilities.excelUtility;



public class createProjectTest extends baseFile {

	
	loginPage log;
	signupPage sign;
	
	
	
	
	
	
	
	@BeforeMethod
	public void setup() {
		intialize();
		log = new loginPage();	
		sign = new signupPage();
	}
	
	
	@Test
	public void creatProjectTest() {
		String url = prop.getProperty("qaURL");	
		driver.get(url);
		sign = log.navigateCreateAccount();			
		excelUtility.ShName = "CreateProject";		
		Sheet sh = excelUtility.readExcel();
		int lastRow = sh.getLastRowNum();
			
		for (int i=1; i<=3; i++) {			
			String a = excelUtility.getvalue(i, 0); 
			String b = excelUtility.getvalue(i, 1);
			String c = excelUtility.getvalue(i, 2);
			String d = excelUtility.getvalue(i, 3);
			String e = excelUtility.getvalue(i, 4);			
			sign.creatProject(a,b,c,d,e);
			
			
		}
		
		
	
	}
	
	@AfterTest 
	public void Test() {
		//driver.quit();
	}
	
}