package org.cressanda.IFM.base.TestScript;

import org.cressanda.IFM.Login.Page.LoginPage;
import org.cressanda.IFM.WebUtils.Uti;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTestScript {

	private Uti util;
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
		util=Uti.getInstance();
		util.loadProperties("config");
		
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}
	
	@Parameters({"browser,url"})
	@BeforeMethod
	public void beforeMethod(String browser,String url) {
		System.out.println("beforeMethod");
		util.launchBrowser(browser);
		util.openApplication(url);
		LoginPage loginPG=new LoginPage(util);
		loginPG.doLogin();
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
		
	}
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
	}
}
