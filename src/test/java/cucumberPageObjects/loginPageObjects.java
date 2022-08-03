package cucumberPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageObjects {

	
	public WebDriver driver;
	
	public loginPageObjects(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement pass;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement loginbutton;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutbutton;
	
	
	public  void setUserName(String userr) {
		email.clear();
		email.sendKeys(userr);
	}
	public  void setUserPass(String passs) {
		pass.clear();
		pass.sendKeys(passs);
	}
	public  void Login() {
		
		loginbutton.click();
	}
	public  void Logout() {
	
		logoutbutton.click();
	}
}
