package com.crm.qa.testcases;
//@author : Ankit Lohia
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;

public class HomepageTest extends TestBase {

	 Loginpage loginp;
	 Homepage homepage;  // create object of nonstatic method to access methods.
	 Contactspage contactpage;
	 
	
	 
	 //Testcases should be seperate trdt
	 // Before each test invoke browser and Login
	 //Execute scripts
	 //close the browser
	public HomepageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
	  initialization();
	  loginp= new Loginpage();
	  contactpage= new Contactspage();
	  homepage= loginp.login(prop.getProperty("Email"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void GettitleTest() {
		String title= homepage.verifytitle();
		Assert.assertEquals(title, "Ankit Lohia");
		//APP_LOGS.debug("Title Verification");
	}
	
	@Test(priority=2)
	public void VerifyDeallinkTest() {
		boolean linkpresent= homepage.Verifydeallink();
		Assert.assertEquals(linkpresent, true);
		//APP_LOGS.debug("Deal Link Verification");
		
	}
	
	
	@Test(priority=3)
	public void ClickDealLinkTest() {
		homepage.dealsclick();
		String text=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/table/thead/tr/th[4]")).getText();
		Assert.assertEquals(text, "Status");
	}
	
	
	@Test(priority=4)
	public void ClickTasksLinkTest() {
		homepage.tasksclick();
      //table[@class='ui celled sortable striped table custom-grid']/thead/tr/th[2]
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title= driver.findElement(By.xpath("//th[contains(text(), 'Options')]")).getText();
		Assert.assertEquals(title, "Options", "Error finding text");
	}
	
	@Test(priority=5)
	public void VerifyContactLinkTest() {
		contactpage = homepage.contactsclick();
		
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
