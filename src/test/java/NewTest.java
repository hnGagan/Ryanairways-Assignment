import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ryanairways.ryanairone.flightSelection;
import ryanairways.ryanairone.homePage;
import ryanairways.ryanairone.loginPage;
import ryanairways.ryanairone.luggagePage;
import ryanairways.ryanairone.paymentPage;
import ryanairways.ryanairone.seatSelection;

public class NewTest {
  
	@Test
  
	  public void rOne() {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\MyPC\\Documents\\drivers\\chromedriver.exe");
	    	WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        
	        
	       // WebDriverWait wait = new WebDriverWait(driver,10);
	        driver.get("https://www.ryanair.com/ie/en");
	        System.out.println(driver.getTitle());
	        
	        
	        homePage hp = new homePage(driver);
	        String[] destination = {"ams"};
	        hp.rTwo(destination);
	        
	       flightSelection fs = new flightSelection(driver);
	       fs.rThree();
	        
	       seatSelection ss= new seatSelection(driver);
			ss.rFour();
			
			luggagePage lp =new luggagePage(driver);
			lp.rFive();

			String[] username = {"hngagan10@gmail.com"};
			String[] password = {"Ryanair123"};
			loginPage lpage = new loginPage(driver);
			lpage.rSix(username,password);
			
			paymentPage pp = new paymentPage(driver);
			pp.rSeven();
	        
		}
  }

