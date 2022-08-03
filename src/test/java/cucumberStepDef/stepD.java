package cucumberStepDef;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

import io.cucumber.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
public class stepD {
	
 WebDriver driver;
@Given("i Launch chrome browser")
public void i_launch_chrome_browser() {
	
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	System.out.println("launch");
	
   
}

@When("i open orange hrm homepage")
public void i_open_orange_hrm_homepage() {
	
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	System.out.println("homepage");
}

@Then("i verify that the logo presence on page")
public void i_verify_that_the_logo_presence_on_page() {
boolean status=	driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img")).isDisplayed();
    Assert.assertEquals(true,status);
    System.out.println(status);
	System.out.println("logo");
}


@Then("close browser")
public void close_browser() {
	driver.quit();
	System.out.println("browser");
}

}
