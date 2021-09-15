package ryanairways.ryanairone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
	WebDriver driver;

	public loginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void rSix(String[] username, String[] password) {
		String[] usn = username;
		String[] pwd = password;

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.findElement(By.xpath("/html/body/app-root/ng-component/div/div/div/main/div/button")).click();

		// login

		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

		driver.findElement(By.xpath(
				"//*[@id=\"ry-modal-portal\"]/div/ry-auth-popup-container/div/ry-auth-popup/div/ry-login/form/ry-auth-email/ry-input-d/div/input"))
				.sendKeys(usn);
		driver.findElement(By.xpath(
				"//*[@id=\"ry-modal-portal\"]/div/ry-auth-popup-container/div/ry-auth-popup/div/ry-login/form/ry-auth-password/ry-input-d/div/input"))
				.sendKeys(pwd);
		driver.findElement(By.xpath(
				"//*[@id=\"ry-modal-portal\"]/div/ry-auth-popup-container/div/ry-auth-popup/div/ry-login/form/ry-auth-submit/button"))
				.click();

		driver.switchTo().parentFrame();

		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(
				By.xpath("/html/body/app-root/ng-component/div/div/div/main/div/ng-component/button")));

		WebElement con = driver
				.findElement(By.xpath("/html/body/app-root/ng-component/div/div/div/main/div/ng-component/button"));
		js.executeScript("arguments[0].scrollIntoView();", con);
		con.click();

		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"ry-tooltip-1\"]/div[2]/trip-basket-tooltip/div/div/a[2]")));

		WebElement viewBasket = driver
				.findElement(By.xpath("//*[@id=\"ry-tooltip-1\"]/div[2]/trip-basket-tooltip/div/div/a[2]"));
		js.executeScript("arguments[0].scrollIntoView();", viewBasket);
		viewBasket.click();

		driver.findElement(By.xpath("//button[contains(@color,'yellow')]")).click();
	}
}
