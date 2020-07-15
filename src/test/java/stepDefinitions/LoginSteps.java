package stepDefinitions;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	
	@Given("A user is on login page")
	public void isUserOnLogin()
	{
		
		System.out.println("User on login page");
	}
	
	@When("user enters username and passowrd")
	public void enterLoginDetails()
	{
		System.out.println("Login details entered successfully");
	}
	
	@And("click login nutton")
	public void clickLogin()
	{
		System.out.println("Clicked login successfully");
	}
	
	@Then("user should navigate to homepage")
	public void isUserOnHomePage()
	{
		System.out.println("User on homepage");
	}

}
