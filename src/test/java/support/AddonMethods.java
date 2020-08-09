package support;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class AddonMethods {
	
	WebDriver driver;
	public AddonMethods(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public static String dateTimeFormatting(String requiredFormat) {
		Date todaysDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(requiredFormat);
		String formattedDate = formatter.format(todaysDate);
		return formattedDate;
	}
	
	public void getScreenShotOnFailure(Scenario scenario)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	String path=System.getProperty("user.dir")+"/target/screenshots/"+scenario.getName()+dateTimeFormatting("ddMM_HHmmss")+".png";
    	try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
}
