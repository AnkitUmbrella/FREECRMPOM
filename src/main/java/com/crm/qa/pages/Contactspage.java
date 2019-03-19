package com.crm.qa.pages;
//@author : Ankit Lohia
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import com.crm.qa.base.TestBase;
import com.crm.qa.testdata.UtilityFile;

public class Contactspage extends TestBase {

	  // public WebElement f;
	//New contact page DataDriven elements
	
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement ContactsLabel;
	
	
	@FindBy(xpath="//div[@name='action']")
	WebElement ActionsAvailability;
	
	
	@FindBy(name="first_name")
	@CacheLookup   // to store webelement in cache to speed up the script
	WebElement Firstname;
	
	@FindBy(name="last_name")
	WebElement Lastname;
	
	
	@FindBy(xpath="//input[@name='address']")
	WebElement Address;
	
	
	@FindBy(name="value")
	WebElement Email;
	
	@FindBy(xpath="//button[@class= 'ui linkedin button']")
	WebElement Save;
	

	
	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/a/button/text()")
	WebElement Newcontact;
	

	
		 //Initialise elements
	public Contactspage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean Labelcheck() {
		boolean cb= ContactsLabel.isDisplayed();
		return cb;
	}
	
	
	
	public boolean Actionscheck() {
	 boolean act= ActionsAvailability.isDisplayed();
		
		return act;
	}

	
	
	public String getpagetitle() {
	String titlepage= driver.getTitle();
		return titlepage;
	}
	
	
	public void ClickonNewcontact() {
		Newcontact.click();
	}
	
	
	public void scrolldown() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
	}
	
	
	public void socialclick(String datasocial) {
		
		String Facebook= "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[6]/div[1]/div/div/div/div[1]/div[2]/div[2]/span";
		String  LinkedIn= "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[6]/div[1]/div/div/div/div[1]/div[2]/div[3]/span";
		
		if(datasocial.equals(Facebook)) {
			driver.findElement(By.xpath(Facebook)).click();
		}else if(datasocial.equals(LinkedIn)) {
			driver.findElement(By.xpath(LinkedIn)).click();
		}
	}
	
	
	
	
	
	
	public void CreateNewContact(String fname,String lastname,String add,String email ) {
		
		Firstname.sendKeys(fname);
		Lastname.sendKeys(lastname);
		scrolldown();
		Address.sendKeys(add);
		Address.clear();
		Address.sendKeys(add);
		Email.sendKeys(email);
		Save.click();
		
		
	}
	
	

}
