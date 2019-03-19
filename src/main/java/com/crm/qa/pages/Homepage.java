package com.crm.qa.pages;
//@author : Ankit Lohia
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Homepage extends TestBase{

	
	@FindBy(xpath="//span[contains(@class, 'user-display')]")
	WebElement Title;

	
	
	@FindBy(xpath="//*[@id='main-nav']/a[5]/span")
	WebElement Dealslink;
	
	
	
	@FindBy(xpath="//*[@id='main-nav']/a[3]")
	WebElement Contactslink;
	
	
	@FindBy(xpath="//*[@id='main-nav']/a[6]/span")
	WebElement Tasklink;
	
	
	//Initialize above pageslements
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifytitle() {
		String title= Title.getText();
		return title;
	}
	
	
	public boolean Verifydeallink() {
		 return Dealslink.isDisplayed();
	}

	
	public Dealspage dealsclick() {
		Dealslink.click();
		return new Dealspage();
	}
	
	
	public Taskspage tasksclick() {
		Tasklink.click();
		return new Taskspage();
	}
	
	public Contactspage contactsclick() {
		Contactslink.click();
		return new Contactspage();
	}
	

	
}
