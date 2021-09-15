package ryanairways.ryanairone;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seatSelection {
	WebDriver driver;

	public seatSelection(WebDriver driver) {
		this.driver = driver;
	}

	public void rFour() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);

		List<WebElement> seatsavailable = driver.findElements(By.xpath("//button[contains(@id,'seat')]"));

		seatsavailable.size();

		for (int j = 1; j <= 2; j++) {

			driver.findElements(By.xpath("//button[contains(@id,'seat')]")).get(j).click();

		}

		driver.findElement(By.xpath("//button[contains(@class,'gradient')]")).click();

		wait.ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),' No, thanks ')]")));

		WebElement noThanks = driver.findElement(By.xpath("//button[contains(text(),' No, thanks ')]"));
		js.executeScript("arguments[0].scrollIntoView();", noThanks);
		noThanks.click();
	}
}
