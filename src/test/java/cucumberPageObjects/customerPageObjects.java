package cucumberPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class customerPageObjects {
public WebDriver driver;
	
	public customerPageObjects(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
		
	}

	
	
    By customer=	By.xpath("(//a[@href='#' and  @class='nav-link'])[6]");	
     By custList=	By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
     By Add=	By.xpath("//a[normalize-space()='Add new']");
     By email=	By.xpath("//input[@id='Email']");
     By pass=	By.xpath("//input[@id='Password']");
     By fName=	By.xpath("//input[@id='FirstName']");
     By lName=	By.xpath("//input[@id='LastName']");
     By gMale=	By.xpath("//input[@id='Gender_Male']");
     By gFemale=	By.xpath("//input[@id='Gender_Female']");
     By DOB=	By.xpath("//input[@id='DateOfBirth']");
     By company=	By.xpath("//input[@id='Company']");
     By taxAttempt=	By.xpath("//input[@id='IsTaxExempt']");
     By News=	By.xpath("//input[@class='k-input k-readonly']");
     By News1=          By.xpath("//li[text()='Your store name']");
     By News2=          By.xpath("//li[text()='Test store 2']");
 //    By custRoles=	By.xpath("//div[@class='input-group-append input-group-required']//input[@role='listbox']");
     By custRoles=	By.xpath("(//div[@class='k-widget k-multiselect k-multiselect-clearable'])[2]");
     By admin=	By.xpath("//li[text()='Administrators']");
     By frum=	By.xpath("//li[text()='Forum Moderators']");    
     By guest=	By.xpath("//li[text()='Guests']");
     By regi=	By.xpath("//li[text()='Registered']");
     By vend=	By.xpath("//li[text()='Vendors']");
     By vendclick=	By.xpath("//select[@id='VendorId']");
     By nonven=	By.xpath("//select[@id='VendorId']//option[text()='Not a vendor']");
     By ven1=	By.xpath("//select[@id='VendorId']//option[text()='Vendor 1']");
     By ven2=	By.xpath("//select[@id='VendorId']//option[text()='Vendor 2']");
     By act=	By.xpath("//input[@id='Active']");
     By comment=	By.xpath("//textarea[@class='form-control']");
     By save=	By.xpath("//button[@name='save']");
     
     
     //Action Methods
     
     public String getPageTitle() {
    	return driver.getTitle();
     }
     
     public void clickOnCustMenuu() {
    	 driver.findElement(customer).click();
    	 
     }
     
  /*  public void setcust() {
    	 cust.click();
     }*/
     public void clickOnCustMenuitem() {
    	 driver.findElement(custList).click();
    	 
     }
     public void Addd() {
    	 driver.findElement(Add).click();
    	 
     }
     public void setEmail(String emaill) {
    	 driver.findElement(email).sendKeys(emaill);
    	 
     }
     public void setPass(String password) {
    	 driver.findElement(pass).sendKeys(password);
    	 
     }
     public void setfName(String Fname) {
    	 driver.findElement(fName).sendKeys(Fname);
    	 
     }
     public void setlName(String Lname) {
    	 driver.findElement(lName).sendKeys(Lname);
    	 
     }
     public void gender(String gender) {
    	 
    	 if(gender.equals("Male")) {
    		 driver.findElement(gMale).click();  
    	 }
    	 else if(gender.equals("Female")) {
    		 
    		 driver.findElement(gFemale).click();  
    	 }
    	 else
    	 {
    		 driver.findElement(gMale).click();
    	 }
    		 
    	
    	 
     }
    
  
     public void setCompany(String comp) {
    	 driver.findElement(company).sendKeys(comp);
    	 
     }
     
     public void setCustomerRules(String role) {
    	 if(!role.equals("Vendors")) {
    		 driver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[2]"));
    	 }
    	 driver.findElement(custRoles).click();
    	 
    	    WebElement item;
    	 
    	 if(role.equals("Administrators")) {
    		 
    		item= driver.findElement(admin);
    		 
    	 }
    	 else	 if(role.equals("Forum Moderators")) {
    		 
     		item= driver.findElement(frum);
     		 
     	 }
    	 else	 if(role.equals("Guests")) {
    		 
     		item= driver.findElement(guest);
     		 
     	 }
    	 else if(role.equals("Registered")) {
    		 
     		item= driver.findElement(regi);
     		 
     	 }
    	 else if(role.equals("Vendors")) {
    		 
      		item= driver.findElement(vend);
      		 
      	 }
    	 else	 {
    		 
      		item= driver.findElement(guest);
      		 
      	 }
        //   item.click();
    	 JavascriptExecutor jse= (JavascriptExecutor) driver;
    	 jse.executeScript("arguments[0].click();", item);
    	 
    	 
    	
    	 
     }
     public void setManagerVendor(String value) {
    	
    	 
    	 
    	 Select drp= new Select(driver.findElement(vendclick));
         drp.selectByVisibleText(value);
    	 
     }
     public void setNews(String value2) {
    	 driver.findElement(News).click();    	 
    	 if(value2.equals("Test store 2")) {
    		 driver.findElement(News1).click();
    	 }
    	 else if (value2.equals("Your store name")) {
    		 driver.findElement(News2).click();
    	 }
    	
    	/* Select drp= new Select(driver.findElement(News));
    	 drp.selectByVisibleText(value2);*/
     }
     
     public void commit(String value3) {
     	
    	driver.findElement(comment).sendKeys(value3);
     }
 public void save() {
	 driver.findElement(save).click();
    	
    	 
     }
 public void dob(String date) {
	 driver.findElement(DOB).sendKeys(date);
    	
 }	 
 public void tax() {
	 driver.findElement(taxAttempt).click();
    	
 }	 
 public void active() {
	 driver.findElement(act).click();
    	
 }	 
     
     
}
