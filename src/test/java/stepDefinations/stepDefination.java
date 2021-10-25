package stepDefinations;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
import resources.Base;

@RunWith(Cucumber.class)
public class stepDefination extends Base{
	@Given("Initialize the browser with chrome")
	public void initialize_the_browser_with_chrome() throws IOException {
		driver=initializeDriver();
	}

	@Given("Navigate to {string} site")
	public void navigate_to_site(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(string);
	}

	@Given("Click on Login in home page land on Secure sign in Page")
	public void click_on_Login_in_home_page_land_on_Secure_sign_in_Page() {
		LandingPage l= new LandingPage(driver);
		
		LoginPage lp= l.getLogin();
		if(l.getPopUpSize()>0)
		{
			l.getPopUP().click();
		}
		lp.getLogin().click();
		
	}

	@Then("Verify that user is Successfully logged in")
	public void verify_that_user_is_Successfully_logged_in() {
	   PortalHomePage p=new PortalHomePage(driver);
	   Assert.assertTrue(p.getSearchBox().isDisplayed());
	}   
	@When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
LoginPage lp= new LoginPage(driver);
		
		
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		
		lp.getLogin().click();
    }
	@And("^close browsers$")
    public void close_browsers() throws Throwable {
        driver.quit();
    }
}