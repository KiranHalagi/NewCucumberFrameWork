package stepDefinitionForDataTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DataTableStepDef {
	WebDriver ch=null;

	@Given("^user is on Actitime login landing page$")
	public void user_is_on_Actitime_login_landing_page() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Library\\Drivers\\chromedriver.exe");
	    ch=new ChromeDriver();
	    ch.manage().window().maximize();
	    ch.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    ch.get("http://localhost/login.do");
	    
	}

	@When("^user login into applicattion with username  and password$")
	public void user_login_into_applicattion_with_username_and_password(DataTable credentials) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<List<String>> values= credentials.raw();
		ch.findElement(By.id("username")).sendKeys(values.get(0).get(0));
		ch.findElement(By.name("pwd")).sendKeys(values.get(0).get(1));
		
		
		
		
	    
	}

	@Then("^Click onLogin Button$")
	public void click_onLogin_Button() throws Throwable {
		ch.findElement(By.id("loginButton")).click();
	    
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
	  
	}
}
