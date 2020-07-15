package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwaglabsLoginPage {
	
	@FindBy(id="user-name")
	private WebElement txt_username;
	
	@FindBy(id="password")
	private WebElement txt_password;
	
	@FindBy(css="input.btn_action")
	private WebElement btn_login;
	
	WebDriver driver;
	
	public SwaglabsLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String username)
	{
		txt_username.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		btn_login.click();
	}
	
	public boolean isLoginButtonEnabled()
	{
		return btn_login.isEnabled();
	}
	

}
