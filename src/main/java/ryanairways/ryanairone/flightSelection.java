package ryanairways.ryanairone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class flightSelection {

	WebDriver driver;

	public flightSelection(WebDriver driver) {
		this.driver = driver;
	}

	public void rThree() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.findElement(By.xpath(
				"/html/body/flights-root/div/div/div/div/flights-lazy-content/flights-summary-container/flights-summary/div/div[1]/journey-container/journey/flight-list/div/flight-card[2]"))
				.click();

		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[contains(@class,'prim')] //button[contains(@class,'fare')]")));

		WebElement value = driver
				.findElement(By.xpath("//*[contains(@class,'prim')] //button[contains(@class,'fare')]"));
		js.executeScript("arguments[0].scrollIntoView();", value);
		value.click();

		/*
		 * wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions
		 * .elementToBeClickable(By.xpath(
		 * "/html/body/flights-root/div/div/div/div/flights-lazy-content/fare-selector-container/fare-selector/div/fare-table-container/fare-table/div[2]/div[1]/fare-card/div/div/button"
		 * )));
		 * 
		 * WebElement value = driver .findElement(By.xpath(
		 * "/html/body/flights-root/div/div/div/div/flights-lazy-content/fare-selector-container/fare-selector/div/fare-table-container/fare-table/div[2]/div[1]/fare-card/div/div/button"
		 * )); js.executeScript("arguments[0].scrollIntoView();", value); value.click();
		 */

		wait.ignoring(StaleElementReferenceException.class).until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@class,'fare-upgra')]) [2]")));

		WebElement continueFareValue = driver.findElement(By.xpath("(//button[contains(@class,'fare-upgra')]) [2]"));
		js.executeScript("arguments[0].scrollIntoView();", continueFareValue);
		continueFareValue.click();

		// //button[contains(text(),'Continue with Value fare')]

		driver.findElement(By.xpath("//span[contains(text(),'Log in later')]")).click();

		driver.findElements(By.xpath("//button[@type='button']")).get(0).click();
		driver.findElement(By.cssSelector("ry-dropdown-item.ng-star-inserted")).click();

		driver.findElement(By.xpath("//input[@name='form.passengers.ADT-0.name']")).sendKeys("first");

		driver.findElement(By.xpath("//input[@name='form.passengers.ADT-0.surname']")).sendKeys("last");

		driver.findElements(By.xpath("//button[@type='button']")).get(1).click();
		driver.findElement(By.cssSelector("ry-dropdown-item.ng-star-inserted")).click();
		driver.findElement(By.xpath("//input[@name='form.passengers.ADT-1.name']")).sendKeys("second");
		driver.findElement(By.xpath("//input[@name='form.passengers.ADT-1.surname']")).sendKeys("last");

		WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		js.executeScript("arguments[0].scrollIntoView();", continueButton);
		continueButton.click();
	}
}
