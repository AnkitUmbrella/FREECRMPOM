package com.crm.qa.pages;

//@author : Ankit Lohia
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Loginpage extends TestBase {

	
	
	//PageFactory Elements or Object repo define for this class
	
	@FindBy(name="email")
	WebElement email;
	
	
	
	@FindBy(name="password")
	WebElement password;
	
	
	
	@FindBy(xpath="//div[contains(@class, 'ui fluid large blue submit button')]")
	WebElement LoginBtn;
	
	
	//@FindBy(xpath="//*[@id='ui']/div/div/div[1]/a")
	@FindBy(xpath="//div[2][contains(@class, 'ui message')]/a") //classic crm
	WebElement ForgotPw;
	
	

   //Create Constructor of this class
	//Initializing the Page Objects
   public Loginpage() {
	   PageFactory.initElements(driver, this);
	      
	   
   }

   
   //Actions
   public boolean ValidateForgotpw() {
	   return ForgotPw.isDisplayed();
	 
   }
   
   public boolean validateLoginButton() {
	  return LoginBtn.isEnabled();
	   
   }


   public Homepage login(String em, String pw) {
	   
	   email.sendKeys(em);
	   password.sendKeys(pw);
	   LoginBtn.click();
	   return new Homepage();
	   
   }
   
   
   
}


