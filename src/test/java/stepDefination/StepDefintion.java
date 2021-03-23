package stepDefination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
public class StepDefintion {

WebDriver ch=null;
	
	@Given("^user is on Actitime login landing page$")
	public void user_is_on_Actitime_login_landing_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Library\\Drivers\\chromedriver.exe");
		ch=new ChromeDriver();
		ch.manage().window().maximize();
		ch.get("http://localhost/login.do");
		ch.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	 
	}

	@When("^user login into applicattion with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_login_into_applicattion_with_username_and_password(String username, String password) throws Throwable {
	    ch.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
	    ch.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password);
	}

	@Then("^Click onLogin Button$")
	public void click_onLogin_Button() throws Throwable {
	    
	    ch.findElement(By.xpath("//div[text()='Login ']")).click();
	}

	@Then("^Login successful msg should display$")
	public void login_successful_msg_should_display() throws Throwable {
		String actual="Enter Time-Track";
	  String expected= ch.findElement(By.xpath("//td[@class='pagetitle']")).getText();
	  if(actual.equals(expected))
	  {
		  System.out.println("Login is successful");
	  }else
	  {
		  System.out.println("Failed to login into acti time application");
	  }
	  
	  //Handle alert
	 List<WebElement>  oEles=ch.findElements(By.xpath("//div[@id='gettingStartedShortcutsMenuWrapper']"));
	 if(oEles.size()>0)
	 {
		 ch.findElement(By.xpath("//div[@id='gettingStartedShortcutsMenuCloseId']")).click();
	 }else
	 {
		 System.out.println("Popup not disaplayed");
	 }
	  
	 
	  
	 // ch.quit();
	  
	}
	
	@Then("^Click on Users Button$")
	public void click_on_Users_Button() throws Throwable {
	   ch.findElement(By.xpath("//div[text()='USERS']")).click();
	}

	@Then("^Click on AddUser Button$")
	public void click_on_AddUser_Button() throws Throwable {
	   ch.findElement(By.xpath("//div[text()='Add User']")).click();
	   
	   Thread.sleep(3000);
	   if(ch.findElement(By.xpath("//div[@id='userDataLightBox_content']")).isDisplayed())
	   {
		   System.out.println("Create User page opened Successfully");
	   }else
	   {
		   System.out.println("Failed to open the create user page");
	   }
	   
	  
	}
	
	@Then("^Passing all Parameters \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void passing_all_Parameters(String firstname, String lastname, String email, String usernameone, String passwordone, String retypepassword) throws Throwable {
	   
		 ch.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstname);
		 ch.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastname);
		 ch.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		 ch.findElement(By.xpath("//input[@name='username']")).sendKeys(usernameone);
		 ch.findElement(By.xpath("//input[@name='password']")).sendKeys(passwordone);
		 ch.findElement(By.xpath("//input[@name='passwordCopy']")).sendKeys(retypepassword);
		 
		 ch.findElement(By.xpath("//span[text()='Create User']")).click();
		 Thread.sleep(3000);
		
	 if(ch.findElement(By.xpath("//div[@class='name']/span[text()='"+lastname+", "+firstname+"']")).isDisplayed())
			{
				System.out.println("User created successful");
				
			}else {
				System.out.println("Failed to create the user");
			
			}
		 
		 
	}
	



}