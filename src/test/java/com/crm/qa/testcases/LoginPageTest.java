package com.crm.qa.testcases;

//@author : Ankit Lohia
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;

public class LoginPageTest extends TestBase {
	
	  Loginpage loginp;  // create object of nonstatic method to access methods.
	  Homepage homepage;
	
	 public LoginPageTest() {
		 super(); //calling parent class constructor or method using super keyword
		 
	 }
	 
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
	  initialization();
	  loginp= new Loginpage();
	  Takesscreenshot(driver);
		
	}
	
	
	@Test(priority=3)
	public void ForgotpwTest() throws IOException, InterruptedException {
		boolean result= loginp.ValidateForgotpw();
		Assert.assertTrue(true);
		Takesscreenshot(driver);
		
	}
	
	
	@Test(priority=2)
	public void LoginButtonTest() throws IOException, InterruptedException {
		boolean button= loginp.validateLoginButton();
		Assert.assertEquals(true, true);
		Takesscreenshot(driver);
	}
	
	
	@Test(priority=1)
	public void LoginFunctionlityTest() throws IOException, InterruptedException {
	  homepage=	loginp.login(prop.getProperty("Email"), prop.getProperty("password"));
	  Takesscreenshot(driver);
		
	}
	
	
	@AfterMethod
	public void teardown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	

}
