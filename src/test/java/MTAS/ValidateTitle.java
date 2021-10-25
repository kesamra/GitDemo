package MTAS;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;


public class ValidateTitle extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	LandingPage l;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Homepage");
	}
	@Test
	public void basePagenavigation() throws IOException
	{
		
		l= new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES1");	
		log.info("Successfully Vlidated Text message");
	}
	
	@Test
	public void validateHeader() throws IOException
	{
		
		 
		Assert.assertEquals(l.getHeader().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");	
		log.info("Successfully Vlidated Text message");
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
}
