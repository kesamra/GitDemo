package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class Base {
	public WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	prop=new Properties();
	FileInputStream fis=new 
			FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
    prop.load(fis);
    //mvn test  -Dbrowser=chrome
   // String browsername= System.getProperty("browser");
   String browsername= prop.getProperty("browser");
   if(browsername.contains("chrome"))
   {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\madhu0906\\eclipse-workspace\\chromedriver.exe");
	   ChromeOptions options=new ChromeOptions();
	   if(browsername.contains("headless"))
	   {
	   options.addArguments("headless");  
   } 
	   driver =new ChromeDriver(options);
   }
   else if(browsername.equals("firefox"))
   {
	   driver=new FirefoxDriver();
   }
   else if (browsername.equals("IE"))
   {
   }
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   return driver;
   }

  public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
  {

	 TakesScreenshot ts=(TakesScreenshot) driver;
	  File source = ts.getScreenshotAs(OutputType.FILE);
	  String destinationFile=System.getProperty("user.dir") +"\\reports\\"+testCaseName+".png";
	  
		FileUtils.copyFile(source,new File(destinationFile));
	
		
		return destinationFile;
	}
	  
	  
  }


