package com.reviewrev.april;



import java.sql.SQLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.homePage;
import pages.loginPage;
import pages.socialAccountPage;
import utlilities.commonMethods;


public class connectSocialAccountTest extends baseFile {

	loginPage log;
	homePage home;
	socialAccountPage social;
	
	@BeforeTest
	public void setup() {
	    intialize();
		log = new loginPage();
		home = new homePage();
		social = new socialAccountPage();
		
	}
	
//	@Test
//	public void testDB () throws ClassNotFoundException, SQLException {
//		commonMethods.connectDatabase();
//	}
	
	
	@Test (enabled=true)
	public void verifySocialAccountConnect()  {		
		
		String url = prop.getProperty("qaURL");		
		driver.get(url);		
		String usrName = "01noccqa0904@yopmail.com";
		String pass = "test";
		boolean rememChk = false;		
		log.login(usrName, pass, rememChk);		
		home.navigateconnectSocialTile();
		commonMethods.pageLoadWait();
		social.connectFacebook("rusocialpod@gmail.com", "Itsqateam@321" , "Testing Red" );		
	}
	
	@AfterTest
	public void closeAll() {
		driver.quit();
	}	

}
	

