package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearch {
	
	WebDriver driver=null;
	@Given("user is on google homepage")
	public void launchGoogle()
	{
		String driverPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", driverPath+"/src/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");
	}
	
	@When("^user enter (.*) keyword$")
	public void enterSearchWord(String search)
	{
		driver.findElement(By.name("q")).sendKeys(search);
	}
	
	@And("click search button")
	public void clcikSearchButton()
	{
		driver.findElement(By.name("btnK")).click();
	}
	
	@Then("all the search results should be displayed")
	public void areSearchResultsFound()
	{
		Assert.assertTrue(driver.getPageSource().contains("Newsroom | Aboutestt Facebook"));
		driver.close();
		driver.quit();
	}

}
