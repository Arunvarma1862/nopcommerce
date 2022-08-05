package cucumberStepDef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;



import cucumberPageObjects.customerPageObjects;
import cucumberPageObjects.loginPageObjects;
import cucumberPageObjects.searchPageObjects;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;


@RunWith(Cucumber.class)
public class StepDefintion extends BaseClass {
	
    @Before
	public void setup() throws IOException {
    	
    	configpro= new Properties();
    	FileInputStream fis= new FileInputStream("C:\\eclipse project\\nopCommerceV_001.cucumber\\config.properties");
    	configpro.load(fis);

		logger=  (Logger) LogManager.getLogger(StepDefintion.class.getName());
		
	String br= configpro.getProperty("browser");
	
	if(br.equals("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
		logger.info("***********launching browser***********");
	}
	else if (br.equals("edge")) {
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		logger.info("***********launching browser***********");
	}
		
	
	}
      

	@Given("User launch chrome Browser")
	public void user_launch_chrome_browser() {
		
	    lpo	= new loginPageObjects(driver);
		
	}

	@When("User open URL {string}")
	public void user_open_url(String url) {
		
	  driver.get(url);
		logger.info("***********navigate to url***********");

	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pass) {
		
		lpo.setUserName(email);
		lpo.setUserPass(pass);
		logger.info("***********enter email and password***********");
	}

	@When("Click on Login")
	public void click_on_login() {

		
		lpo.Login();
		logger.info("***********login success***********");
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
			Assert.assertTrue(false);
		}
		else
			Assert.assertEquals(title, driver.getTitle());
	
	}
	

	@When("user click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
          lpo.Logout();
          Thread.sleep(2000);
      	logger.info("***********logout sucesss***********");
	}
	
	@Then("close browsers")
	public void close_browsers() {
	   driver.quit();
		   }
	
	//add new customer
	
	@Then("User can view DashBoard")
	public void user_can_view_dash_board() {
	    cpo = new customerPageObjects(driver);
	  //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    Assert.assertEquals("Dashboard / nopCommerce administration", cpo.getPageTitle());
	    
	}
	

	@When("user click on customer menu")
	public void user_click_on_customer_menu() throws InterruptedException {

		
		Thread.sleep(2000);
		cpo.clickOnCustMenuu();
		
	}

	@When("user click on customer menu item")
	public void user_click_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(2000);
	    cpo.clickOnCustMenuitem();
	}

	@When("click on add new button")
	public void click_on_add_new_button() throws InterruptedException {
		Thread.sleep(2000);
          cpo.Addd();
	}

	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() {
	   Assert.assertEquals("Add a new customer / nopCommerce administration", cpo.getPageTitle());
	}

	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		Thread.sleep(2000);
		String email= randomstring()+"@gmail.com";
		cpo.setEmail(email);
		cpo.setPass("abc12345");
		cpo.setfName("virat");
		cpo.setlName("kohil");
		cpo.gender("Female");
		cpo.dob("12/08/1994");
		cpo.setCompany("abilitec");
		cpo.tax();
//		cpo.setNews("Your store name");
		Thread.sleep(2000);
		// registered default
		// the customer cannot be guests or registered
		// add the customer to guests or registered customer role
		cpo.setCustomerRules("Administrators");
		Thread.sleep(2000);
		cpo.setManagerVendor("Vendor 1");
		cpo.active();
	//	cpo.commit("success");
		
	  
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		Thread.sleep(2000);
		cpo.save();
	
	}

	@Then("user can view confirmation meassage {string}")
	public void user_can_view_confirmation_meassage(String string) {
	  
	//	Assert.assertEquals(string, cpo.getPageTitle());
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
	}
	
// 	search customer by email id

	@When("enter customer email")
	public void enter_customer_email() {
		
		spo= new searchPageObjects(driver);
		spo.setEmail("victoria_victoria@nopCommerce.com");
		
            
	}
	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
		spo.setButton();
		Thread.sleep(2000);
	  
	}
	@Then("user should und email in search table")
	public void user_should_und_email_in_search_table() {
	boolean status= spo.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	Assert.assertEquals(true, status);
	}

// 	search customer by first and last name


	@When("enter customer first name")
	public void enter_customer_first_name() {
		spo= new searchPageObjects(driver);
		spo.setFname("Victoria");
	}
	@When("enter customer last name")
	public void enter_customer_last_name() {
      spo.setLname("Terces");
	}
	@Then("user should found First and lastName in search table")
	public void user_should_found_first_and_last_name_in_search_table() {
 boolean status= spo.searhCustomerBYName("Victoria Terces");
 Assert.assertEquals(true, status);
	}



}
