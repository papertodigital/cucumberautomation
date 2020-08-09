package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.SwaglabsHomepage;
import pagefactory.SwaglabsLoginPage;
import support.AddonMethods;
import support.PropertyConfigiurator;

public class SwaglabsLoginSteps {
	
	WebDriver driver=null;
	SwaglabsLoginPage loginPage;
	SwaglabsHomepage homePage;
	AddonMethods addOns;
	public static String browser=null;
	public PropertyConfigiurator propertyConfig=new PropertyConfigiurator("/src/main/resources/config.properties");
	Logger log=LogManager.getLogger(SwaglabsLoginSteps.class);
	
	@Before
	public void invokeBrowser()
	{
		browser=propertyConfig.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			String driverPath=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", driverPath+"/src/resources/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			String driverPath=System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver", driverPath+"/src/resources/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
	}
	
	@Given("user is on swaglabs login page")
	public void launchLoginPage() throws InterruptedException
	{
		
		log.info("about to launch browser");	
		driver.navigate().to(propertyConfig.getProperty("url"));
		log.info("Successfully launched Saucedemo website");
	}
	
	@When("user enter {string} and {string} as credentials")
	public void enterUserCredentials(String username,String password)
	{
		loginPage=new SwaglabsLoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		
	}
	
	@And("user click on Login button")
	public void clickLogin()
	{
		loginPage=new SwaglabsLoginPage(driver);
		loginPage.clickLoginButton();
		
	}
	
	@Then("user redirects to swaglabs homepage")
	public void isItHomePage()
	{
		log.info("User login successful");
		homePage=new SwaglabsHomepage(driver);
		Assert.assertTrue("Not a homepage", homePage.isProductlabelDisplayed());
	}
	
	@When("user click on logout button")
	public void logOut()
	{
		homePage=new SwaglabsHomepage(driver);
		homePage.clickOnActionMenu();
		homePage.clickLogout();
	}
	
	@Then("login page will be displayed")
	public void isLoginPageDisplayed()
	{
		loginPage=new SwaglabsLoginPage(driver);
		Assert.assertTrue("Not a login page", loginPage.isLoginButtonEnabled());
	}
	
	@After
	public void after(Scenario scenario){
		 try {
		if (scenario.isFailed()) {
	        	addOns=new AddonMethods(driver);
	        	//String destinationPath=
	        			addOns.getScreenShotOnFailure(scenario);
	       }
		 }catch(Exception e){
	          e.printStackTrace();
	       }finally {
	  	     driver.close();
	        
	  }        
	}
	
	
//	@After
//	 public void tearDown(Scenario scenario) {
//	   try {
//	     if (scenario.isFailed()) {
//	       final byte[] screenshot = ((TakesScreenshot) driver)
//	           .getScreenshotAs(OutputType.BYTES);
//	       scenario.attach(screenshot, "image/png", "tets");
//	     }
//	   } finally {
//	     driver.close();
//	   }
//	 }
}


