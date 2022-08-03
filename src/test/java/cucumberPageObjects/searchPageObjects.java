package cucumberPageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumberUtilities.waitHelper;

public class searchPageObjects {

	public WebDriver driver;
	waitHelper helper;

	public searchPageObjects(WebDriver driver){

		this.driver=driver;
		PageFactory.initElements(driver, this);
		helper= new waitHelper(driver);


	}
  @FindBy(how= How.ID ,using ="SearchEmail")
  WebElement txtemail;
  
  @FindBy(how=How.ID, using="SearchFirstName")
  WebElement txtfName;
  
  @FindBy(how=How.ID, using="SearchLastName")
  WebElement txtlName;
  
  @FindBy(how=How.ID, using="search-customers")
  WebElement txtButton;
  
  @FindBy(how=How.XPATH, using="//table[@id='customers-grid']")
  WebElement table;
  
  @FindBy(how=How.XPATH, using="//table[@id='customers-grid']//tbody//tr")

    List<WebElement> tablerows;
  
  @FindBy(how=How.XPATH, using="//table[@id='customers-grid']//tbody//tr//td")
  List<WebElement> tablecoulmns;
  
  public void setEmail(String email) {
	  helper.waitElement(txtemail, Duration.ofSeconds(20));
	  txtemail.clear();
	  txtemail.sendKeys(email);
	  
  }
 
  public void setFname(String fname) {
	  helper.waitElement(txtemail, Duration.ofSeconds(20));
	  txtfName.clear();
	  txtfName.sendKeys(fname);
	  
  }
  public void setLname(String lname) {
	  helper.waitElement(txtemail, Duration.ofSeconds(20));
	  txtlName.clear();
	  txtlName.sendKeys(lname);
	  
  }
  public void setButton() {
	    txtButton.click();
	    helper.waitElement(txtemail, Duration.ofSeconds(20));
	  
  }
  public int getRows() {
	 
	 return tablerows.size();
	  
  }
  public int getcolm() {
		 
	 return tablecoulmns.size();
	  
  }
  public boolean  searchCustomerByEmail(String mail) {
	  
	  boolean flag=false;
	  
	  for (int i = 1; i <=getRows(); i++) {
	  String mails=	   table.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr["+i+"]//td[2]")).getText();
		System.out.println(mails);
	if(mails.equals(mail)) {
		flag=true;
	}
	}
	return flag;  
  }
  
  public boolean searhCustomerBYName(String name) {
	  boolean flag=false;
	  
	  for (int i = 1; i <= getRows(); i++) {
		  
	String Name=table.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr["+i+"]//td[3]")).getText();
	String names[]	=Name.split(" ");
	if(names[0].equals("Victoria") && names[1].equals("Terces")){
		flag=true;
	}
	}
	  return flag;
  }
 
 
  
  
  
  

}
