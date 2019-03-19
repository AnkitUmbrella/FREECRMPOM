package com.crm.qa.testcases;
//@author : Ankit Lohia
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.testdata.UtilityFile;

public class ContactspageTest extends TestBase{
	
    Homepage homepage;
	Loginpage loginp;
	Contactspage contactpage;
	
	public ContactspageTest() {
		super();
	}
	

	@BeforeMethod
	public void setup() {
	  initialization();
	  loginp= new Loginpage();
	 // contactpage=new Contactspage();
	//  homepage=new Homepage();
	  homepage= loginp.login(prop.getProperty("Email"), prop.getProperty("password"));
	  contactpage=homepage.contactsclick();
	  
	  
	  
	}
	
	//driver.navigate().to("https://ui.cogmento.com/contacts/new");
	
	@Test(priority=1)
	public void LabelCheckTest() {
		boolean label= contactpage.Labelcheck();
		Assert.assertEquals(label, true, "Error in Labelchecktest");
		
	
	}
	
	
	@Test(priority=2)
	public void ActionTest() throws InterruptedException {
		boolean act= contactpage.Actionscheck();
		Thread.sleep(2000);
		Assert.assertEquals(act, true, "Error in Actiontest");
		APP_LOGS.debug("Actions test");
	}
	
	
	@Test(priority=3)
	public void driverTitleTest() {
		String pagetitle= contactpage.getpagetitle();
		Assert.assertEquals(pagetitle, "Cogmento CRM");
		APP_LOGS.debug("Contacts Title Test");
	}
	
	
	/*
	@DataProvider
	public Iterator<Object[]> getdata() {
		
	ArrayList<Object[]> ar= UtilityFile.getdatafromExcel();	
		return ar.iterator();
	}
	
	
	@Test(priority=4, dataProvider="getdata")
	public void Create_New_ContactTest(String fname,String lastname,String add,String email ) throws InterruptedException, IOException {
		contactpage.driver.navigate().to("https://ui.cogmento.com/contacts/new");;
		//cp.CreateNewContact("Ankit", "Lohia", "Karol Bagh", "Testabc@gmail.com");
		 Thread.sleep(3000);
		 contactpage.CreateNewContact(fname, lastname, add, email);
		driver.navigate().to("https://ui.cogmento.com/contacts");
		Takesscreenshot(driver);
	}
	
*/
	
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
