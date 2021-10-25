package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.cssSelector(".text-center>h2");
	By navigationBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	private By header=By.cssSelector("div[class*='video-banner'] h3");
	By popup=By.xpath("//button[text()='NO THANKS']");
	public LandingPage(WebDriver driver)
	{
	this.driver=driver;
	}
	
	
	
	 	public LoginPage getLogin()
	
{
	 		driver.findElement(signin).click();
	      LoginPage lp = new LoginPage(driver);
	      return lp;
}
	 	
	 	
	 	public WebElement getNavigationBar()
	
	{
		return driver.findElement(navigationBar);
	}
	 	public int getPopUpSize()
		{
			return driver.findElements(popup).size();
		}
		public WebElement getPopUP()
		{
			return driver.findElement(popup);
		}
	public WebElement getTitle()
	
	{
		return driver.findElement(title);
	}
public WebElement getHeader()
	
	{
		return driver.findElement(header);
	}
}
