package ryanairways.ryanairone;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {
	WebDriver driver;

	public homePage(WebDriver driver) {
		this.driver = driver;

	}

	public void rTwo(String[] destination) {
		String[] destPlace = destination;

		By cookies_accept = By.xpath("//button[contains(text(),'Yes, I agree')]");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(cookies_accept));

		driver.findElement(By.xpath("//input[@id='input-button__destination']")).sendKeys(destPlace);
		driver.findElement(By.xpath("//span[contains(text(),'Amsterdam')]")).click();

		// calendar

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement Element = driver.findElement(By.cssSelector("div.datepicker__calendars"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		List<WebElement> date = driver
				.findElements(By.xpath("//*[contains(@class,'datepicker')][2] //div[@data-type='day']"));

		for (int i = 0; i < date.size(); i++) {

			wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[contains(@class,'datepicker')][2] //div[@data-type='day']")));

			String day = driver.findElements(By.xpath("//*[contains(@class,'datepicker')][2] //div[@data-type='day']"))
					.get(i).getText();

			if (day.equalsIgnoreCase("28")) {
				wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(
						By.xpath("//*[contains(@class,'datepicker')][2] //div[@data-type='day']")));
				driver.findElements(By.xpath("//*[contains(@class,'datepicker')][2] //div[@data-type='day']")).get(i)
						.click();
				break;
			}
		}

		WebElement onewayelement = driver.findElement(By.cssSelector("[class='trip-type__icon']"));
		js.executeScript("arguments[0].scrollIntoView();", onewayelement);

		driver.findElement(By.cssSelector("[class='trip-type__icon']")).click();

		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[contains(@class,'passeng')]")).click();
		driver.findElement(By.cssSelector("div.counter__button-wrapper--enabled")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Done')]")).click();
		driver.findElement(By.xpath("//button[@data-ref='flight-search-widget__cta']")).click();

	}
}
