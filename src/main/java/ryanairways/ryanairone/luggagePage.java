package ryanairways.ryanairone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class luggagePage {

	WebDriver driver;

	public luggagePage(WebDriver driver) {
		this.driver = driver;
	}

	public void rFive() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement element = driver.findElement(By.xpath(
				"/html/body/bags-root/bags-booking-container/div/main/div/section[1]/div/bags-cabin-lazy-bag/bags-cabin-bag-section/bags-bag-layout/div/div[3]/div[2]/bags-pax-table-journey-container/div/div/bags-cabin-bag-table-controls-container/bags-cabin-bag-table-controls/div[1]/bags-small-bag-pax-control/div/bags-product-selector/div/div"));

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", element);

		driver.findElement(By.xpath("(//span[contains(@class,'icon-16')]) [1]")).click();
		driver.findElement(By.xpath("(//label[contains(@class,'radio')]) [1]")).click();

		driver.findElement(By.xpath("(//label[contains(@class,'radio')]) [3]")).click();

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		WebElement continueb = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		js.executeScript("arguments[0].scrollIntoView();", continueb);
		continueb.click();
	}
}
