package cucumberUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitHelper {

public WebDriver driver;
	
	public waitHelper(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	
	}
	
	public void waitElement(WebElement element , Duration time ) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
