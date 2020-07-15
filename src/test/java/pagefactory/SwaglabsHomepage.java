package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwaglabsHomepage {
	
	@FindBy(css=".product_label")
	private WebElement label_product;
	
	@FindBy(css=".bm-burger-button")
	private WebElement btn_actionsmenu;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement link_logout;
	
	WebDriver driver;
	
	public SwaglabsHomepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductlabelDisplayed()
	{
		return label_product.isDisplayed();
	}
	
	public void clickOnActionMenu()
	{
		btn_actionsmenu.click();
	}
	
	public void clickLogout()
	{
		link_logout.click();
	}
	

}
