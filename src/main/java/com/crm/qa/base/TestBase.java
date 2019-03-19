package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
// @author : Ankit Lohia

public class TestBase {

	public static WebDriver driver;
	public static Properties prop=new Properties();
	public static Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
	
	
	
	public TestBase() { // constructor of this class
		
		try {
			FileInputStream fp = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			try {
				prop.load(fp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		APP_LOGS.debug("File loaded to read");
		
	}

	
	public static void initialization() {
	    String browser= prop.getProperty("browser");
	    if(browser.equals("chrome")) {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\uipl-dev\\Desktop\\Selenium@feb2019\\chromedriver.exe");
			driver= new ChromeDriver();
	    	
	    }else if(browser.equals("Mozilla")) {
	    	
	    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\uipl-dev\\Desktop\\Selenium@feb2019\\geckodriver.exe");
               driver= new FirefoxDriver();
               
	    }
	    
	    APP_LOGS.debug("Launch Browser");
	          driver.manage().window().maximize();
			  driver.manage().deleteAllCookies();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
			  
			  driver.get(prop.getProperty("url"));
			  APP_LOGS.debug("Launch URL");
	}
	
	public static void Takesscreenshot(WebDriver driver) throws IOException, InterruptedException {
        File scr=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest= new File("D:\\temp\\screenshot_"+timestamp()+".png");
        FileUtils.copyFile(scr, dest);
        Thread.sleep(3000);
        APP_LOGS.debug("Screenshot Taken");
    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
    
 

    	
    	
    }
		

	

