package MTAS;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class Homepage extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		
	}
	@Test(dataProvider="getData")
	public void homepagenavigation(String Username, String Password, String text) throws IOException
	{
		driver.get(prop.getProperty("url"));
		LandingPage l= new LandingPage(driver);
		LoginPage lp= l.getLogin();
		
		
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		log.info(text);
		lp.getLogin().click();	
		ForgotPassword fp=lp.forgotPassword();
		fp.getEmail().sendKeys("ram@gmail.com");
		fp.sendMeInstructions().click();
	}
	@AfterTest
	public void closeBroser()
	{
		driver.close();
	}
	@DataProvider
	public Object[][] getData()
	{
	//Row stands for howmay different data types test should run
		//Column stands for how many value per each test
		Object[][] data =new Object[2][3];
		 //0th row
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="Non restricted user";
		
		//1st row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="123456";
		data[1][2]="restricted user";
		return data;
		
	}

}
