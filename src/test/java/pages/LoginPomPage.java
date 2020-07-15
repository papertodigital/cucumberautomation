package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPomPage {

	WebDriver driver;
	
	By txt_username=By.id("user-name");
	By txt_password=By.id("password");
	By btn_login=By.id("login-button");
	
	public By clickAddtoCartButton(String productName)
	{
		return By.xpath("//div[text()='"+productName+"']//parent::a//parent::div//following-sibling::div[@class='pricebar']//button");
	}
	
	public LoginPomPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterUsername()
	{
		driver.findElement(txt_username).sendKeys("standard_user");
	}
	
	public void enterPassword() {
		driver.findElement(txt_password).sendKeys("secret_sauce");
	}
	
	public void clickLogin()
	{
		driver.findElement(btn_login).click();
	}
	
	public void addProducttoCart(String productName)
	{
		driver.findElement(clickAddtoCartButton(productName)).click();
	}
}
